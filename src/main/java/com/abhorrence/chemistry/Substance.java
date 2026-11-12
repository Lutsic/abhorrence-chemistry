package com.abhorrence.chemistry;

import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.RegistryObject;
import mekanism.api.chemical.gas.Gas;
import java.util.function.Supplier;

public class Substance {
    private final ResourceLocation id;
    private final String name;
    private final String formula;
    private final double meltingPoint;
    private final double boilingPoint;
    private final Supplier<Gas> mekanismGas;

    public Substance(
            ResourceLocation id,
            String name,
            String formula,
            double meltingPoint,
            double boilingPoint,
            Supplier<Gas> mekanismGas
    ) {
        this.id = id;
        this.name = name;
        this.formula = formula;
        this.meltingPoint = meltingPoint;
        this.boilingPoint = boilingPoint;
        this.mekanismGas = mekanismGas;
    }

    public ResourceLocation getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getFormula() {
        return formula;
    }

    public double getMeltingPoint() {
        return meltingPoint;
    }

    public double getBoilingPoint() {
        return boilingPoint;
    }

    public Supplier<Gas> getMekanismGas () {
        return mekanismGas;
    }
}

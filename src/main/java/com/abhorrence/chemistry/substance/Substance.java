package com.abhorrence.chemistry.substance;

import net.minecraft.util.ResourceLocation;
import mekanism.api.chemical.gas.Gas;
import java.util.function.Supplier;

public class Substance {
    private final ResourceLocation id;
    private final String name;
    private final String formula;
    private final double meltingPoint;
    private final double boilingPoint;
    private final Supplier<Gas> mekanismGas;

    private final ThermalProperties thermalProperties;

    public Substance(
            ResourceLocation id,
            String name,
            String formula,
            double meltingPoint,
            double boilingPoint,
            Supplier<Gas> mekanismGas,
            ThermalProperties thermalProperties
    )
    {
        if (id == null) {
            throw new IllegalArgumentException("Substance ID cannot be empty");
        }

        if (formula == null || formula.isEmpty()) {
            throw new IllegalArgumentException("Formula cannot be empty");
        }

        if (!Double.isFinite(meltingPoint) ||
                !Double.isFinite(boilingPoint) ||
                meltingPoint >= boilingPoint) {
            throw new IllegalArgumentException(
                    "Invalid phase transition temperatures"
            );
        }
        this.id = id;
        this.name = name;
        this.formula = formula;
        this.meltingPoint = meltingPoint;
        this.boilingPoint = boilingPoint;
        this.mekanismGas = mekanismGas;
        this.thermalProperties = thermalProperties;
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

    public ThermalProperties getThermalProperties() {
        return thermalProperties;
    }

    public PhysicalState getState(double temperature) {
        if (temperature < meltingPoint) {
            return PhysicalState.SOLID;
        }

        if (temperature < boilingPoint) {
            return PhysicalState.LIQUID;
        }

        return PhysicalState.GAS;
    }
}

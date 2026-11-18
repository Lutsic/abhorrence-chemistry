package com.abhorrence.chemistry.registry;

import com.abhorrence.chemistry.ChemistryMod;
import mekanism.api.chemical.gas.Gas;
import mekanism.api.chemical.gas.GasBuilder;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.fml.RegistryObject;

public class ModGases {

    public static final DeferredRegister<Gas> GASES =
            DeferredRegister.create(Gas.class, ChemistryMod.MOD_ID);

    public static final RegistryObject<Gas> HELIUM =
            GASES.register("helium", () ->
                    new Gas(GasBuilder.builder().color(0xFFFFFF))
            );

    public static final RegistryObject<Gas> BERYLLIUM =
            GASES.register("beryllium", () ->
                    new Gas(GasBuilder.builder().color(0xFFFFFF))
            );

    public static final RegistryObject<Gas> OXYGEN =
            GASES.register("oxygen", () ->
                    new Gas(GasBuilder.builder().color(0x80BFFF))
            );
}

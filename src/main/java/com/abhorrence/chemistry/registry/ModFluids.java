package com.abhorrence.chemistry.registry;

import net.minecraftforge.fml.RegistryObject;
import com.abhorrence.chemistry.ChemistryMod;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fluids.FluidAttributes;
import net.minecraftforge.fluids.ForgeFlowingFluid;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraft.fluid.FlowingFluid;

public class ModFluids {

    public static final DeferredRegister<net.minecraft.fluid.Fluid> FLUIDS =
            DeferredRegister.create(
                    ForgeRegistries.FLUIDS,
                    ChemistryMod.MOD_ID
            );

    public static final ResourceLocation HYDROGEN_STILL_TEXTURE =
            new ResourceLocation(ChemistryMod.MOD_ID, "fluid/liquid");

    public static final ResourceLocation HYDROGEN_FLOWING_TEXTURE =
            new ResourceLocation(ChemistryMod.MOD_ID, "fluid/liquid_flow");

    public static final RegistryObject<FlowingFluid> HYDROGEN =
            FLUIDS.register("hydrogen",
                    () -> new ForgeFlowingFluid.Source(
                            hydrogenProperties()
                    )
            );

    public static final RegistryObject<FlowingFluid> FLOWING_HYDROGEN =
            FLUIDS.register("flowing_hydrogen",
                    () -> new ForgeFlowingFluid.Flowing(
                            hydrogenProperties()
                    )
            );

    private static ForgeFlowingFluid.Properties hydrogenProperties() {
        return new ForgeFlowingFluid.Properties(
                HYDROGEN,
                FLOWING_HYDROGEN,
                FluidAttributes.builder(
                                HYDROGEN_STILL_TEXTURE,
                                HYDROGEN_FLOWING_TEXTURE
                        )
                        .density(71)
                        .temperature(14)
                        .viscosity(100)
                        .color(0xFFBDEBFF)
        )
                .block(ModBlocks.HYDROGEN)
                .bucket(ModItems.HYDROGEN_BUCKET);
    }

    public static final ResourceLocation HELIUM_STILL_TEXTURE =
            new ResourceLocation(ChemistryMod.MOD_ID, "fluid/liquid");

    public static final ResourceLocation HELIUM_FLOWING_TEXTURE =
            new ResourceLocation(ChemistryMod.MOD_ID, "fluid/liquid_flow");

    public static final RegistryObject<FlowingFluid> HELIUM =
            FLUIDS.register("helium",
                    () -> new ForgeFlowingFluid.Source(
                            heliumProperties()
                    )
            );

    public static final RegistryObject<FlowingFluid> FLOWING_HELIUM =
            FLUIDS.register("flowing_helium",
                    () -> new ForgeFlowingFluid.Flowing(
                            heliumProperties()
                    )
            );

    private static ForgeFlowingFluid.Properties heliumProperties() {
        return new ForgeFlowingFluid.Properties(
                HELIUM,
                FLOWING_HELIUM,
                FluidAttributes.builder(
                                HELIUM_STILL_TEXTURE,
                                HELIUM_FLOWING_TEXTURE
                        )
                        .density(71)
                        .temperature(14)
                        .viscosity(100)
                        .color(0xFFFFFFFF)
        )
                .block(ModBlocks.HELIUM)
                .bucket(ModItems.HELIUM_BUCKET);
    }

    public static final ResourceLocation LITHIUM_STILL_TEXTURE =
            new ResourceLocation(ChemistryMod.MOD_ID, "fluid/liquid");

    public static final ResourceLocation LITHIUM_FLOWING_TEXTURE =
            new ResourceLocation(ChemistryMod.MOD_ID, "fluid/liquid_flow");

    public static final RegistryObject<FlowingFluid> LITHIUM =
            FLUIDS.register("lithium",
                    () -> new ForgeFlowingFluid.Source(
                            lithiumProperties()
                    )
            );

    public static final RegistryObject<FlowingFluid> FLOWING_LITHIUM =
            FLUIDS.register("flowing_lithium",
                    () -> new ForgeFlowingFluid.Flowing(
                            lithiumProperties()
                    )
            );

    private static ForgeFlowingFluid.Properties lithiumProperties() {
        return new ForgeFlowingFluid.Properties(
                LITHIUM,
                FLOWING_LITHIUM,
                FluidAttributes.builder(
                                LITHIUM_STILL_TEXTURE,
                                LITHIUM_FLOWING_TEXTURE
                        )
                        .density(71)
                        .temperature(14)
                        .viscosity(100)
                        .color(0xDEC369FF)
        )
                .block(ModBlocks.LITHIUM)
                .bucket(ModItems.LITHIUM_BUCKET);
    }

    public static final ResourceLocation BERYLLIUM_STILL_TEXTURE =
            new ResourceLocation(ChemistryMod.MOD_ID, "fluid/liquid");

    public static final ResourceLocation BERYLLIUM_FLOWING_TEXTURE =
            new ResourceLocation(ChemistryMod.MOD_ID, "fluid/liquid_flow");

    public static final RegistryObject<FlowingFluid> BERYLLIUM =
            FLUIDS.register("beryllium",
                    () -> new ForgeFlowingFluid.Source(
                            berylliumProperties()
                    )
            );

    public static final RegistryObject<FlowingFluid> FLOWING_BERYLLIUM =
            FLUIDS.register("flowing_beryllium",
                    () -> new ForgeFlowingFluid.Flowing(
                            berylliumProperties()
                    )
            );

    private static ForgeFlowingFluid.Properties berylliumProperties() {
        return new ForgeFlowingFluid.Properties(
                BERYLLIUM,
                FLOWING_BERYLLIUM,
                FluidAttributes.builder(
                                BERYLLIUM_STILL_TEXTURE,
                                BERYLLIUM_FLOWING_TEXTURE
                        )
                        .density(71)
                        .temperature(14)
                        .viscosity(100)
                        .color(0xBDBDBDFF)
        )
                .block(ModBlocks.BERYLLIUM)
                .bucket(ModItems.BERYLLIUM_BUCKET);
    }
}
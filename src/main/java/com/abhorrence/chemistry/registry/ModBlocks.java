
package com.abhorrence.chemistry.registry;

import com.abhorrence.chemistry.ChemistryMod;
import com.abhorrence.chemistry.block.SolidSubstanceBlock;
import com.abhorrence.chemistry.substance.SubstanceCatalog;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.FlowingFluidBlock;
import com.abhorrence.chemistry.block.EvaporatingFluidBlock;
import net.minecraft.block.material.Material;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.fml.RegistryObject;

public class ModBlocks {

    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(
                    ForgeRegistries.BLOCKS,
                    ChemistryMod.MOD_ID
            );

    public static final RegistryObject<FlowingFluidBlock> HYDROGEN =
            BLOCKS.register("hydrogen",
                    () -> new EvaporatingFluidBlock(
                            ModFluids.HYDROGEN,
                            Block.Properties.create(Material.WATER)
                                    .doesNotBlockMovement()
                                    .hardnessAndResistance(100.0F)
                                    .noDrops(),
                            SubstanceCatalog.HYDROGEN,
                            ModBlocks.SOLID_HYDROGEN
                    )
            );

    public static final RegistryObject<Block> SOLID_HYDROGEN =
            BLOCKS.register("solid_hydrogen",
                    () -> new SolidSubstanceBlock(
                            Block.Properties.create(Material.ROCK)
                                    .hardnessAndResistance(0.5F)
                                    .setRequiresTool(),
                            SubstanceCatalog.HYDROGEN,
                            ModBlocks.HYDROGEN
                    )
            );

    public static final RegistryObject<FlowingFluidBlock> HELIUM =
            BLOCKS.register("helium",
                    () -> new EvaporatingFluidBlock(
                            ModFluids.HELIUM,
                            Block.Properties.create(Material.WATER)
                                    .doesNotBlockMovement()
                                    .hardnessAndResistance(100.0F)
                                    .noDrops(),
                            SubstanceCatalog.HELIUM,
                            ModBlocks.SOLID_HELIUM
                    )
            );

    public static final RegistryObject<Block> SOLID_HELIUM =
            BLOCKS.register("solid_helium",
                    () -> new SolidSubstanceBlock(
                            Block.Properties.create(Material.ROCK)
                                    .hardnessAndResistance(0.5F)
                                    .setRequiresTool(),
                            SubstanceCatalog.HELIUM,
                            ModBlocks.HELIUM
                    )
            );

    public static final RegistryObject<FlowingFluidBlock> LITHIUM =
            BLOCKS.register("lithium",
                    () -> new EvaporatingFluidBlock(
                            ModFluids.LITHIUM,
                            Block.Properties.create(Material.WATER)
                                    .doesNotBlockMovement()
                                    .hardnessAndResistance(100.0F)
                                    .noDrops(),
                            SubstanceCatalog.LITHIUM,
                            ModBlocks.SOLID_LITHIUM
                    )
            );

    public static final RegistryObject<Block> SOLID_LITHIUM =
            BLOCKS.register("solid_lithium",
                    () -> new SolidSubstanceBlock(
                            Block.Properties.create(Material.ROCK)
                                    .hardnessAndResistance(0.5F)
                                    .setRequiresTool(),
                            SubstanceCatalog.LITHIUM,
                            ModBlocks.LITHIUM
                    )
            );

    public static final RegistryObject<FlowingFluidBlock> BERYLLIUM =
            BLOCKS.register("beryllium",
                    () -> new EvaporatingFluidBlock(
                            ModFluids.BERYLLIUM,
                            Block.Properties.create(Material.WATER)
                                    .doesNotBlockMovement()
                                    .hardnessAndResistance(100.0F)
                                    .noDrops(),
                            SubstanceCatalog.BERYLLIUM,
                            ModBlocks.SOLID_BERYLLIUM
                    )
            );

    public static final RegistryObject<Block> SOLID_BERYLLIUM =
            BLOCKS.register("solid_beryllium",
                    () -> new SolidSubstanceBlock(
                            Block.Properties.create(Material.ROCK)
                                    .hardnessAndResistance(0.5F)
                                    .setRequiresTool(),
                            SubstanceCatalog.BERYLLIUM,
                            ModBlocks.BERYLLIUM
                    )
            );

    public static final RegistryObject<FlowingFluidBlock> BORON =
            BLOCKS.register("boron",
                    () -> new EvaporatingFluidBlock(
                            ModFluids.BORON,
                            Block.Properties.create(Material.WATER)
                                    .doesNotBlockMovement()
                                    .hardnessAndResistance(100.0F)
                                    .noDrops(),
                            SubstanceCatalog.BORON,
                            ModBlocks.SOLID_BORON
                    )
            );

    public static final RegistryObject<Block> SOLID_BORON =
            BLOCKS.register("solid_boron",
                    () -> new SolidSubstanceBlock(
                            Block.Properties.create(Material.ROCK)
                                    .hardnessAndResistance(0.5F)
                                    .setRequiresTool(),
                            SubstanceCatalog.BORON,
                            ModBlocks.BORON
                    )
            );

    public static final RegistryObject<FlowingFluidBlock> CARBON =
            BLOCKS.register("carbon",
                    () -> new EvaporatingFluidBlock(
                            ModFluids.CARBON,
                            Block.Properties.create(Material.WATER)
                                    .doesNotBlockMovement()
                                    .hardnessAndResistance(100.0F)
                                    .noDrops(),
                            SubstanceCatalog.CARBON,
                            () -> Blocks.COAL_BLOCK
                    )
            );
}


package com.abhorrence.chemistry.registry;

import com.abhorrence.chemistry.ChemistryMod;
import com.abhorrence.chemistry.block.SolidSubstanceBlock;
import com.abhorrence.chemistry.substance.SubstanceCatalog;
import net.minecraft.block.Block;
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
                            Block.Properties.of(Material.WATER)
                                    .noCollission()
                                    .strength(100.0F)
                                    .noDrops(),
                            SubstanceCatalog.HYDROGEN,
                            ModBlocks.SOLID_HYDROGEN
                    )
            );

    public static final RegistryObject<Block> SOLID_HYDROGEN =
            BLOCKS.register("solid_hydrogen",
                    () -> new SolidSubstanceBlock(
                            Block.Properties.of(Material.STONE)
                                    .strength(0.5F)
                                    .requiresCorrectToolForDrops(),
                            SubstanceCatalog.HYDROGEN,
                            ModBlocks.HYDROGEN
                    )
            );
}

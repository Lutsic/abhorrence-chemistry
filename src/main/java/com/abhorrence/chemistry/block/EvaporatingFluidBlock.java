
package com.abhorrence.chemistry.block;

import com.abhorrence.chemistry.substance.Substance;
import com.abhorrence.chemistry.world.PhaseTransitionHandler;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.FlowingFluidBlock;
import net.minecraft.fluid.FlowingFluid;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;

import java.util.Random;
import java.util.function.Supplier;

import net.minecraft.block.AbstractBlock.Properties;

public class EvaporatingFluidBlock extends FlowingFluidBlock {

    private final Substance substance;
    private final Supplier<? extends Block> solidBlock;

    public EvaporatingFluidBlock(
            Supplier<? extends FlowingFluid> fluid,
            Properties properties,
            Substance substance,
            Supplier<? extends Block> solidBlock
    ) {
        super(fluid, properties);

        this.substance = substance;
        this.solidBlock = solidBlock;
    }

    @Override
    public void onBlockAdded(
            BlockState state,
            World world,
            BlockPos pos,
            BlockState oldState,
            boolean isMoving
    ) {
        super.onBlockAdded(state, world, pos, oldState, isMoving);

        if (oldState.getBlock() != this) {
            PhaseTransitionHandler.scheduleFluidTransition(
                    world, pos, this, substance, solidBlock
            );
        }
    }

    @Override
    public void tick(
            BlockState state,
            ServerWorld world,
            BlockPos pos,
            Random random
    ) {
        PhaseTransitionHandler.handleFluidTransition(
                world, pos, this, substance, solidBlock
        );
    }
}

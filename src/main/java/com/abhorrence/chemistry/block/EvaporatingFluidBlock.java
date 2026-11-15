
package com.abhorrence.chemistry.block;

import com.abhorrence.chemistry.substance.Substance;
import com.abhorrence.chemistry.world.PhaseTransitionHandler;

import net.minecraft.block.BlockState;
import net.minecraft.block.FlowingFluidBlock;
import net.minecraft.fluid.FlowingFluid;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;

import java.util.Random;
import java.util.function.Supplier;

public class EvaporatingFluidBlock extends FlowingFluidBlock {

    private final Substance substance;

    public EvaporatingFluidBlock(
            Supplier<? extends FlowingFluid> fluid,
            Properties properties,
            Substance substance
    ) {
        super(fluid, properties);
        this.substance = substance;
    }

    @Override
    public void onPlace(
            BlockState state,
            World world,
            BlockPos pos,
            BlockState oldState,
            boolean isMoving
    ) {
        super.onPlace(state, world, pos, oldState, isMoving);

        if (oldState.getBlock() != this) {
            PhaseTransitionHandler.scheduleEvaporation(
                    world,
                    pos,
                    this,
                    substance
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
        PhaseTransitionHandler.handleEvaporation(
                world,
                pos,
                state,
                this,
                substance
        );
    }
}

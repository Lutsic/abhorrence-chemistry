package com.abhorrence.chemistry.block;

import com.abhorrence.chemistry.substance.PhysicalState;
import com.abhorrence.chemistry.substance.Substance;
import com.abhorrence.chemistry.substance.Thermodynamics;
import com.abhorrence.chemistry.environment.WorldEnvironment;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;

import java.util.Random;
import java.util.function.Supplier;

public class SolidSubstanceBlock extends Block {

    private final Substance substance;
    private final Supplier<? extends Block> liquidBlock;

    public SolidSubstanceBlock(
            Properties properties,
            Substance substance,
            Supplier<? extends Block> liquidBlock
    ) {
        super(properties);

        this.substance = substance;
        this.liquidBlock = liquidBlock;
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
            scheduleMelting(world, pos);
        }
    }

    private void scheduleMelting(World world, BlockPos pos) {
        if (!(world instanceof ServerWorld)) {
            return;
        }

        double temperature = WorldEnvironment.getTemperature(world, pos);

        PhysicalState physicalState =
                Thermodynamics.getState(substance, temperature);

        if (physicalState == PhysicalState.SOLID) {
            return;
        }

        int delay = substance.getThermalProperties().getMeltingTimeTicks();

        ServerWorld serverWorld = (ServerWorld) world;
        serverWorld.getBlockTicks().scheduleTick(pos, this, delay);
    }

    @Override
    public void tick(
            BlockState state,
            ServerWorld world,
            BlockPos pos,
            Random random
    ) {
        if (world.getBlockState(pos).getBlock() != this) {
            return;
        }

        double temperature = WorldEnvironment.getTemperature(world, pos);

        PhysicalState physicalState =
                Thermodynamics.getState(substance, temperature);

        if (physicalState != PhysicalState.SOLID) {
            world.setBlock(
                    pos,
                    liquidBlock.get().defaultBlockState(),
                    3
            );
        }
    }
}
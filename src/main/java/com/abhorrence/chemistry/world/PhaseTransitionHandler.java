package com.abhorrence.chemistry.world;

import com.abhorrence.chemistry.environment.WorldEnvironment;
import com.abhorrence.chemistry.substance.PhysicalState;
import com.abhorrence.chemistry.substance.Substance;
import com.abhorrence.chemistry.substance.Thermodynamics;

import java.util.function.Supplier;


import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.FlowingFluidBlock;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;

public final class PhaseTransitionHandler {

    private PhaseTransitionHandler() {
    }

    public static void scheduleEvaporation(
            World world,
            BlockPos pos,
            Block block,
            Substance substance
    ) {
        if (!(world instanceof ServerWorld)) {
            return;
        }

        double temperature =
                WorldEnvironment.getTemperature(world, pos);

        int delay = Thermodynamics.getEvaporationTime(
                substance,
                temperature
        );

        System.out.println(
                "[Chemistry] Scheduling evaporation: "
                        + substance.getId()
                        + ", temperature=" + temperature
                        + "K, delay=" + delay
        );

        if (delay < 1) {
            return;
        }

        ServerWorld serverWorld = (ServerWorld) world;

        serverWorld.getPendingBlockTicks().scheduleTick(
                pos,
                block,
                delay
        );
    }

    public static void handleEvaporation(
            ServerWorld world,
            BlockPos pos,
            BlockState state,
            Block block,
            Substance substance
    ) {
        if (state.getBlock() != block) {
            return;
        }

        double temperature =
                WorldEnvironment.getTemperature(world, pos);

        if (Thermodynamics.shouldEvaporate(substance, temperature)) {
            boolean removed = world.setBlockState(
                    pos,
                    net.minecraft.block.Blocks.AIR.getDefaultState(),
                    3
            );
        }
    }

    public static void scheduleFluidTransition(
            World world,
            BlockPos pos,
            Block block,
            Substance substance,
            Supplier<? extends Block> solidBlock
    ) {
        if (!(world instanceof ServerWorld)) {
            return;
        }

        double temperature = WorldEnvironment.getTemperature(world, pos);

        PhysicalState state = Thermodynamics.getState(
                substance,
                temperature
        );

        int delay;

        if (state == PhysicalState.GAS) {
            delay = substance.getThermalProperties()
                    .getEvaporationTimeTicks();
        } else if (state == PhysicalState.SOLID) {
            delay = substance.getThermalProperties()
                    .getMeltingTimeTicks();
        } else {
            return;
        }

        ServerWorld serverWorld = (ServerWorld) world;
        serverWorld.getPendingBlockTicks().scheduleTick(pos, block, delay);
    }

    public static void handleFluidTransition(
            ServerWorld world,
            BlockPos pos,
            Block block,
            Substance substance,
            Supplier<? extends Block> solidBlock
    ) {
        if (world.getBlockState(pos).getBlock() != block) {
            return;
        }

        double temperature = WorldEnvironment.getTemperature(world, pos);

        PhysicalState state = Thermodynamics.getState(
                substance,
                temperature
        );

        if (state == PhysicalState.GAS) {
            world.setBlockState(
                    pos,
                    Blocks.AIR.getDefaultState(),
                    3
            );
        } else if (state == PhysicalState.SOLID) {

            if (!(world.getBlockState(pos).getBlock()
                    instanceof FlowingFluidBlock)) {
                return;
            }

            int level = world.getBlockState(pos)
                    .get(FlowingFluidBlock.LEVEL);

            if (level != 0) {
                return;
            }

            world.setBlockState(
                    pos,
                    solidBlock.get().getDefaultState(),
                    3
            );
        }
    }
}

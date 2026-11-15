package com.abhorrence.chemistry.world;

import com.abhorrence.chemistry.environment.WorldEnvironment;
import com.abhorrence.chemistry.substance.Substance;
import com.abhorrence.chemistry.substance.Thermodynamics;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
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

        serverWorld.getBlockTicks().scheduleTick(
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
            boolean removed = world.setBlock(
                    pos,
                    net.minecraft.block.Blocks.AIR.defaultBlockState(),
                    3
            );
        }
    }
}

package com.abhorrence.chemistry.environment;

import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class WorldEnvironment {

    public static final double DEFAULT_TEMPERATURE = 300.0;

    public static double getTemperature(World world, BlockPos pos) {
        return DEFAULT_TEMPERATURE;
    }
}

package com.abhorrence.chemistry.substance;

public final class Thermodynamics {

    private Thermodynamics() {
    }

    public static PhysicalState getState(
            Substance substance,
            double temperature
    ) {
        if (substance == null) {
            throw new IllegalArgumentException("Substance cannot be null");
        }

        if (!Double.isFinite(temperature) || temperature < 0) {
            throw new IllegalArgumentException(
                    "Temperature must be a finite non-negative value"
            );
        }

        if (temperature < substance.getMeltingPoint()) {
            return PhysicalState.SOLID;
        }

        if (temperature < substance.getBoilingPoint()) {
            return PhysicalState.LIQUID;
        }

        return PhysicalState.GAS;
    }

    public static boolean shouldEvaporate(
            Substance substance,
            double environmentTemperature
    ) {
        return getState(substance, environmentTemperature)
                == PhysicalState.GAS;
    }

    public static int getEvaporationTime(
            Substance substance,
            double environmentTemperature
    ) {
        if (!shouldEvaporate(substance, environmentTemperature)) {
            return -1;
        }

        return substance.getThermalProperties()
                .getEvaporationTimeTicks();
    }
}

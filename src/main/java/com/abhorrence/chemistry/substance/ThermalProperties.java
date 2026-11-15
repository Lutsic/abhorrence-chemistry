
package com.abhorrence.chemistry.substance;

public class ThermalProperties {

    private final int evaporationTimeTicks;

    public ThermalProperties(int evaporationTimeTicks) {
        if (evaporationTimeTicks < 1) {
            throw new IllegalArgumentException(
                    "Evaporation time must be at least 1 tick"
            );
        }

        this.evaporationTimeTicks = evaporationTimeTicks;
    }

    public int getEvaporationTimeTicks() {
        return evaporationTimeTicks;
    }
}

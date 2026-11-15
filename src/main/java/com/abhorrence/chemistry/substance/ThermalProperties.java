
package com.abhorrence.chemistry.substance;

public class ThermalProperties {
    private final int meltingTimeTicks;
    private final int evaporationTimeTicks;

    public ThermalProperties(int meltingTimeTicks, int evaporationTimeTicks) {
        if (meltingTimeTicks < 1 || evaporationTimeTicks < 1) {
            throw new IllegalArgumentException(
                    "Transition times must be at least 1 tick"
            );
        }

        this.meltingTimeTicks = meltingTimeTicks;
        this.evaporationTimeTicks = evaporationTimeTicks;
    }

    public int getMeltingTimeTicks() {
        return meltingTimeTicks;
    }

    public int getEvaporationTimeTicks() {
        return evaporationTimeTicks;
    }
}


package com.abhorrence.chemistry;

import net.minecraft.util.ResourceLocation;

import java.util.HashMap;
import java.util.Map;
import com.abhorrence.chemistry.registry.ModGases;
import mekanism.common.registries.MekanismGases;

public class SubstanceCatalog {
    private static final Map<ResourceLocation, Substance> SUBSTANCES =
            new HashMap<>();

    public static final Substance HYDROGEN = register(
            new Substance(
                    new ResourceLocation("chemistry", "hydrogen"),
                    "Hydrogen",
                    "H2",
                    13.99,
                    20.271,
                    MekanismGases.HYDROGEN
            )
    );

    public static final Substance OXYGEN = register(
            new Substance(
                    new ResourceLocation("chemistry", "oxygen"),
                    "Oxygen",
                    "O2",
                    54.36,
                    90.19,
                    MekanismGases.OXYGEN
            )
    );

    private static Substance register(Substance substance) {
        if (SUBSTANCES.putIfAbsent(
                substance.getId(), substance
        ) != null) {
            throw new IllegalArgumentException(
                    "Duplicate substance: " + substance.getId()
            );
        }

        return substance;
    }

    public static Substance get(ResourceLocation id) {
        return SUBSTANCES.get(id);
    }
}

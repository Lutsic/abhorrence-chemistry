
package com.abhorrence.chemistry.substance;

import com.abhorrence.chemistry.registry.ModGases;
import net.minecraft.util.ResourceLocation;

import java.util.HashMap;
import java.util.Map;

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
                    MekanismGases.HYDROGEN,
                    new ThermalProperties(40, 40)
            )
    );

    public static final Substance HELIUM = register(
            new Substance(
                    new ResourceLocation("chemistry", "helium"),
                    "Helium",
                    "He",
                    0.95,
                    4.22,
                    ModGases.HELIUM,
                    new ThermalProperties(40, 40)
            )
    );

    public static final Substance LITHIUM = register(
            new Substance(
                    new ResourceLocation("chemistry", "lithium"),
                    "Lithium",
                    "Li",
                    453.65,
                    1615,
                    MekanismGases.LITHIUM,
                    new ThermalProperties(40, 40)
            )
    );

    public static final Substance BERYLLIUM = register(
            new Substance(
                    new ResourceLocation("chemistry", "beryllium"),
                    "Beryllium",
                    "Be",
                    1560,
                    2742,
                    ModGases.BERYLLIUM,
                    new ThermalProperties(40, 40)
            )
    );

    public static final Substance BORON = register(
            new Substance(
                    new ResourceLocation("chemistry", "boron"),
                    "Boron",
                    "B",
                    2349,
                    4200,
                    ModGases.BORON,
                    new ThermalProperties(40, 40)
            )
    );

    public static final Substance OXYGEN = register(
            new Substance(
                    new ResourceLocation("chemistry", "oxygen"),
                    "Oxygen",
                    "O2",
                    54.36,
                    90.19,
                    MekanismGases.OXYGEN,
                    new ThermalProperties(60, 60)
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

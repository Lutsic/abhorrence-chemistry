package com.abhorrence.chemistry.recipe;

import net.minecraft.util.ResourceLocation;

public class RecipeModifications {

    public static void apply(RecipeEditor editor) {
        editor.remove("mekanism:rotary/hydrogen");
        editor.remove("mekanism:rotary/lithium");

        editor.remove("mekanism:module_frost_walker_unit");

    }
}

package com.abhorrence.chemistry.recipe;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import net.minecraft.item.crafting.IRecipe;
import net.minecraft.item.crafting.RecipeManager;
import net.minecraft.util.ResourceLocation;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class RecipeEditor {

    private final RecipeManager manager;
    private final List<IRecipe<?>> recipes;

    public RecipeEditor(RecipeManager manager) {
        this.manager = manager;
        this.recipes = new ArrayList<>(manager.getRecipes());
    }

    public boolean remove(ResourceLocation id) {
        return recipes.removeIf(recipe ->
                recipe.getId().equals(id)
        );
    }

    public boolean remove(String id) {
        return remove(new ResourceLocation(id));
    }

    public int removeIf(Predicate<IRecipe<?>> predicate) {
        int before = recipes.size();

        recipes.removeIf(predicate);

        return before - recipes.size();
    }

    public int removeMod(String modId) {
        return removeIf(recipe ->
                recipe.getId().getNamespace().equals(modId)
        );
    }

    public int size() {
        return recipes.size();
    }

    void apply() {
        manager.replaceRecipes(recipes);
    }
}

package com.abhorrence.chemistry.registry;

import com.abhorrence.chemistry.registry.ModItems;

import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;

public class ModItemGroups {

    public static final ItemGroup CHEMISTRY =
            new ItemGroup("chemistry") {
                @Override
                public ItemStack makeIcon() {
                    return new ItemStack(ModItems.HYDROGEN_BUCKET.get());
                }
            };
}
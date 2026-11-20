package com.abhorrence.chemistry.registry;

import com.abhorrence.chemistry.registry.ModItems;

import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class ModItemGroups {

    public static final ItemGroup CHEMISTRY =
            new ItemGroup("chemistry") {

                @Override
                public ItemStack createIcon() {
                    return new ItemStack(ModItems.HYDROGEN_BUCKET.get());
                }

                @Override
                public void fill(NonNullList<ItemStack> items) {
                    super.fill(items);

                    List<Item> itemOrder = Arrays.asList(
                            ModItems.HYDROGEN_BUCKET.get(),
                            ModItems.SOLID_HYDROGEN.get(),
                            ModItems.SOLID_HYDROGEN_ITEM.get(),

                            ModItems.HELIUM_BUCKET.get(),
                            ModItems.SOLID_HELIUM.get(),
                            ModItems.SOLID_HELIUM_ITEM.get(),

                            ModItems.LITHIUM_BUCKET.get(),
                            ModItems.SOLID_LITHIUM.get(),
                            ModItems.SOLID_LITHIUM_ITEM.get(),
                            ModItems.SOLID_LITHIUM_NUGGET.get(),

                            ModItems.BERYLLIUM_BUCKET.get(),
                            ModItems.SOLID_BERYLLIUM.get(),
                            ModItems.SOLID_BERYLLIUM_ITEM.get(),
                            ModItems.SOLID_BERYLLIUM_NUGGET.get(),
                            ModItems.SOLID_BERYLLIUM_DUST.get(),

                            ModItems.BORON_BUCKET.get(),
                            ModItems.SOLID_BORON.get(),
                            ModItems.SOLID_BORON_ITEM.get()
                    );

                    items.sort(Comparator.comparingInt(stack -> {
                        int index = itemOrder.indexOf(stack.getItem());
                        return index == -1 ? Integer.MAX_VALUE : index;
                    }));
                }
            };
}
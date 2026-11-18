
package com.abhorrence.chemistry.registry;

import com.abhorrence.chemistry.ChemistryMod;
import net.minecraft.item.*;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.fml.RegistryObject;

public class ModItems {

    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(
                    ForgeRegistries.ITEMS,
                    ChemistryMod.MOD_ID
            );

    public static final RegistryObject<Item> HYDROGEN_BUCKET =
            ITEMS.register("hydrogen_bucket",
                    () -> new BucketItem(
                            ModFluids.HYDROGEN,
                            new Item.Properties()
                                    .craftRemainder(Items.BUCKET)
                                    .stacksTo(1)
                                    .tab(ModItemGroups.CHEMISTRY)
                    )
            );

    public static final RegistryObject<Item> SOLID_HYDROGEN =
            ITEMS.register("solid_hydrogen",
                    () -> new BlockItem(
                            ModBlocks.SOLID_HYDROGEN.get(),
                            new Item.Properties()
                                    .tab(ModItemGroups.CHEMISTRY)
                    )
            );

    public static final RegistryObject<Item> SOLID_HYDROGEN_ITEM =
            ITEMS.register("solid_hydrogen_item",
                    () -> new Item(
                            new Item.Properties()
                            .tab(ModItemGroups.CHEMISTRY)
                    )
            );

    public static final RegistryObject<Item> HELIUM_BUCKET =
            ITEMS.register("helium_bucket",
                    () -> new BucketItem(
                            ModFluids.HELIUM,
                            new Item.Properties()
                                    .craftRemainder(Items.BUCKET)
                                    .stacksTo(1)
                                    .tab(ModItemGroups.CHEMISTRY)
                    )
            );

    public static final RegistryObject<Item> SOLID_HELIUM =
            ITEMS.register("solid_helium",
                    () -> new BlockItem(
                            ModBlocks.SOLID_HELIUM.get(),
                            new Item.Properties()
                                    .tab(ModItemGroups.CHEMISTRY)
                    )
            );

    public static final RegistryObject<Item> SOLID_HELIUM_ITEM =
            ITEMS.register("solid_helium_item",
                    () -> new Item(
                            new Item.Properties()
                                    .tab(ModItemGroups.CHEMISTRY)
                    )
            );

    public static final RegistryObject<Item> LITHIUM_BUCKET =
            ITEMS.register("lithium_bucket",
                    () -> new BucketItem(
                            ModFluids.LITHIUM,
                            new Item.Properties()
                                    .craftRemainder(Items.BUCKET)
                                    .stacksTo(1)
                                    .tab(ModItemGroups.CHEMISTRY)
                    )
            );

    public static final RegistryObject<Item> SOLID_LITHIUM =
            ITEMS.register("solid_lithium",
                    () -> new BlockItem(
                            ModBlocks.SOLID_LITHIUM.get(),
                            new Item.Properties()
                                    .tab(ModItemGroups.CHEMISTRY)
                    )
            );

    public static final RegistryObject<Item> SOLID_LITHIUM_ITEM =
            ITEMS.register("solid_lithium_item",
                    () -> new Item(
                            new Item.Properties()
                                    .tab(ModItemGroups.CHEMISTRY)
                    )
            );

    public static final RegistryObject<Item> SOLID_LITHIUM_NUGGET =
            ITEMS.register("solid_lithium_nugget",
                    () -> new Item(
                            new Item.Properties()
                                    .tab(ModItemGroups.CHEMISTRY)
                    )
            );

    public static final RegistryObject<Item> BERYLLIUM_BUCKET =
            ITEMS.register("beryllium_bucket",
                    () -> new BucketItem(
                            ModFluids.BERYLLIUM,
                            new Item.Properties()
                                    .craftRemainder(Items.BUCKET)
                                    .stacksTo(1)
                                    .tab(ModItemGroups.CHEMISTRY)
                    )
            );

    public static final RegistryObject<Item> SOLID_BERYLLIUM =
            ITEMS.register("solid_beryllium",
                    () -> new BlockItem(
                            ModBlocks.SOLID_BERYLLIUM.get(),
                            new Item.Properties()
                                    .tab(ModItemGroups.CHEMISTRY)
                    )
            );

    public static final RegistryObject<Item> SOLID_BERYLLIUM_ITEM =
            ITEMS.register("solid_beryllium_item",
                    () -> new Item(
                            new Item.Properties()
                                    .tab(ModItemGroups.CHEMISTRY)
                    )
            );

    public static final RegistryObject<Item> SOLID_BERYLLIUM_NUGGET =
            ITEMS.register("solid_beryllium_nugget",
                    () -> new Item(
                            new Item.Properties()
                                    .tab(ModItemGroups.CHEMISTRY)
                    )
            );
}

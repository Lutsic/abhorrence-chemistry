
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
}

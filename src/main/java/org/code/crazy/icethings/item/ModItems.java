package org.code.crazy.icethings.item;

import net.fabricmc.fabric.api.creativetab.v1.CreativeModeTabEvents;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.component.Consumable;
import net.minecraft.world.item.component.Consumables;
import org.code.crazy.Icethings;
import org.code.crazy.icethings.food.ModFoods;

import java.util.function.Function;

public class ModItems {

    public static final Item ICE1 = registerItem("ice1", Item::new, new Item.Properties().food(ModFoods.ICE1f).rarity(Rarity.COMMON));

    private static Item registerItem(String name, Function<Item.Properties, Item> function, Item.Properties properties) {
        ResourceKey<Item> key = ResourceKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath(Icethings.MOD_ID, name));
        return Registry.register(BuiltInRegistries.ITEM, Identifier.fromNamespaceAndPath(Icethings.MOD_ID, name),
                function.apply(properties.setId(key)));
    }

    public static void registerModItems() {
        Icethings.LOGGER.info("Registering ModItems");

        CreativeModeTabEvents.modifyOutputEvent(CreativeModeTabs.NATURAL_BLOCKS).register(output -> {
            output.accept(ICE1);
        });
    }

}
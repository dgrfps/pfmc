package dgrfps.pfmc.items;

import dgrfps.pfmc.Main;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.fabricmc.fabric.api.registry.CompostingChanceRegistry;
import net.minecraft.item.FoodComponents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ItemRegistry {
    public static final Item POOP = registerItem("poop", new PoopItem(new FabricItemSettings().food(FoodComponents.ROTTEN_FLESH)));
    public static void Init()
    {
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.NATURAL).register((e) -> {
            e.add(POOP);
        });

        CompostingChanceRegistry.INSTANCE.add(POOP, 2f);
    }
    public static Item registerItem(String name, Item item)
    {
        return Registry.register(Registries.ITEM, new Identifier(Main.MODID, name), item);
    }
}

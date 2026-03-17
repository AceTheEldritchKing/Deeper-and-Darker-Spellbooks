package net.rev.darkermagic.item;

import io.redspace.ironsspellbooks.api.item.weapons.ExtendedSwordItem;
import io.redspace.ironsspellbooks.api.registry.SpellDataRegistryHolder;
import io.redspace.ironsspellbooks.api.registry.SpellRegistry;
import io.redspace.ironsspellbooks.util.ItemPropertiesHelper;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.rev.darkermagic.DarkerMagic;
import net.rev.darkermagic.item.armor.WardenMageArmorItem;
import net.rev.darkermagic.item.curios.VolumeOfTheDeep;
import net.rev.darkermagic.item.staffs.DDISSStaffTiers;
import net.rev.darkermagic.item.staffs.WhispersStaffItem;

public class DDISSItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(DarkerMagic.MODID);

    public static final DeferredItem<Item> WARDEN_STICK = ITEMS.register("warden_stick",
            () -> new Item(new Item.Properties().fireResistant()));

    public static final DeferredHolder<Item, Item> WARDEN_MAGE_HELMET = ITEMS.register("warden_mage_helmet", () -> new WardenMageArmorItem(ArmorItem.Type.HELMET, ItemPropertiesHelper.equipment(1).durability(ArmorItem.Type.HELMET.getDurability(37)).fireResistant()));
    public static final DeferredHolder<Item, Item> WARDEN_MAGE_CHESTPLATE = ITEMS.register("warden_mage_chestplate", () -> new WardenMageArmorItem(ArmorItem.Type.CHESTPLATE, ItemPropertiesHelper.equipment(1).durability(ArmorItem.Type.CHESTPLATE.getDurability(37)).fireResistant()));
    public static final DeferredHolder<Item, Item> WARDEN_MAGE_LEGGINGS = ITEMS.register("warden_mage_leggings", () -> new WardenMageArmorItem(ArmorItem.Type.LEGGINGS, ItemPropertiesHelper.equipment(1).durability(ArmorItem.Type.LEGGINGS.getDurability(37)).fireResistant()));
    public static final DeferredHolder<Item, Item> WARDEN_MAGE_BOOTS = ITEMS.register("warden_mage_boots", () -> new WardenMageArmorItem(ArmorItem.Type.BOOTS, ItemPropertiesHelper.equipment(1).durability(ArmorItem.Type.BOOTS.getDurability(37)).fireResistant()));

    public static final DeferredHolder<Item, Item> WHISPER_STAFF = ITEMS.register("whisper_staff", () ->
            new WhispersStaffItem(ItemPropertiesHelper.equipment(1).rarity(Rarity.EPIC).attributes(ExtendedSwordItem.createAttributes(DDISSStaffTiers.WHISPERS_STAFF))
                    .fireResistant(), SpellDataRegistryHolder.of(new SpellDataRegistryHolder(SpellRegistry.SONIC_BOOM_SPELL, 3))));
    public static final DeferredHolder<Item, Item> VOLUME_OF_THE_DEEP = ITEMS.register("volume_of_the_deep", VolumeOfTheDeep::new);

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}

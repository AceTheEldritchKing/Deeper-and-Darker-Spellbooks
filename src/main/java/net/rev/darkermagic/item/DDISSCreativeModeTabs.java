package net.rev.darkermagic.item;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ItemLike;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.rev.darkermagic.DarkerMagic;

import java.util.function.Supplier;

public class DDISSCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TAB =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, DarkerMagic.MODID);

    public static final Supplier<CreativeModeTab> DARKER_MAGIC = CREATIVE_MODE_TAB.register("darker_magic",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(DDISSItems.WARDEN_STICK.get()))
                    .title(Component.translatable("creativetab.darkermagic.darker_magic"))
                    .displayItems((itemDisplayParameters, output) -> {
                        output.accept((ItemLike) DDISSItems.WARDEN_MAGE_HELMET);
                        output.accept((ItemLike) DDISSItems.WARDEN_MAGE_CHESTPLATE);
                        output.accept((ItemLike) DDISSItems.WARDEN_MAGE_LEGGINGS);
                        output.accept((ItemLike) DDISSItems.WARDEN_MAGE_BOOTS);
                        output.accept((ItemLike) DDISSItems.VOLUME_OF_THE_DEEP);
                        output.accept((ItemLike) DDISSItems.WHISPER_STAFF);
                        output.accept(DDISSItems.WARDEN_STICK);

                    }).build());

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TAB.register(eventBus);
    }
}

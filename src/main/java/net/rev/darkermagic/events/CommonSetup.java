package net.rev.darkermagic.events;

import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.entity.EntityAttributeCreationEvent;
import net.rev.darkermagic.DarkerMagic;
import net.rev.darkermagic.entity.mobs.SummonedSculkCentipede;
import net.rev.darkermagic.entity.mobs.SummonedSculkSnapper;
import net.rev.darkermagic.entity.mobs.SummonedShattered;
import net.rev.darkermagic.entity.mobs.SummonedWarden;
import net.rev.darkermagic.item.DDISSEntityRegistery;

@EventBusSubscriber(modid = DarkerMagic.MODID, value = Dist.CLIENT)
public class CommonSetup {
    @SubscribeEvent
    public static void onAttributeCreate(EntityAttributeCreationEvent event) {
        event.put(DDISSEntityRegistery.SUMMONED_WARDEN.get(), SummonedWarden.createAttributes().build());
        event.put(DDISSEntityRegistery.SUMMONED_SHATTERED.get(), SummonedShattered.createAttributes());
        event.put(DDISSEntityRegistery.SUMMONED_SCULK_CENTIPEDE.get(), SummonedSculkCentipede.createAttributes());
        event.put(DDISSEntityRegistery.SUMMONED_SCULK_SNAPPER.get(), SummonedSculkSnapper.createAttributes());
    }
}

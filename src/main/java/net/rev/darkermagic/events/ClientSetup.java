package net.rev.darkermagic.events;

import com.kyanite.deeperdarker.client.render.SculkCentipedeRenderer;
import com.kyanite.deeperdarker.client.render.SculkSnapperRenderer;
import com.kyanite.deeperdarker.client.render.ShatteredRenderer;
import net.minecraft.client.renderer.entity.WardenRenderer;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.EntityRenderersEvent;
import net.rev.darkermagic.DarkerMagic;
import net.rev.darkermagic.item.DDISSEntityRegistery;

@EventBusSubscriber(modid = DarkerMagic.MODID, value = Dist.CLIENT)
public class ClientSetup {
    @SubscribeEvent
    public static void rendererRegister(EntityRenderersEvent.RegisterRenderers event) {
        event.registerEntityRenderer(DDISSEntityRegistery.SUMMONED_WARDEN.get(), WardenRenderer::new);
        event.registerEntityRenderer(DDISSEntityRegistery.SUMMONED_SHATTERED.get(), ShatteredRenderer::new);
        event.registerEntityRenderer(DDISSEntityRegistery.SUMMONED_SCULK_CENTIPEDE.get(), SculkCentipedeRenderer::new);
        event.registerEntityRenderer(DDISSEntityRegistery.SUMMONED_SCULK_SNAPPER.get(), SculkSnapperRenderer::new);
    }
}

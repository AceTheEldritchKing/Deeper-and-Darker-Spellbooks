package net.rev.darkermagic.item;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.rev.darkermagic.DarkerMagic;
import net.rev.darkermagic.entity.mobs.SummonedSculkCentipede;
import net.rev.darkermagic.entity.mobs.SummonedSculkSnapper;
import net.rev.darkermagic.entity.mobs.SummonedShattered;
import net.rev.darkermagic.entity.mobs.SummonedWarden;

public class DDISSEntityRegistery {
    private static final DeferredRegister<EntityType<?>> ENTITIES = DeferredRegister.create(Registries.ENTITY_TYPE, "darkermagic");
    //public static final DeferredHolder<EntityType<?>, EntityType<SummonedWarden>> SUMMONED_WARDEN =
            //ENTITIES.register("summoned_warden", () -> EntityType.Builder.of(SummonedWarden::new, MobCategory.MONSTER).sized(0.9F, 2.9F).clientTrackingRange(64).build(ResourceLocation.fromNamespaceAndPath(DarkerMagic.MODID, "summoned_warden").toString()));

    // I recommend you do this instead but it's up to you
    public static final DeferredHolder<EntityType<?>, EntityType<SummonedWarden>> SUMMONED_WARDEN =
            ENTITIES.register("summoned_warden", () -> EntityType.Builder.<SummonedWarden>of
                            (SummonedWarden::new, MobCategory.MONSTER).
                    sized(.6f, 1.8f)
                    .build(
                            ResourceLocation.fromNamespaceAndPath(DarkerMagic.MODID, "summoned_warden").toString()
                    ));

    public static final DeferredHolder<EntityType<?>, EntityType<SummonedShattered>> SUMMONED_SHATTERED = ENTITIES.register("summoned_shattered", () -> EntityType.Builder.of(SummonedShattered::new, MobCategory.MONSTER).sized(0.8F, 2.125F).clientTrackingRange(64).build(ResourceLocation.fromNamespaceAndPath(DarkerMagic.MODID, "summoned_shattered").toString()));
    public static final DeferredHolder<EntityType<?>, EntityType<SummonedSculkCentipede>> SUMMONED_SCULK_CENTIPEDE = ENTITIES.register("summoned_sculk_centipede", () -> EntityType.Builder.of(SummonedSculkCentipede::new, MobCategory.MONSTER).sized(1F, 0.2F).clientTrackingRange(64).build(ResourceLocation.fromNamespaceAndPath(DarkerMagic.MODID, "summoned_sculk_centipede").toString()));
    public static final DeferredHolder<EntityType<?>, EntityType<SummonedSculkSnapper>> SUMMONED_SCULK_SNAPPER = ENTITIES.register("summoned_sculk_snapper", () -> EntityType.Builder.of(SummonedSculkSnapper::new, MobCategory.MONSTER).sized(0.65f, 0.65f).clientTrackingRange(64).build(ResourceLocation.fromNamespaceAndPath(DarkerMagic.MODID, "summoned_sculk_snapper").toString()));

    public static void register(IEventBus eventBus) {
        ENTITIES.register(eventBus);
    }
}

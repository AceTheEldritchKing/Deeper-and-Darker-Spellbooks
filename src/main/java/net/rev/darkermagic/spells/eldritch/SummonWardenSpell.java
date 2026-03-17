package net.rev.darkermagic.spells.eldritch;

import com.kyanite.deeperdarker.content.DDSounds;
import io.redspace.ironsspellbooks.api.config.DefaultConfig;
import io.redspace.ironsspellbooks.api.events.SpellSummonEvent;
import io.redspace.ironsspellbooks.api.magic.MagicData;
import io.redspace.ironsspellbooks.api.registry.SchoolRegistry;
import io.redspace.ironsspellbooks.api.spells.*;
import io.redspace.ironsspellbooks.api.util.Utils;
import io.redspace.ironsspellbooks.capabilities.magic.*;
import io.redspace.ironsspellbooks.entity.mobs.SummonedPolarBear;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.level.Level;
import net.neoforged.neoforge.common.NeoForge;
import net.rev.darkermagic.DarkerMagic;
import net.rev.darkermagic.entity.mobs.SummonedWarden;
import net.rev.darkermagic.item.DDISSEntityRegistery;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.Optional;

public class SummonWardenSpell extends AbstractSpell {
    private final ResourceLocation spellId = ResourceLocation.fromNamespaceAndPath(DarkerMagic.MODID, "summoned_warden");
    private final DefaultConfig defaultConfig;

    public List<MutableComponent> getUniqueInfo(int spellLevel, LivingEntity caster) {
        return List.of(
                Component.translatable("ui.irons_spellbooks.summon_count", new Object[]{this.getSummonCount(spellLevel, caster)}),
                Component.translatable("ui.irons_spellbooks.hp", Utils.stringTruncation(getWardenHealth(spellLevel, caster), 1)),
                Component.translatable("ui.irons_spellbooks.damage",Utils.stringTruncation(getWardenDamage(spellLevel, caster), 1)),
                Component.literal("§9Deeper and Darker: Spellbooks"));

    }

    public SummonWardenSpell() {
        this.defaultConfig = (new DefaultConfig())
                .setMinRarity(SpellRarity.LEGENDARY)
                .setSchoolResource(SchoolRegistry.ELDRITCH_RESOURCE)
                .setMaxLevel(1)
                .setCooldownSeconds(180)
                .build();
        this.manaCostPerLevel = 20;
        this.baseSpellPower = 6;
        this.spellPowerPerLevel = 1;
        this.castTime = 70;
        this.baseManaCost = 250;
    }

    public CastType getCastType() {
        return CastType.LONG;
    }

    public DefaultConfig getDefaultConfig() {
        return this.defaultConfig;
    }

    public ResourceLocation getSpellResource() {
        return this.spellId;
    }

    public Optional<SoundEvent> getCastStartSound() {
        return Optional.of(SoundEvents.WARDEN_ROAR);
    }

    public int getRecastCount(int spellLevel, @Nullable LivingEntity entity) {
        return 2;
    }

    public void onRecastFinished(ServerPlayer serverPlayer, RecastInstance recastInstance, RecastResult recastResult, ICastDataSerializable castDataSerializable) {
        if (SummonManager.recastFinishedHelper(serverPlayer, recastInstance, recastResult, castDataSerializable)) {
            super.onRecastFinished(serverPlayer, recastInstance, recastResult, castDataSerializable);
        }

    }

    public ICastDataSerializable getEmptyCastData() {
        return new SummonedEntitiesCastData();
    }

    public int getSummonCount(int spellLevel, LivingEntity caster) {
        return 1;
    }

    public void onCast(Level world, int spellLevel, LivingEntity entity, CastSource castSource, MagicData playerMagicData) {
        PlayerRecasts recasts = playerMagicData.getPlayerRecasts();
        if (!recasts.hasRecastForSpell(this)) {
            SummonedEntitiesCastData summonedEntitiesCastData = new SummonedEntitiesCastData();
            int summonTime = 12000;
            SummonedWarden warden = new SummonedWarden(DDISSEntityRegistery.SUMMONED_WARDEN.get(), world);
            warden.setPos(entity.position());
            warden.getAttributes().getInstance(Attributes.ATTACK_DAMAGE).setBaseValue((double)this.getWardenDamage(spellLevel, entity));
            warden.getAttributes().getInstance(Attributes.MAX_HEALTH).setBaseValue((double)this.getWardenHealth(spellLevel, entity));
            warden.setHealth(warden.getMaxHealth());
            SummonedWarden creature = (SummonedWarden) ((SpellSummonEvent) NeoForge.EVENT_BUS.post(new SpellSummonEvent(entity, warden, this.spellId, spellLevel))).getCreature();
            world.addFreshEntity(creature);
            SummonManager.initSummon(entity, creature, summonTime, summonedEntitiesCastData);
            RecastInstance recastInstance = new RecastInstance(this.getSpellId(), spellLevel, this.getRecastCount(spellLevel, entity), summonTime, castSource, summonedEntitiesCastData);
            recasts.addRecast(recastInstance, playerMagicData);
        }

        super.onCast(world, spellLevel, entity, castSource, playerMagicData);
    }

    private float getWardenHealth(int spellLevel, LivingEntity caster) {
        return (175 + spellLevel) * getEntityPowerMultiplier(caster);
    }

    private float getWardenDamage(int spellLevel, LivingEntity caster) {
        return getSpellPower(spellLevel + 10, caster);
    }

}

package net.rev.darkermagic.item;

import io.redspace.ironsspellbooks.api.registry.SpellRegistry;
import io.redspace.ironsspellbooks.api.spells.AbstractSpell;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.rev.darkermagic.DarkerMagic;
import net.rev.darkermagic.spells.eldritch.SummonSculkCentipedeSpell;
import net.rev.darkermagic.spells.eldritch.SummonSculkSnapperSpell;
import net.rev.darkermagic.spells.eldritch.SummonShatteredSpell;
import net.rev.darkermagic.spells.eldritch.SummonWardenSpell;

import java.util.function.Supplier;

public class DDISSSpellRegistery {
    public static final DeferredRegister<AbstractSpell> SPELLS = DeferredRegister.create(SpellRegistry.SPELL_REGISTRY_KEY, DarkerMagic.MODID);
    public static void register(IEventBus eventBus) { SPELLS.register(eventBus); }
    public static Supplier<AbstractSpell> registerSpell(AbstractSpell spell) {
        return SPELLS.register(spell.getSpellName(), () -> spell);
    }

    public static final Supplier<AbstractSpell> SUMMON_WARDEN_SPELL = registerSpell(new SummonWardenSpell());
    public static final Supplier<AbstractSpell> SUMMON_SHATTERED_SPELL = registerSpell(new SummonShatteredSpell());
    public static final Supplier<AbstractSpell> SUMMON_SCULK_CENTIPEDE_SPELL = registerSpell(new SummonSculkCentipedeSpell());
    public static final Supplier<AbstractSpell> SUMMON_SCULK_SNAPPER_SPELL = registerSpell(new SummonSculkSnapperSpell());
}

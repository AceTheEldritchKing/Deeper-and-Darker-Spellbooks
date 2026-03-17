package net.rev.darkermagic.item.curios;

import io.redspace.ironsspellbooks.api.item.curios.AffinityData;
import io.redspace.ironsspellbooks.api.registry.AttributeRegistry;
import io.redspace.ironsspellbooks.api.registry.SpellDataRegistryHolder;
import io.redspace.ironsspellbooks.api.registry.SpellRegistry;
import io.redspace.ironsspellbooks.api.spells.AbstractSpell;
import io.redspace.ironsspellbooks.item.UniqueSpellBook;
import io.redspace.ironsspellbooks.item.weapons.AttributeContainer;
import io.redspace.ironsspellbooks.util.TooltipsUtils;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import org.jetbrains.annotations.NotNull;

import java.awt.*;
import java.util.List;
import java.util.Map;

public class VolumeOfTheDeep extends UniqueSpellBook {
    public VolumeOfTheDeep() {
        super(SpellDataRegistryHolder.of(), 12);
                withSpellbookAttributes(
                        new AttributeContainer(AttributeRegistry.MAX_MANA, 250, AttributeModifier.Operation.ADD_VALUE),
                        new AttributeContainer(AttributeRegistry.ELDRITCH_SPELL_POWER, .15, AttributeModifier.Operation.ADD_MULTIPLIED_BASE),
                        new AttributeContainer(AttributeRegistry.COOLDOWN_REDUCTION, .20, AttributeModifier.Operation.ADD_MULTIPLIED_BASE)
                );
    }


    public void appendHoverText(@NotNull ItemStack itemStack, Item.TooltipContext context, @NotNull List<Component> lines, @NotNull TooltipFlag flag) {
        super.appendHoverText(itemStack, context, lines, flag);
        AffinityData affinityData = AffinityData.getAffinityData(itemStack);
        if (!affinityData.affinityData().isEmpty()) {
            int i = TooltipsUtils.indexOfComponent(lines, "tooltip.irons_spellbooks.spellbook_spell_count");
            lines.addAll(i < 0 ? lines.size() : i + 1, affinityData.getDescriptionComponent());
        }

    }


    public void initializeSpellContainer(ItemStack itemStack) {
        if (itemStack != null) {
            super.initializeSpellContainer(itemStack);
            AffinityData.set(itemStack, new AffinityData(Map.of(((AbstractSpell)SpellRegistry.SONIC_BOOM_SPELL.get()).getSpellResource(), 1, ((AbstractSpell)SpellRegistry.SCULK_TENTACLES_SPELL.get()).getSpellResource(), 1)));
        }
    }
}

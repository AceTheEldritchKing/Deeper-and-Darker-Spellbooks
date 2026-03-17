package net.rev.darkermagic.entity.armor;

import io.redspace.ironsspellbooks.IronsSpellbooks;
import net.minecraft.resources.ResourceLocation;
import net.rev.darkermagic.DarkerMagic;
import net.rev.darkermagic.item.armor.WardenMageArmorItem;
import software.bernie.geckolib.model.DefaultedItemGeoModel;

public class WardenMageArmorModel extends DefaultedItemGeoModel<WardenMageArmorItem> {

    public WardenMageArmorModel() {
        super(ResourceLocation.fromNamespaceAndPath(DarkerMagic.MODID, ""));
    }

    @Override
    public ResourceLocation getModelResource(WardenMageArmorItem object) {
        return ResourceLocation.fromNamespaceAndPath(DarkerMagic.MODID, "geo/item/armor/warden_mage_armor.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(WardenMageArmorItem object) {
        return ResourceLocation.fromNamespaceAndPath(DarkerMagic.MODID, "textures/models/armor/warden_mage_armor.png");
    }

    @Override
    public ResourceLocation getAnimationResource(WardenMageArmorItem animatable) {
        return ResourceLocation.fromNamespaceAndPath(IronsSpellbooks.MODID, "animations/wizard_armor_animation.json");
    }
}

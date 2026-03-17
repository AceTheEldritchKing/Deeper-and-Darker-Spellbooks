package net.rev.darkermagic.entity.item;

import net.minecraft.resources.ResourceLocation;
import net.rev.darkermagic.DarkerMagic;
import net.rev.darkermagic.item.staffs.WhispersStaffItem;
import software.bernie.geckolib.model.DefaultedItemGeoModel;

public class WhispersStaffModel extends DefaultedItemGeoModel<WhispersStaffItem> {
    public WhispersStaffModel() {
        super(ResourceLocation.fromNamespaceAndPath(DarkerMagic.MODID, ""));
    }

    public ResourceLocation getModelResource(WhispersStaffItem object) {
        return ResourceLocation.fromNamespaceAndPath(DarkerMagic.MODID, "geo/item/whisper_staff.geo.json");
    }

    public ResourceLocation getTextureResource(WhispersStaffItem object) {
        return ResourceLocation.fromNamespaceAndPath(DarkerMagic.MODID, "textures/item/whisper_staff.png");
    }

    public ResourceLocation getAnimationResource(WhispersStaffItem animatable) {
        return ResourceLocation.fromNamespaceAndPath(DarkerMagic.MODID, "animations/item/whisper_staff.animation.json");
    }
}

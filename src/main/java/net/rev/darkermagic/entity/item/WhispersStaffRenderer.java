package net.rev.darkermagic.entity.item;

import net.rev.darkermagic.item.staffs.WhispersStaffItem;
import software.bernie.geckolib.renderer.GeoItemRenderer;

public class WhispersStaffRenderer extends GeoItemRenderer<WhispersStaffItem> {
    public WhispersStaffRenderer() {
        super(new WhispersStaffModel());
    }
}

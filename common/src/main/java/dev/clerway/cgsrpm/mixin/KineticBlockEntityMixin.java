package dev.clerway.cgsrpm.mixin;

import com.simibubi.create.content.kinetics.base.KineticBlockEntity;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.List;

@Mixin(KineticBlockEntity.class)
public abstract class KineticBlockEntityMixin {

    @Shadow(remap = false)
    public abstract float getSpeed();

    @Inject(method = "addToGoggleTooltip", at = @At("RETURN"), cancellable = true, remap = false)
    private void onAddToGoggleTooltip(List<Component> tooltip, boolean isPlayerSneaking, CallbackInfoReturnable<Boolean> cir) {
        float speed = Math.abs(getSpeed());
        tooltip.add(0, Component.literal("       RPM: " + (int)speed)
                .withStyle(ChatFormatting.GOLD, ChatFormatting.BOLD));
        cir.setReturnValue(true);
    }
}

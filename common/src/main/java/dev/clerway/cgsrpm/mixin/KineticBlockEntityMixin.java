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

    @Inject(method = "addToGoggleTooltip", at = @At("RETURN"), remap = false, cancellable = true)
    private void onAddToGoggleTooltip(List<Component> tooltip, boolean isPlayerSneaking, CallbackInfoReturnable<Boolean> cir) {
        float speed = Math.abs(getSpeed());
        tooltip.add(Component.literal("    ")
                .append(Component.literal("RPM: ").withStyle(ChatFormatting.GOLD))
                .append(Component.literal(String.valueOf((int)speed)).withStyle(ChatFormatting.GOLD))
                .withStyle(ChatFormatting.BOLD));
        cir.setReturnValue(true);
    }
}

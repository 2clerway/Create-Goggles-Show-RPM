package dev.clerway.cgsrpm.mixin;

import com.simibubi.create.content.kinetics.base.KineticBlockEntity;
import dev.clerway.cgsrpm.CreateGSRPM;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
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
        MutableComponent line = Component.literal("    ")
                .append(Component.literal("RPM: "))
                .append(Component.literal(String.valueOf((int)speed)));
        CreateGSRPM.CONFIG.style.apply(line, CreateGSRPM.CONFIG.color);
        tooltip.add(line);
        cir.setReturnValue(true);
    }
}

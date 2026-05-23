package dev.clerway.cgsrpm;

import dev.isxander.yacl3.api.ConfigCategory;
import dev.isxander.yacl3.api.Option;
import dev.isxander.yacl3.api.YetAnotherConfigLib;
import dev.isxander.yacl3.api.controller.EnumControllerBuilder;
import net.minecraft.ChatFormatting;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;

public class GSRPMConfigScreen {
    public static Screen create(Screen parent) {
        GSRPMConfig config = CreateGSRPM.CONFIG;

        return YetAnotherConfigLib.createBuilder()
                .title(Component.literal("Create GSRPM Config"))
                .category(ConfigCategory.createBuilder()
                        .name(Component.literal("General"))
                        .option(Option.<GSRPMConfig.TooltipStyle>createBuilder()
                                .name(Component.literal("Text Style"))
                                .binding(GSRPMConfig.TooltipStyle.BOLD, () -> config.style, val -> config.style = val)
                                .controller(opt -> EnumControllerBuilder.create(opt)
                                        .enumClass(GSRPMConfig.TooltipStyle.class)
                                        .formatValue(v -> Component.literal(v.name())))
                                .build())
                        .option(Option.<ChatFormatting>createBuilder()
                                .name(Component.literal("Text Color"))
                                .binding(ChatFormatting.GOLD, () -> config.color, val -> config.color = val)
                                .controller(opt -> EnumControllerBuilder.create(opt)
                                        .enumClass(ChatFormatting.class)
                                        .formatValue(v -> Component.literal(v.getName()).withStyle(v)))
                                .build())
                        .option(Option.<Boolean>createBuilder()
                                .name(Component.literal("Current Preview:"))
                                .binding(true, () -> true, val -> {})
                                .controller(opt -> dev.isxander.yacl3.api.controller.BooleanControllerBuilder.create(opt)
                                        .formatValue(v -> {
                                            MutableComponent preview = Component.literal("RPM: 160");
                                            config.style.apply(preview, config.color);
                                            return preview;
                                        }))
                                .build())
                        .build())
                .save(config::save)
                .build()
                .generateScreen(parent);
    }
}

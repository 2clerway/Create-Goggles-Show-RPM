package dev.clerway.cgsrpm;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.MutableComponent;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class GSRPMConfig {
    private static final File FILE = new File("config/creategsrpm.json");
    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();

    public ChatFormatting color = ChatFormatting.GOLD;
    public TooltipStyle style = TooltipStyle.BOLD;

    public static GSRPMConfig load() {
        if (!FILE.exists()) {
            GSRPMConfig config = new GSRPMConfig();
            config.save();
            return config;
        }
        try (FileReader reader = new FileReader(FILE)) {
            GSRPMConfig config = GSON.fromJson(reader, GSRPMConfig.class);
            if (config == null) return new GSRPMConfig();
            if (config.color == null) config.color = ChatFormatting.GOLD;
            if (config.style == null) config.style = TooltipStyle.BOLD;
            return config;
        } catch (IOException e) {
            return new GSRPMConfig();
        }
    }

    public void save() {
        if (!FILE.getParentFile().exists()) FILE.getParentFile().mkdirs();
        try (FileWriter writer = new FileWriter(FILE)) {
            GSON.toJson(this, writer);
        } catch (IOException ignored) {}
    }

    public enum TooltipStyle {
        NORMAL, BOLD, ITALIC, BOLD_ITALIC;

        public MutableComponent apply(MutableComponent component, ChatFormatting color) {
            component.withStyle(color);
            if (this == BOLD || this == BOLD_ITALIC) component.withStyle(ChatFormatting.BOLD);
            if (this == ITALIC || this == BOLD_ITALIC) component.withStyle(ChatFormatting.ITALIC);
            return component;
        }
    }
}

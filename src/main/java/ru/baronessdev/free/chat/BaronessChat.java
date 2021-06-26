package ru.baronessdev.free.chat;

import it.unimi.dsi.fastutil.objects.Object2ObjectArrayMap;
import org.bukkit.configuration.MemorySection;
import org.bukkit.plugin.java.JavaPlugin;

public final class BaronessChat extends JavaPlugin {

    private final Object2ObjectArrayMap<String, Object> settings = new Object2ObjectArrayMap<>();

    @Override
    public void onEnable() {
        saveDefaultConfig();
        getConfig().getKeys(true).stream()
                .filter(key -> !(getConfig().get(key) instanceof MemorySection))
                .forEach(key -> settings.put(key, getConfig().get(key)));
    }
}

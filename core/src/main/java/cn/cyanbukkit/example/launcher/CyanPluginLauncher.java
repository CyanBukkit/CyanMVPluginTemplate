package cn.cyanbukkit.example.launcher;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public class CyanPluginLauncher extends JavaPlugin {

    public static CyanPluginLauncher cyanPlugin;

    public CyanPluginLauncher() {
        cyanPlugin = this;
        System.out.println("CyanBukkit多版本ShadowJar模式");
        System.out.println("自研开发模板该版本无需加载器所有内容均为纯净适合NMS使用");
        System.out.println("www.cyanbukkit.net");
    }

    @Override
    public void onEnable() {
        Bukkit.getConsoleSender().sendMessage("开始加载获取当前服务器版本匹配使用");
        String version = Bukkit.getVersion();
        Bukkit.getConsoleSender().sendMessage("当前服务器版本为: " + version);
        if (version.contains("1.8.8")) {

        }
    }

    @Override
    public void onDisable() {
        super.onDisable();
    }

    @Override
    public void onLoad() {
        super.onLoad();
    }

    @Override
    public void saveConfig() {
        super.saveConfig();
    }

    @Override
    public void saveDefaultConfig() {
        super.saveDefaultConfig();
    }

    @Override
    public void reloadConfig() {
        super.reloadConfig();
    }
}

package cn.cyanbukkit.example.utils;

import org.bukkit.command.Command;
import org.bukkit.command.SimpleCommandMap;

import static cn.cyanbukkit.example.launcher.CyanPluginLauncher.cyanPlugin;

/**
 * 多版本开发模板 因为庞大 所有的API内容需要结合指定版本去完成 这里放一些常用剩下的自己去实现
 */
public class CommandManager {

    public static void registerCommand(Command command, String commandPrefix) {
        try {
            // 获取 PluginManager 类
            Class<?> pluginManagerClazz = cyanPlugin.getServer().getPluginManager().getClass();
            // 获取 commandMap 字段
            java.lang.reflect.Field field = pluginManagerClazz.getDeclaredField("commandMap");
            field.setAccessible(true);
            // 获取 commandMap 对象
            SimpleCommandMap commandMap = (SimpleCommandMap) field.get(cyanPlugin.getServer().getPluginManager());
            // 注册命令
            commandMap.register(commandPrefix, command);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }

}

package cn.cyanbukkit.itemeditor

import cn.cyanbukkit.itemeditor.version.r1_8.ItemEditorCommand
import org.bukkit.command.Command
import org.bukkit.command.SimpleCommandMap
import org.bukkit.plugin.java.JavaPlugin

class PluginStart : JavaPlugin(){


    fun Command.register() {
        val pluginManagerClazz = server.pluginManager.javaClass
        val field = pluginManagerClazz.getDeclaredField("commandMap")
        field.isAccessible = true
        val commandMap = field.get(server.pluginManager) as SimpleCommandMap
        commandMap.register(name, this)
    }


    override fun onEnable() {
        logger.info("已加载")
        // 根据服务器版本注册指令
        // 根据接口调用子版本注册子版本的事件
        when {
            server.version.contains("1.8") -> {
                logger.info("服务器版本为1.8")
                ItemEditorCommand().register()
            }
        }
    }


}
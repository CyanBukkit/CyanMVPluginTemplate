package cn.cyanbukkit.itemeditor.version.r1_9

import org.bukkit.command.Command
import org.bukkit.command.CommandSender
import org.bukkit.enchantments.Enchantment
import org.bukkit.entity.Player


@Suppress("SpellCheckingInspection")
class ItemEditorCommand : Command(
    "itemeditor", "物品编辑器", "/itemeditor", listOf("ie")
) {

    override fun execute(sender: CommandSender, commandLabel: String, args: Array<String>): Boolean {
        // 获取玩家手里的物品
        if (sender is Player) {
            if (!sender.hasPermission("itemeditor.use")) return true
            // setname
            if (args.isNotEmpty()) {
                when (args[0]) {
                    "setname" -> {
                        if (args.size > 1) {
                            val name = args[1]
                            val item = sender.itemInHand.apply {
                                itemMeta.apply {
                                    displayName = name
                                    itemMeta = this
                                }
                            }
                            sender.inventory.itemInHand = item
                            sender.sendMessage("§a设置成功")
                        } else {
                            sender.sendMessage("§c请输入物品名称")
                        }
                    }

                    "removelore" -> {
                        // 删除最底下的一行
                        val item = sender.itemInHand.apply {
                            itemMeta.apply {
                                val me = itemMeta
                                me.apply {
                                    if (this.lore != null) {
                                        this.lore = lore.dropLast(1)
                                    }
                                }
                                itemMeta = me
                            }
                        }
                        sender.inventory.itemInHand = item
                        sender.sendMessage("§a删除成功")
                    }

                    "addlore" -> {
                        if (args.size > 1) {
                            val lore = args[1]
                            val item = sender.itemInHand.apply {
                                val me = itemMeta
                                me.apply {
                                    val newlore = this.lore?.toMutableList() ?: mutableListOf()
                                    newlore.add(lore)
                                    this.lore = newlore
                                }
                                itemMeta = me
                            }
                            sender.inventory.itemInHand = item
                            sender.sendMessage("§a添加成功")
                        } else {
                            sender.sendMessage("§c请输入物品描述")
                        }
                    }

                    "setamount" -> {
                        if (args.size > 1) {
                            val amount = try{
                                args[1].toInt()
                            } catch (e: Exception) {
                                1
                            }
                            val item = sender.itemInHand
                            item.amount = amount
                            sender.sendMessage("§a设置成功")
                        } else {
                            sender.sendMessage("§c请输入物品数量")
                        }
                    }

                    "setdurability" -> {
                        if (args.size > 1) {
                            val durability = try{
                                args[1].toShort()
                            } catch (e: Exception) {
                                1
                            }
                            val item = sender.itemInHand
                            item.durability = durability
                            sender.sendMessage("§a设置成功")
                        } else {
                            sender.sendMessage("§c请输入物品耐久")
                        }
                    }

                    "settype" -> {
                        if (args.size > 1) {
                            val type = try{
                                args[1].toInt()
                            } catch (e: Exception) {
                                1
                            }
                            val item = sender.itemInHand
                            item.typeId = type
                            sender.sendMessage("§a设置成功")
                        } else {
                            sender.sendMessage("§c请输入物品类型")
                        }
                    }

                    "setdata" -> {
                        if (args.size > 1) {
                            val data = args[1].toByte()
                            val item = sender.itemInHand
                            item.data.data = data
                            sender.sendMessage("§a设置成功")
                        } else {
                            sender.sendMessage("§c请输入物品data")
                        }
                    }


                    "setunbreakable" -> {
                        if (args.size > 1) {
                            val unbreakable = try {
                                args[1].toBoolean()
                            } catch (e: Exception) {
                                sender.sendMessage("§c请输入正确的布尔值");
                                return true
                            }
                            val item = sender.itemInHand
                            item.itemMeta.addItemFlags()
                            item.itemMeta.spigot().isUnbreakable = unbreakable
                            sender.sendMessage("§a设置成功")
                        }
                    }


                    "addEnchant" -> {
                        if (args.size > 1) {
                            val enchant = args[1]
                            val int = try {
                                args[2].toInt()
                            } catch (e: Exception) {
                                1
                            }
                            val item = sender.itemInHand
                            item.addUnsafeEnchantment(Enchantment.getByName(enchant), int)
                            sender.sendMessage("§a设置成功")
                        } else {
                            sender.sendMessage("§c请输入物品附魔")
                        }
                    }


                    "removeEnchant" -> {
                        if (args.size > 1) {
                            val enchent = args[1]
                            val item = sender.itemInHand
                            item.removeEnchantment(Enchantment.getByName(enchent))
                            sender.sendMessage("§a设置成功")
                        } else {
                            sender.sendMessage("§c请输入物品附魔")
                        }
                    }

                    else -> {
                        sender.sendMessage("§c请输入正确的指令")
                    }
                }
            } else {
                sender.sendMessage("§c请输入指令")
            }
            return true
        } else {
            sender.sendMessage("§c控制台无法使用此命令")
        }
        return true
    }


    override fun tabComplete(sender: CommandSender, alias: String, args: Array<String>): MutableList<String> {
        //根据上面的指令生成tab补全
        val list = mutableListOf<String>()
        if (args.size == 1) {
            list.add("setname")
            list.add("removelore")
            list.add("addlore")
            list.add("setamount")
            list.add("setdurability")
            list.add("settype")
            list.add("setdata")
            list.add("setunbreakable")
            list.add("addEnchant")
            list.add("removeEnchant")
        }
        //返回补全列表长度为2的列表
        //如果是Enchant指令则补全附魔列表
        if (args.size == 2 && args[0] == "addEnchant" || args[0] == "removeEnchant") {
            for (enchant in Enchantment.values()) {
                list.add(enchant.name)
            }
        }
        return list
    }

}
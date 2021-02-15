package org.projecttl.plugin.hrp.commands.arguments

import org.bukkit.command.Command
import org.bukkit.command.CommandSender
import org.bukkit.command.TabCompleter
import org.bukkit.entity.Player

class ArgumentForHRCommand: TabCompleter {

    override fun onTabComplete(sender: CommandSender, command: Command, alias: String, args: Array<out String>): MutableList<String>? {
        if (sender is Player) {
            val commandArgument: ArrayList<String> = ArrayList()

            if (command.name.equals("hr", true)) {
                when (args.size) {
                    1 -> {
                        commandArgument.add("config")
                        return commandArgument
                    }

                    2 -> {
                        commandArgument.add("save")
                        return commandArgument
                    }
                }
            }
        }
        return null
    }
}
package de.oppermann.bastian.safetrade.commands;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;

/**
 * This is class is used for tab completion.
 */
public class TradeTabCompleter implements TabCompleter {

    @Override
    public List<String> onTabComplete(CommandSender sender, Command cmd, String label, String[] args) {
        List<String> list = new ArrayList<String>();
        
        if (args.length == 1) { // only 1 argument is possible atm
            list.add("accept");
            list.add("deny");
            list.add("help");
            for (Player player : Bukkit.getOnlinePlayers()) { // add all online players
                if (!sender.equals(player)) { // except the player itself
                    list.add(player.getName());
                }
            }
        }
        
        Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()) {
            String str = iterator.next().toLowerCase();
            if (!str.startsWith(args[args.length - 1].toLowerCase())) { // don't complete names which don't fit the current input
                iterator.remove();
            }
        }
        return list;
    }

}

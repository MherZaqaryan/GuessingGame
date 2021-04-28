package net.Lowk.guessingGame.commands;

import net.Lowk.guessingGame.Main;
import net.Lowk.guessingGame.menuSystem.menus.GuessingGameMenu;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class GuessingGameCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        if (!(sender instanceof Player)) {
            sender.sendMessage("Sorry but you are not able to guess!");
            return true;
        }

        Player player = (Player) sender;

        new GuessingGameMenu(Main.getPlayerMenuUtility(player)).open();

        return false;
    }
}

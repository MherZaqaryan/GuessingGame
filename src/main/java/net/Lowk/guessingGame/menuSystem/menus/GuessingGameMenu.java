package net.Lowk.guessingGame.menuSystem.menus;

import net.Lowk.guessingGame.menuSystem.Menu;
import net.Lowk.guessingGame.menuSystem.PlayerMenuUtility;
import net.Lowk.guessingGame.utility.TextUtil;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GuessingGameMenu extends Menu {

    private final int number;
    private int chances;
    private List<Integer> guessedNumbers;

    public GuessingGameMenu(PlayerMenuUtility playerMenuUtility) {
        super(playerMenuUtility);
        this.number = new Random().nextInt(54)+1;
        this.chances = 4;
        guessedNumbers = new ArrayList<>();
    }

    @Override
    public String getMenuName() {
        return "&3&lGuessing&b&lGame";
    }

    @Override
    public int getSlots() {
        return 54;
    }

    @Override
    public void handleMenu(InventoryClickEvent e) {
        Player player = (Player) e.getWhoClicked();
        if (!guessedNumbers.contains(e.getSlot())) {
            if (e.getSlot() == number) {
                player.closeInventory();
                player.sendMessage(TextUtil.colorize("&3&lGuessing&b&lGame &8- &aCongratulations, you guess the number."));
            } else if (chances <= 1) {
                player.closeInventory();
                player.sendMessage(TextUtil.colorize("&3&lGuessing&b&lGame &8- &cGame Over, you didn't guess the number."));
            } else if (e.getSlot() > number) {
                chances--;
                guessedNumbers.add(e.getSlot());
                inventory.setItem(e.getSlot(), makeItem(Material.STAINED_GLASS_PANE, e.getCurrentItem().getAmount(), 5, e.getCurrentItem().getItemMeta().getDisplayName(), "&7This number is &agreater &7than the actual."));
            } else if (e.getSlot() < number) {
                chances--;
                guessedNumbers.add(e.getSlot());
                inventory.setItem(e.getSlot(), makeItem(Material.STAINED_GLASS_PANE, e.getCurrentItem().getAmount(), 14, e.getCurrentItem().getItemMeta().getDisplayName(), "&7This number is &clower &7than the actual."));
            }
        }
    }

    @Override
    public void setMenuItems() {
        for (int i = 0; i < 54; i++) {
            inventory.setItem(i, makeItem(Material.STAINED_GLASS_PANE, (i+1), 8, "&a"+(i+1)));
        }
    }

}

package net.spideynn.bukkit.kitgui;

import net.spideynn.bukkit.kitgui.gui.MainGUI;
import net.spideynn.bukkit.kitgui.listeners.Listeners;
import net.spideynn.bukkit.kitgui.mongodb.DatabaseHandler;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.HashMap;
import java.util.logging.Logger;

public class Main extends JavaPlugin {

    public Logger log = getLogger();
    public static HashMap<Player, Boolean> choseKit = new HashMap<Player, Boolean>();
    public static DatabaseHandler db = new DatabaseHandler(27017);

    private static JavaPlugin instance;
    /// TODO: BattleLevels API https://github.com/RobiRami/BattleLevels/wiki

    @Override
    public void onDisable() {
        instance = null;
    }

    @Override
    public void onEnable() {
        instance = this;
        getServer().getPluginManager().registerEvents(new Listeners(), this);


        Plugin pl = Bukkit.getPluginManager().getPlugin("BattleLevels");
        if (pl == null) {
            log.severe("BattleLevels is not installed. Disabling plugin.");
            Bukkit.getPluginManager().disablePlugin(this);
        }
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (label.equalsIgnoreCase("kitgui")) {
            if (sender instanceof Player) {
                Player player = (Player) sender;
                MainGUI mainGUI = new MainGUI(this);
                mainGUI.open(player);
            }
        }
        return false;
    }

    public static JavaPlugin getInstance() {
        return instance;
    }
}

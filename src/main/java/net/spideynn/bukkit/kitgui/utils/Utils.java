package net.spideynn.bukkit.kitgui.utils;

import me.robin.battlelevels.objects.BattlePlayer;
import org.bukkit.entity.Player;

public class Utils {

    public static void buyKit(BattlePlayer player, int cost) {
        if (player.getScore() >= cost)
            player.setScore(player.getScore() - cost);
    }

    public static void confirmKitPurchase(Kits kits, int cost, net.spideynn.bukkit.kitgui.mongodb.Player playerDB, Player player) {

    }
}

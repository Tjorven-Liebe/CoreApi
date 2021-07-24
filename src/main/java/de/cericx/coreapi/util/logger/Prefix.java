package de.cericx.coreapi.util.logger;

import de.cericx.coreapi.util.messagebuilder.Message;
import org.bukkit.entity.Player;

public class Prefix {

    public static String pre() {
        return Message.get("defaultprefix", "§9CoreApi §8» §7");
    }

    public static String use(String usage) {
        return pre() + usage;
    }

    public static String perm() {
        return Message.get("permission", "§cDir fehlt die Berechtigung!");
    }

    public static String offline(Player player) {
        return Message.get("offlineplayer" ,"§cDer Spieler %playername% ist offline oder existiert nicht!".replace("%playername%", player.getName()));
    }

}

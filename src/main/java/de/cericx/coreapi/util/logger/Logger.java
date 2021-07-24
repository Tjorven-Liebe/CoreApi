package de.cericx.coreapi.util.logger;

import org.bukkit.Bukkit;

/***
 * @author Cericx_
 * @version 1.0
 * @since 11.07.2021
 */

public class Logger {

    public static void info(String... text) {
        for(String message : text) {
            Bukkit.getConsoleSender().sendMessage("§8[§9INFO§8] §7" + message);
        }
    }

    public static void error(String... text) {
        for(String message : text) {
            Bukkit.getConsoleSender().sendMessage("§8[§eWARN§8] §e" + message);
        }
    }

    public static void warn(String... text) {
        for(String message : text) {
            Bukkit.getConsoleSender().sendMessage("§8[§cERROR§8] §c" + message);
        }
    }

}
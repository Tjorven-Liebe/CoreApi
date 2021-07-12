package de.cericx.coreapi.logger;

import org.bukkit.Bukkit;

/***
 * @author Cericx_
 * @version 1.0
 * @since 11.07.2021
 */

public class Logger {

    public static void info(String... text) {
        for(String message : text) {
            Bukkit.getConsoleSender().sendMessage("§e[§9INFO§e] §7" + message);
        }
    }

    public static void error(String... text) {
        for(String message : text) {
            Bukkit.getConsoleSender().sendMessage("§e[§cERROR§e] §7" + message);
        }
    }

    public static void warn(String... text) {
            for(String message : text) {
                Bukkit.getConsoleSender().sendMessage("§e[§eWARNING§e] §7" + message);
            }
        }

}

package de.cericx.coreapi.logger;

import org.bukkit.Bukkit;

/***
 * @author Cericx_
 * @version 1.0
 * @since 11.07.2021
 */

public class Logger {

    String msg;

    public Logger(String text) {

    }

    public void info() {
        Bukkit.getConsoleSender().sendMessage("§e[§9INFO§e] §7" + msg);
    }

    public void error() {
        Bukkit.getConsoleSender().sendMessage("§e[§cERROR§e] §7" + msg);
    }

    public void warning() {
        Bukkit.getConsoleSender().sendMessage("§e[§eWARNING§e] §7" + msg);
    }

}

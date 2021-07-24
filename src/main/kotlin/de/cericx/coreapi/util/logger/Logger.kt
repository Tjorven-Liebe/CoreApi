package de.cericx.coreapi.util.logger

import org.bukkit.Bukkit

/***
 * @author FlorianMichael as EnZaXD
 * @version 2.0
 * @since 11.07.2021
 */

object Logger {

    internal fun log(level: Level, vararg message: String) {
        for (s in message)
            Bukkit.getServer().consoleSender.sendMessage(level.display + " " + s)

    }

    fun info(vararg message: String) {
        log(Level.INFO, *message)
    }


    fun warn(vararg message: String) {
        log(Level.WARN, *message)
    }

    fun error(vararg message: String) {
        log(Level.ERROR, *message)
    }

    enum class Level(var display: String) {
        INFO("§7Info"),
        WARN("§eWarn"),
        ERROR("§cError");
    }
}

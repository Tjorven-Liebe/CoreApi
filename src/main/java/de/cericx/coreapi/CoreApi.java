package de.cericx.coreapi;

import de.cericx.coreapi.debug.Try;
import de.cericx.coreapi.util.logger.Logger;
import de.cericx.coreapi.util.messagebuilder.Message;
import org.bukkit.plugin.java.JavaPlugin;

public class CoreApi extends JavaPlugin {

    @Override
    public void onEnable() {

        Logger.info("CoreApi by Cericx_ and RudiBott §estarted","Version: 1.0","Since 11.07.2021","§eThank you for Using");

        Logger.warn(Message.getTranslated("translated.startupwarning", "Dieses Plugin ist echt nicht stark programmiert", "de", "fr"));

        getCommand("try").setExecutor(new Try());
    }

    @Override
    public void onDisable() {
        Logger.info("CoreApi by Cericx_ and RudiBott §cdisabled", "Version: 1.0", "Since 11.07.2021", "§c" +
                "Thank you and goodbye!");
    }
}

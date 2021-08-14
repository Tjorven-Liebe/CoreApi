package org.coreapi;

import org.coreapi.util.logger.Logger;
import org.coreapi.util.messagebuilder.MessageConfigBuilder;
import org.bukkit.plugin.java.JavaPlugin;

public class CoreApi extends JavaPlugin {

    @Override
    public void onEnable() {

        Logger.info("CoreApi by Cericx_ and RudiBott §estarted","Version: 1.0","Since 11.07.2021","§eThank you for Using", "powered by Terminal-Hosting", " "
        + "Support us while using this Link: §9§nhttps://terminalhosting.de/clientarea/aff.php?aff=2");


        new MessageConfigBuilder();


    }

    @Override
    public void onDisable() {
        Logger.info("CoreApi by Cericx_ and RudiBott §cdisabled", "Version: 1.0", "Since 11.07.2021", "§c" +
                "Thank you and goodbye!");
    }
}

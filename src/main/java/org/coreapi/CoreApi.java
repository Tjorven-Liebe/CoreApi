package org.coreapi;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;
import org.coreapi.api.Api;
import org.coreapi.constructor.PageableInventory;
import org.coreapi.util.messagebuilder.MessageConfigBuilder;
import org.coreapi.util.test.TestCommand;

public class CoreApi extends JavaPlugin {

    @Override
    public void onEnable() {

        Api.getLogger().info("CoreApi by Cericx_ and RudiBott §estarted","Version: 1.0","Since 11.07.2021","§eThank you for Using", "powered by Terminal-Hosting", " "
            + "Support us while using this Link: §9https://terminalhosting.de/clientarea/aff.php?aff=2§r");


        new MessageConfigBuilder();

        Bukkit.getPluginManager().registerEvents(new PageableInventory(), this);
        getCommand("test").setExecutor(new TestCommand());

    }

    @Override
    public void onDisable() {
        Api.getLogger().info("CoreApi by Cericx_ and RudiBott §cdisabled§r", "Version: 1.0", "Since 11.07.2021", "§c" +
                "Thank you and goodbye!§r");
    }
}

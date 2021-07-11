package de.cericx.coreapi;

import de.cericx.coreapi.logger.Logger;
import org.bukkit.plugin.java.JavaPlugin;

public class CoreApi extends JavaPlugin {

    @Override
    public void onEnable() {

        new Logger("CoreApi by Cericx_ and RudiBott started\nVersion: 1.0\nSince 11.07.2021\nThank you for Using").info();

        super.onEnable();
    }
}

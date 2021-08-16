package org.coreapi.util.locations;

import org.bukkit.Location;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.coreapi.util.Constants;

import java.io.File;

public class ConfigLocation {

    public static File file = new File(Constants.foldername + "/locations/locations.yml");
    public static FileConfiguration cfg = YamlConfiguration.loadConfiguration(file);

    String locationname = "";

    Location location = null;

    public static Location getLocation(String locationname, Location location) {
        return LocationBuilder.getLocation(locationname, location);
    }

    public static Location getRawLocation(String locationname) {
        return LocationBuilder.getRawLocation(locationname);
    }











































}

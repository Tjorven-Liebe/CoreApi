package org.coreapi.util.locations;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.coreapi.api.Api;

import java.io.File;
import java.io.IOException;

public class LocationBuilder {


    public final static FileConfiguration cfg = ConfigLocation.cfg;
    public final static File file = ConfigLocation.file;

    public LocationBuilder() {

        cfg.options().header("#All Location positions are saved here.");
        try {
            cfg.save(file);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            Api.getLogger().error(e);
        }
    }

    public static void setLocation(String locationname, Location location) {
        if(cfg.getString(locationname) == null) {


            cfg.set(locationname + ".world", location.getWorld().getName());
            cfg.set(locationname + ".x", location.getX());
            cfg.set(locationname + ".y", location.getY());
            cfg.set(locationname + ".z", location.getZ());
            cfg.set(locationname + ".pitch", location.getPitch());
            cfg.set(locationname + ".yaw", location.getYaw());

            try {
                cfg.save(file);
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }
    public static Location getRawLocation(String locationname) {
        World world = Bukkit.getWorld(cfg.getString(locationname + ".world"));
        double x = cfg.getDouble(locationname + ".x");
        double y = cfg.getDouble(locationname + ".y");
        double z = cfg.getDouble(locationname + ".z");
        float pitch = (float) cfg.getDouble(locationname + ".pitch");
        float yaw = (float) cfg.getDouble(locationname + ".yaw");

        return new Location(world, x, y, z, yaw, pitch);
    }

    public static Location getLocation(String locationname, Location location) {
        if(cfg.getString(locationname)==null) {
            setLocation(locationname, location);

            World world = Bukkit.getWorld(cfg.getString(locationname + ".world"));
            double x = cfg.getDouble(locationname + ".x");
            double y = cfg.getDouble(locationname + ".y");
            double z = cfg.getDouble(locationname + ".z");
            float pitch = (float) cfg.getDouble(locationname + ".pitch");
            float yaw = (float) cfg.getDouble(locationname + ".yaw");

            return new Location(world, x, y, z, yaw, pitch);
        } else {
            World world = Bukkit.getWorld(cfg.getString(locationname + ".world"));
            double x = cfg.getDouble(locationname + ".x");
            double y = cfg.getDouble(locationname + ".y");
            double z = cfg.getDouble(locationname + ".z");
            float pitch = (float) cfg.getDouble(locationname + ".pitch");
            float yaw = (float) cfg.getDouble(locationname + ".yaw");

            return new Location(world,x,y,z,yaw,pitch);
        }
    }

    public static void create() {

        if(!file.exists()) {
            try {
                file.createNewFile();

            } catch (IOException e) {
                // TODO Auto-generated catch block
                Api.getLogger().error(e);
            }
        }
    }

    public FileConfiguration getFileConfig() {
        return YamlConfiguration.loadConfiguration(file);
    }

    public YamlConfiguration getYamlConfig() {
        return YamlConfiguration.loadConfiguration(file);
    }

    public File getFile() {
        return file;
    }

}

package de.cericx.coreapi.util.messagebuilder;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;

/***
 *
 * @author Cericx_
 * @version 1.0
 * @since 11.07.2021
 *
 */

public class MessageConfigBuilder {


        public final static FileConfiguration cfg = new Message().cfg;
        public final static File file = new Message().file;

        public MessageConfigBuilder() {


            cfg.options().header("#Change Text here to set Messages\n#Have fun ;)");
            try {
                cfg.save(file);
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }

        public static void setText(String msgname, String text) {
            if(cfg.getString(msgname) == null) {
                cfg.set(msgname, text);

                try {
                    cfg.save(file);
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        }

        public static String getText(String msgname, String text) {
            if(cfg.getString(msgname)==null) {
                setText(msgname, text);
                return cfg.getString(msgname).replace("&", "§");
            } else
                return cfg.getString(msgname).replace("&", "§");
        }

        public static void create() {

            if(!file.exists()) {
                try {
                    file.createNewFile();

                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
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

package org.coreapi.util.messagebuilder;

import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.coreapi.api.Api;

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


            cfg.options().header("Change Text here to set Messages\nae = ä\noe = ö\nue = ü\nHave fun ;)");
            try {
                cfg.save(file);
            } catch (IOException e) {
                // TODO Auto-generated catch block
                Api.getLogger().error(e);
            }
        }

        public static void setText(String msgname, String text) {
            if(cfg.getString(msgname) == null) {
                cfg.set(msgname, text);

                try {
                    cfg.save(file);
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    Api.getLogger().error(e);
                }
            }
        }

        public static String getText(String msgname, String text) {
            if(cfg.getString(msgname)==null) {
                setText(msgname, text);
                return ChatColor.translateAlternateColorCodes('&', cfg.getString(msgname));
            } else
                return ChatColor.translateAlternateColorCodes('&', cfg.getString(msgname));
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

package de.cericx.coreapi.messagebuilder;

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

        String msgname = "";
        String text = "";
        FileConfiguration cfg = new Message().cfg;
        File file = new Message().file;

        public MessageConfigBuilder(String messagename) {
            msgname = messagename;


            cfg.options().header("#Change Text here to set Messages\n#Have fun ;)");
            try {
                cfg.save(file);
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

        }

        public MessageConfigBuilder() {}

        public void setText(String text) {
            if(cfg.getString(msgname) == null) {
                this.text = text;
                cfg.set(msgname, text);

                try {
                    cfg.save(file);
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        }

        public String getText() {
            if(cfg.getString(msgname)==null) {
                return "set a text in the config first.";
            }else
                return cfg.getString(msgname).replace("&", "§");
        }

        public void create() {

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

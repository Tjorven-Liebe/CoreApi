package de.cericx.coreapi.messagebuilder;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;

public class Message {
    public Message() {

    }

    public Message(String msgname, String text) {
        new MessageConfigBuilder(msgname).setText(text);
        this.text = text;
        this.msgname = msgname;
    }

    String msgname = "";
    String text = "";


    public String get() {
        return new MessageConfigBuilder(msgname).getText();
    }

    public File file = new File("knockit/messages/message.yml");
    public FileConfiguration cfg = YamlConfiguration.loadConfiguration(file);
}

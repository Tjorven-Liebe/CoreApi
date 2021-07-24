package de.cericx.coreapi.util.messagebuilder;

import de.cericx.coreapi.util.Constants;
import de.cericx.coreapi.util.multilanguage.Translate;
import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;

public class Message {

    String msgname = "";
    String text = "";




    public static String get(String msgname, String text) {
        return MessageConfigBuilder.getText(msgname, text);
    }

    public static String getTranslated(String msgname, String text, String fromLanguage, String toLanguage) {return new Translate().translate(MessageConfigBuilder.getText(msgname, text), fromLanguage, toLanguage); }

    public static String getCentered(String msgname, String text) {
        return getCenteredMessage(getCenteredMessage(MessageConfigBuilder.getText(msgname, text)));
    }

    public static String getTranslatedCentered(String msgname, String text, String fromLanguage, String toLanguage) {return getCenteredMessage(new Translate().translate(MessageConfigBuilder.getText(msgname, text), fromLanguage, toLanguage)); }

    public File file = new File(Constants.foldername + "/messages/message.yml");
    public FileConfiguration cfg = YamlConfiguration.loadConfiguration(file);

    private final static int CENTER_PX = 80;

    public static String getCenteredMessage(String message){
        if(message == null || message.equals("")) return "";
        message = ChatColor.translateAlternateColorCodes('&', message);

        int messagePxSize = 0;
        boolean previousCode = false;
        boolean isBold = false;



        for(char c : message.toCharArray()){
            if(c == '§'){
                previousCode = true;
                continue;
            }else if(previousCode == true){
                previousCode = false;
                if(c == 'l' || c == 'L'){
                    isBold = true;
                    continue;
                }else isBold = false;
            }else{
                DefaultFontInfo dFI = DefaultFontInfo.getDefaultFontInfo(c);
                messagePxSize += isBold ? dFI.getBoldLength() : dFI.getLength();
                messagePxSize++;
            }
        }

        int halvedMessageSize = messagePxSize / 2;
        int toCompensate = CENTER_PX - halvedMessageSize;
        int spaceLength = DefaultFontInfo.SPACE.getLength() + 1;
        int compensated = 0;
        StringBuilder sb = new StringBuilder();
        while(compensated < toCompensate){
            sb.append(" ");
            compensated += spaceLength;
        }
        return sb.toString() + message;
    }
}
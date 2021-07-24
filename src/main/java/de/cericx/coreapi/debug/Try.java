package de.cericx.coreapi.debug;

import de.cericx.coreapi.util.logger.Prefix;
import de.cericx.coreapi.util.messagebuilder.Message;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Try implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(sender instanceof Player) {
            Player p = (Player) sender;
            if(args.length == 0) {
                p.sendMessage(Message.getCenteredMessage("§8§m                                      "));
                p.sendMessage(Message.getCenteredMessage("Du bist ein schwuler Hai!"));
                p.sendMessage(Message.getCenteredMessage("Du bib"));
                p.sendMessage(Message.getCenteredMessage("Haha du schwuler Hai."));
                p.sendMessage(Message.getCenteredMessage("§8§m                                      "));
            }else
                p.sendMessage(Prefix.use("Du musst den tollen Command verwenden der /try geht."));
        }else
            sender.sendMessage(Prefix.pre() + "Du bist fett, denn du bist kein Spieler!");

        return false;
    }

}

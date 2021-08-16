package org.coreapi.util;

import org.bukkit.entity.Player;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class ChatEndpoint {

    public void onChat(AsyncPlayerChatEvent e) {
        Player p = e.getPlayer();

    }

}

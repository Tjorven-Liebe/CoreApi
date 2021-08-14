package org.coreapi.util.logger;

import org.coreapi.util.messagebuilder.Message;

public class Prefix {

    public static String pre() {
        return Message.get("defaultprefix", "&9CoreApi &8» &7");
    }

    public static String use(String usage) {
        return pre() + usage;
    }

    public static String perm() {
        return pre() + Message.get("permission", "&cDir fehlt die Berechtigung!");
    }

    public static String notPlayer() {
        return pre() + Message.get("notplayer", "&cDu musst ein Spieler sein um diesen Befehl auszuführen!");
    }
/*
    public static String offline(String player) {
        return pre() + Message.get("offlineplayer", "&cDer Spieler &b%playername% &cist &noffline &r&coder &nexistiert &r&cnicht!", new String[]{"%playername%"}, new String[]{player});
    }

 */

}

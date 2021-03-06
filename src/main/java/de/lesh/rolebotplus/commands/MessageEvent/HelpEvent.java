package de.lesh.rolebotplus.commands.MessageEvent;

import de.lesh.rolebotplus.utils.lib;
import me.lesh.material.Blue;
import net.dv8tion.jda.core.EmbedBuilder;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

public class HelpEvent extends ListenerAdapter {

    public void onMessageReceived(MessageReceivedEvent e) {
        EmbedBuilder eB = new EmbedBuilder();
        if (e.getMessage().getContentRaw().startsWith(lib.prefix + "help")) {
            eB.setColor(Blue.b400);
            eB.addField("\uD83D\uDD14 About", "```RoleBot+ ist eine neue Version des bisherigen RoleBot. Es baut auf ein neues Serverkonzept auf und lässt sich einfacher steuern. Neben Rollen vergeben umfasst der BotInviteEvent noch andere Möglichkeiten einen Server zu managen```", false);
            eB.addField("\uD83D\uDD38 !verify", "```Du wirst für den Server freigeschaltet und bekommst mehr Rechte```", false);
            eB.addField("\uD83D\uDD38 !user", "```Erhalte Informationen über deinen Account```", false);
            e.getAuthor().openPrivateChannel().queue(msg -> msg.sendMessage(eB.build()).queue());
            if(e.getMessage().getChannel().getType().isGuild()) {
                e.getMessage().delete().queue();
            }
        }
    }

}

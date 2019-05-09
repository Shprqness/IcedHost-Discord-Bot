package club.shprqness.icedhost.events;

import net.dv8tion.jda.core.entities.Role;
import net.dv8tion.jda.core.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

public class NoInviteLinks extends ListenerAdapter {


    public void onGuildMessageReceived(GuildMessageReceivedEvent e){
        String[] args = e.getMessage().getContentRaw().split("\\s");

        Role advertiserole = e.getGuild().getRoleById(558821047508664321L);


        if(!e.getMember().getRoles().contains(advertiserole)) {
            if (e.getMessage().getContentRaw().contains("https://discord.gg")) {
                e.getMessage().delete().queue();
                e.getChannel().sendMessage("once apon a time, there was a idot who tried to advertise.").queue();
                return;
            }

            if (e.getMessage().getContentRaw().contains("discord.gg")) {
                e.getMessage().delete().queue();
                e.getChannel().sendMessage("once apon a time, there was a idot who tried to advertise.").queue();
                return;
            }

            if (e.getMessage().getContentRaw().contains("discordapp")) {
                e.getMessage().delete().queue();
                e.getChannel().sendMessage("once apon a time, there was a idot who tried to advertise.").queue();
                return;
            }


        }

    }


}

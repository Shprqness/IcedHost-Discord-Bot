package club.shprqness.icedhost.botcommands;

import net.dv8tion.jda.core.EmbedBuilder;
import net.dv8tion.jda.core.entities.Role;
import net.dv8tion.jda.core.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

import java.awt.*;

public class Announcement extends ListenerAdapter {



    public void onGuildMessageReceived(GuildMessageReceivedEvent e){
        String[] args = e.getMessage().getContentRaw().split(" ");


        Role announcerole = e.getGuild().getRoleById(558675496922251296L);

        if(args[0].equalsIgnoreCase("!announce")){

            if(!e.getMember().getRoles().contains(announcerole)){
                e.getMessage().delete().queue();
                e.getChannel().sendMessage("No Permission!").queue();
                return;
            }

            StringBuilder sb = new StringBuilder();

            for (int i = 1; i < args.length; i++){
                sb.append(args[i]).append(" ");
            }

            EmbedBuilder a = new EmbedBuilder();

            a.setTitle("IcedHost | Announcements", "https://icedhost.net");
            a.addField("Announcement", sb.toString(), false);
            a.setColor(Color.blue);
            a.addField("Regards from,", e.getMember().getAsMention(), false);
            a.setFooter("https://icedhost.net - IcedHost", "https://cdn.discordapp.com/attachments/558670965001814041/558674019591651359/icedlogo2.png");
            e.getGuild().getTextChannelById(568720441842335754L).sendMessage("@everyone").queue();
            e.getGuild().getTextChannelById(568720441842335754L).sendMessage(a.build()).queue();


        }



    }




}

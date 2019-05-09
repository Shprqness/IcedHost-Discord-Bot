package club.shprqness.icedhost.botcommands;

import net.dv8tion.jda.core.entities.Member;
import net.dv8tion.jda.core.entities.Role;
import net.dv8tion.jda.core.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

import java.util.ArrayList;

public class SupportCommand extends ListenerAdapter {
    public static ArrayList<Member> staff = new ArrayList<>();


    public void onGuildMessageReceived(GuildMessageReceivedEvent e){
        String[] args = e.getMessage().getContentRaw().split(" ");


        StringBuilder sb = new StringBuilder();

        for (int i = 1; i < args.length; i++){
            sb.append(args[i]).append(" ");
        }

        if(args[0].equalsIgnoreCase("!support")) {


            if (staff.size() == 0) {
                e.getChannel().sendMessage("There are no staff members with alerts toggled on right now!").queue();
            } else {


                e.getChannel().sendMessage("Staff have been alerted, you will be sent a direct message or get mentioned.").queue();
                Role alert = e.getGuild().getRoleById(559730933566144530L);

                if (e.getMember().getRoles().contains(alert)) {
                    e.getGuild().getTextChannelById(559731631699656705L).sendMessage(sb.toString() + " > **Sent by " + e.getAuthor().getAsMention() + "**").queue();
                }
            }
        }


    }




}

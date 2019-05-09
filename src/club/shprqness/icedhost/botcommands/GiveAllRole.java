package club.shprqness.icedhost.botcommands;

import net.dv8tion.jda.core.entities.Member;
import net.dv8tion.jda.core.entities.Role;
import net.dv8tion.jda.core.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

public class GiveAllRole extends ListenerAdapter {


    public void onGuildMessageReceived(GuildMessageReceivedEvent e){
        String[] args = e.getMessage().getContentRaw().split(" ");

        if(args[0].equalsIgnoreCase("!notifyme")){

            Role noti = e.getGuild().getRoleById(561230500048535564L);

            if(e.getMember().getRoles().contains(noti)){
                e.getMember().getGuild().getController().removeSingleRoleFromMember(e.getMember(), e.getGuild().getRolesByName("NotifyMe", true).get(0)).queue();
                e.getChannel().sendMessage("Removed Role").queue();
            }else{
                e.getMember().getGuild().getController().addSingleRoleToMember(e.getMember(), e.getGuild().getRolesByName("NotifyMe", true).get(0)).queue();
                e.getChannel().sendMessage("Added Role").queue();
            }

        }
    }


}

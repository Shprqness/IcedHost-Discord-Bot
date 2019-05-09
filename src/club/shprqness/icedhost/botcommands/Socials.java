package club.shprqness.icedhost.botcommands;

import net.dv8tion.jda.core.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

public class Socials extends ListenerAdapter {


    public void onGuildMessageReceived(GuildMessageReceivedEvent e){
        String[] args = e.getMessage().getContentRaw().split(" ");

        if(args[0].equalsIgnoreCase("!website") || args[0].equalsIgnoreCase("!site") ){

            e.getChannel().sendMessage("Check out IcedHost's Website here -> `https://icedhost.net`").queue();

        }

        if(args[0].equalsIgnoreCase("!panel")){

            e.getChannel().sendMessage("Check out IcedHost's Panel here -> `https://panel.icedhost.net`").queue();

        }

        if(args[0].equalsIgnoreCase("!status")){

            e.getChannel().sendMessage("Check out IcedHost's Status page here -> `https://status.icedhost.net`").queue();

        }



    }


}

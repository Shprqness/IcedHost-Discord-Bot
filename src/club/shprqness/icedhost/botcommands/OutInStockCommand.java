package club.shprqness.icedhost.botcommands;

import net.backlion.core.utils.DefaultPlayer;
import net.dv8tion.jda.core.entities.Role;
import net.dv8tion.jda.core.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

import java.util.concurrent.TimeUnit;

public class OutInStockCommand extends ListenerAdapter {
    /*
    !stock [product]
!outofstock [product]
     */

    public void onGuildMessageReceived(GuildMessageReceivedEvent e){
        String[] args = e.getMessage().getContentRaw().split(" ");
        Role needed = e.getGuild().getRoleById(558675496922251296L);
        if(args[0].equalsIgnoreCase("!stock")) {
            if (e.getMember().getRoles().contains(needed)) {
                if (args.length == 0) {
                    e.getChannel().sendMessage("Please use '!stock [product]").queueAfter(10, TimeUnit.SECONDS);
                    return;
                }

                e.getGuild().getTextChannelById(571076060733505546L).sendMessage("✔️" + args[1] + " is now in stock!").queue();

            }
        }
        if(args[0].equalsIgnoreCase("!outofstock")){
            if (e.getMember().getRoles().contains(needed)) {
                if (args.length == 0) {
                    e.getChannel().sendMessage("Please use '!outofstock [product]").queueAfter(10, TimeUnit.SECONDS);
                    return;
                }

                e.getGuild().getTextChannelById(571076060733505546L).sendMessage("❌ " + args[1] + " is now out of stock!").queue();
            }
        }

    }


}

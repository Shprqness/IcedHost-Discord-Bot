package club.shprqness.icedhost.botcommands;

import net.dv8tion.jda.core.entities.Role;
import net.dv8tion.jda.core.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

public class GetRoleAlert extends ListenerAdapter {



    public void onGuildMessageReceived(GuildMessageReceivedEvent e) {
        String[] args = e.getMessage().getContentRaw().split(" ");

        Role supportteam = e.getGuild().getRoleById(532558994456444949L);
        Role alert = e.getGuild().getRoleById(559730933566144530L);

        if (args[0].equalsIgnoreCase("!alerts"))
            if (e.getMember().getRoles().contains(supportteam)) {


                if (!e.getMember().getRoles().contains(alert)) {
                    SupportCommand.staff.add(e.getMember());
                    e.getMember().getGuild().getController().addSingleRoleToMember(e.getMember(), e.getGuild().getRolesByName("Alerts", true).get(0)).queue();
                    e.getChannel().sendMessage("Given Role.").queue();
                    return;
                }

                if (e.getMember().getRoles().contains(alert)) {
                    SupportCommand.staff.remove(e.getMember());
                    e.getMember().getGuild().getController().removeSingleRoleFromMember(e.getMember(), e.getGuild().getRolesByName("Alerts", true).get(0)).queue();
                    e.getChannel().sendMessage("Removed Role.").queue();
                    return;
                }


            } else {
                e.getChannel().sendMessage("No permission.").queue();
            }
    }







}

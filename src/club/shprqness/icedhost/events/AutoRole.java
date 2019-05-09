package club.shprqness.icedhost.events;

import net.dv8tion.jda.core.events.guild.member.GuildMemberJoinEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

public class AutoRole extends ListenerAdapter {


    public void onGuildMemberJoin(GuildMemberJoinEvent e){


        e.getMember().getGuild().getController().addSingleRoleToMember(e.getMember(), e.getGuild().getRolesByName("Member", true).get(0)).queue();


    }



}

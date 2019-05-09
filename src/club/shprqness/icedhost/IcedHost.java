package club.shprqness.icedhost;

import club.shprqness.icedhost.botcommands.*;
import club.shprqness.icedhost.events.AutoRole;
import club.shprqness.icedhost.events.NoInviteLinks;
import net.dv8tion.jda.core.AccountType;
import net.dv8tion.jda.core.JDA;
import net.dv8tion.jda.core.JDABuilder;
import net.dv8tion.jda.core.OnlineStatus;
import net.dv8tion.jda.core.entities.Game;

import javax.security.auth.login.LoginException;


public class IcedHost {


    private static JDA jda;

    public static void main(String[] args) throws LoginException {

        jda = new JDABuilder(AccountType.BOT).setToken("kg[f]ik3-w0kjflgjsadgophjspohjs").buildAsync();

        jda.getPresence().setGame(Game.playing("IcedHost.net"));
        jda.getPresence().setStatus(OnlineStatus.DO_NOT_DISTURB);

        jda.addEventListener(new Announcement());
        jda.addEventListener(new Socials());
        jda.addEventListener(new AutoRole());
        jda.addEventListener(new NoInviteLinks());
        jda.addEventListener(new SupportCommand());
        jda.addEventListener(new GetRoleAlert());
        jda.addEventListener(new GiveAllRole());
        jda.addEventListener(new noti());
        jda.addEventListener(new OutInStockCommand());
    }


}

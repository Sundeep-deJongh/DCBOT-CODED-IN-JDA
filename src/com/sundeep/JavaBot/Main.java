package com.sundeep.JavaBot;

import com.sundeep.JavaBot.Commands.Clear;
import com.sundeep.JavaBot.Events.GuildMemberJoin;
import com.sundeep.JavaBot.Events.GuildMemberLeave;

import net.dv8tion.jda.api.AccountType;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.OnlineStatus;
import net.dv8tion.jda.api.entities.Activity;

public class Main {
	
	public static JDA jda;
	
	public static String prefix = "!";

    @SuppressWarnings("deprecation")
	public static void main(String[] args) throws Exception {
    	jda = new JDABuilder(AccountType.BOT).setToken("NjkzMDkyMTAxNzM0NDAwMTMx.Xn4CUg.cRkb_cJU_ZHG-Jzq5eY44OkWtbY").build();
    	jda.getPresence().setStatus(OnlineStatus.DO_NOT_DISTURB);
    	jda.getPresence().setActivity(Activity.watching("Marijn is een aap!"));
    	
    	jda.addEventListener(new Clear());
		jda.addEventListener(new GuildMemberJoin());
		jda.addEventListener(new GuildMemberLeave());

    }
	
}

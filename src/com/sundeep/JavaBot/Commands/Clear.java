package com.sundeep.JavaBot.Commands;

import java.awt.Color;
import java.util.List;

import com.sundeep.JavaBot.Main;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class Clear extends ListenerAdapter {
	
	public void onGuildMessageReceived(GuildMessageReceivedEvent event) {
	
			String[] args = event.getMessage().getContentRaw().split("\\s+");
			
			if (args[0].equalsIgnoreCase(Main.prefix + "clear")) {
				
				if (args.length < 2) {
					
					EmbedBuilder gebruik = new EmbedBuilder();
					gebruik.setTitle("Geef een geldig aantal op");
					gebruik.setColor(Color.magenta);
					gebruik.setDescription("Gebruik: `" + Main.prefix + "clear [Aantal berichten]`");
					gebruik.setThumbnail("https://www.google.com/url?sa=i&url=https%3A%2F%2Fwww.pinterest.com%2Fpin%2F461759768039089375%2F&psig=AOvVaw0TD21qzhzxAwoVA6fOR-NF&ust=1609255964323000&source=images&cd=vfe&ved=0CAIQjRxqFwoTCMDCteP_8O0CFQAAAAAdAAAAABAK");
					event.getChannel().sendMessage(gebruik.build()).queue();
					
			}
				else {
					
					try {
						
					List<Message> messages = event.getChannel().getHistory().retrievePast(Integer.parseInt(args[1])).complete();
					event.getChannel().deleteMessages(messages).queue();
					
					EmbedBuilder succes = new EmbedBuilder();
					succes.setTitle("Command succesvol uitgevoerd!");
					succes.setColor(Color.magenta);
					succes.setDescription("✅ " + args[1] + " berichten verwijderd");
					event.getChannel().sendMessage(succes.build()).queue();
				}
				
			
				catch (IllegalArgumentException e) {
					if (e.toString().startsWith("java.lang.IllegalArgumentException message retrieval")) {
						
						EmbedBuilder error = new EmbedBuilder();
						error.setColor(Color.magenta);
						error.setTitle("🔴 Teveel berichten geselecteerd");
						error.setDescription("Kies een aantal tussen 1-100 berichten.");
						event.getChannel().sendMessage(error.build()).queue();	
					}
					else {
						
						EmbedBuilder error = new EmbedBuilder();
						error.setColor(Color.magenta);
						error.setTitle("🔴 Het aantal berichten is ouder dan 2 weken");
						error.setDescription("Ik kan geen berichten verwijderen die ouder zijn dan 2 weken.");
						event.getChannel().sendMessage(error.build()).queue();						
					}
				}
		}

			}
	}
}

package fr.loockeeer.moderation;

import java.util.ArrayList;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.entity.EntityDamageEvent;

public class GodCommand implements CommandExecutor {
	ArrayList<Player> god = new ArrayList<Player>();
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String msg, String[] args) {
		if(sender instanceof Player) {
			Player player = (Player)sender;
			if(player.hasPermission("god.use")) {
				if(god.contains(player)) {
					god.remove(player);
					player.sendMessage("Vous n'êtes plus en god-mode !");
				}
				else if(!god.contains(player)) {
					god.add(player);
					player.sendMessage("Vous êtes désormais en god-mode !");
				}
			}
		}
		return false;
	}
	@EventHandler
	public void onDamage(EntityDamageEvent event, Entity player) {
		if(player instanceof Player) {
			if(god.contains(player)) {
				System.out.println(event.getCause());
				event.setCancelled(true);
			}
		}
	}
}

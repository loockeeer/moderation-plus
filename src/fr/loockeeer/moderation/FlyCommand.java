package fr.loockeeer.moderation;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class FlyCommand implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String msg, String[] args) {
		if(sender instanceof Player) {
			Player player = (Player)sender;
			if(player.hasPermission("fly.use")) {
				if(player.isFlying()) {
					player.setFlying(false);
					player.setAllowFlight(false);
					player.sendMessage("[Moderation+] Fly désactivé !");
				}
				else if(!player.isFlying()) {
					player.setAllowFlight(true);
					player.setFlying(true);
					player.sendMessage("[Moderation+] Fly activé !");
				}
			}
			else {
				player.sendMessage("[Moderation+] You doesn't have the permisson to use this command.");
			}


		}
		return false;
	}

}

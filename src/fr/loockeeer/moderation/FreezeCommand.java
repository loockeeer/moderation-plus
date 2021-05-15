package fr.loockeeer.moderation;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class FreezeCommand implements CommandExecutor {
	ArrayList<Player> freeze = new ArrayList<Player>();
	
	@SuppressWarnings("deprecation")
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String msg, String[] args) {
		if(sender instanceof Player) {
			Player player = (Player)sender;
			Player targetP = Bukkit.getPlayer(args[0]);
			float walkSpeed = targetP.getWalkSpeed();
			if (freeze.contains(targetP)) {
				if(player.hasPermission("freeze.use")) {
					freeze.remove(targetP);
					targetP.setWalkSpeed(walkSpeed);
					targetP.sendTitle("§cVous venez d'être dé-freeze.", "§e");
					player.sendMessage("§cLe joueur "+targetP.getName()+" n'a plus ses mennotes !");
				}
			else {
				if(player.hasPermission("freeze.use"))  {
					freeze.add(targetP);
					targetP.setWalkSpeed(0);
					targetP.sendTitle("§cVous venez d'être freeze.", "§e");
					player.sendMessage("§cLe joueur "+targetP.getName()+" est freeze !");
					}	
				}
			}
		}
		return false;
	}

}

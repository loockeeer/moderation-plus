package fr.loockeeer.moderation;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class EcCommand implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String msg, String[] args) {
		if(sender instanceof Player) {
			Player player = (Player)sender;
			try {
				Player target = Bukkit.getPlayer(args[0]);
				player.openInventory(target.getEnderChest());
				player.sendMessage("Ouverture de l'enderchest de " + args[0]+".");
			}
			catch(Exception e) {
				player.sendMessage("Le joueur "+args[0]+" n'a pas été trouvé.");
				return false;
			}
		}
		return false;
	}

}

package fr.loockeeer.moderation;

import org.bukkit.plugin.java.JavaPlugin;

import fr.loockeeer.moderation.commands.AlertCommand;

public class Main extends JavaPlugin {
	
	@Override
	public void onEnable() {
		System.out.println("[Moderation+] Enabling Plugin...");
		System.out.println("[Moderation+] Plugin Enabled !");
		getCommand("alert").setExecutor(new AlertCommand());
		getCommand("fly").setExecutor(new FlyCommand());
		getCommand("god").setExecutor(new GodCommand());
		getCommand("ec").setExecutor(new EcCommand());
		getCommand("freeze").setExecutor(new FreezeCommand());
	}
	
	@Override
	public void onDisable() {
		System.out.println("[Moderation+] Disabling Plugin...");
		System.out.println("[Moderation+] Plugin Disabled !");
	}
}

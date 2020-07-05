package me.spypat.fortunemc;

import java.util.HashMap;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.permissions.Permission;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

import me.spypat.fortunemc.commands.Commands;
import me.spypat.fortunemc.listeners.EntityDamageEntity;
import me.spypat.fortunemc.listeners.PlayerPlaceBlockEvent;
import me.spypat.fortunemc.listeners.PlayerTeleportEvent;
import net.md_5.bungee.api.ChatColor;

public class FortuneMC extends JavaPlugin{
	public static FortuneMC plugin;
	
	public HashMap<String, Boolean> features = new HashMap<String, Boolean>();
	public HashMap<String, Boolean> perms = new HashMap<String, Boolean>();
	
	FileConfiguration config = getConfig();
	
	@Override
	 public void onEnable(){
			this.getConfig().options().copyDefaults(true);
			this.getConfig().addDefault("fortunemc.enabled", true);
			this.saveDefaultConfig();
			plugin = this;
			System.out.print("Enabling FortuneMC 1.0.0 By Spypat!");
			new PlayerPlaceBlockEvent(plugin);
			new PlayerTeleportEvent(plugin);
			new EntityDamageEntity(plugin);
			
			this.getCommand("fortunemc").setExecutor(new Commands(this));
			
			/*features.put("chorus", true);
			features.put("pearl", true);
			features.put("fish", true);
			features.put("bucket", true);
			features.put("nether", true);
			perms.put("chorus", false);
			perms.put("pearl", false);
			perms.put("nether", false);*/
			
			new Permission("fortunemc.main");
			new Permission("fortunemc.edit");
			new Permission("fortunemc.commands");
			new Permission("fortunemc.permissions");
			new Permission("fortunemc.version");
			new Permission("fortunemc.features");

			//Make Config
			if(!config.contains("fortunemc.features")){
				features.put("chorus", true);
				features.put("pearl", true);
				features.put("fish", true);
				features.put("bucket", true);
				features.put("nether", true);
				config.set("fortunemc.features.chorus", true);
				config.set("fortunemc.features.pearl", true);
				config.set("fortunemc.features.fish", true);
				config.set("fortunemc.features.bucket", true);
				config.set("fortunemc.features.nether", true);
				this.saveConfig();
			}else{
				features.put("chorus", config.getBoolean("fortunemc.features.chorus"));
				features.put("pearl", config.getBoolean("fortunemc.features.pearl"));
				features.put("fish", config.getBoolean("fortunemc.features.fish"));
				features.put("bucket", config.getBoolean("fortunemc.features.bucket"));
				features.put("nether", config.getBoolean("fortunemc.features.nether"));
			}
			
			if(!config.contains("fortunemc.perms")){
				perms.put("chorus", false);
				perms.put("pearl", false);
				perms.put("nether", false);
				config.set("fortunemc.perms.chorus", false);
				config.set("fortunemc.perms.pearl", false);
				config.set("fortunemc.perms.nether", false);
				this.saveConfig();
			}else{
				perms.put("chorus", config.getBoolean("fortunemc.perms.chorus"));
				perms.put("pearl", config.getBoolean("fortunemc.perms.pearl"));
				perms.put("nether", config.getBoolean("fortunemc.perms.nether"));
			}
			
			System.out.print("Enabled FortuneMC 1.0.0 By Spypat!");
	    }
	    // Fired when plugin is disabled
	
	@Override
	 public void onDisable() {
		System.out.print("Disabling SpigotMC 1.0.0 By Spypat!");
		this.saveConfig();
	 }
	
	public static FortuneMC getInstance(){
		return plugin;
	}
	public void toggleFeature(String name, Player p){
		if(name.equalsIgnoreCase("chorus")){
			if(features.containsKey("chorus")){
				if(features.get("chorus")==true){
					features.replace("chorus", false);
					config.set("fortunemc.features.chorus", false);
					this.saveConfig();
					p.sendMessage(ChatColor.AQUA+"Chorus Fruit Raid Fix "+ChatColor.RED+"Has Been Disabled!");
					return;
				}
				if(features.get("chorus")==false){
					features.replace("chorus", true);
					config.set("fortunemc.features.chorus", true);
					this.saveConfig();
					p.sendMessage(ChatColor.AQUA+"Chorus Fruit Raid Fix "+ChatColor.RED+"Has Been Enabled!");
					return;
				}
				p.sendMessage(ChatColor.RED+"Something Went Wrong! Please Contact Spypat!");
			}
			p.sendMessage(ChatColor.RED+"Something Went Wrong! Please Contact Spypat!");
		}
		if(name.equalsIgnoreCase("pearl")){
			if(features.containsKey("pearl")){
				if(features.get("pearl")==true){
					features.replace("pearl", false);
					config.set("fortunemc.features.pearl", false);
					this.saveConfig();
					p.sendMessage(ChatColor.AQUA+"Ender Pearl Exploit Fix "+ChatColor.RED+"Has Been Disabled!");
					return;
				}
				if(features.get("pearl")==false){
					features.replace("pearl", true);
					config.set("fortunemc.features.pearl", true);
					this.saveConfig();
					p.sendMessage(ChatColor.AQUA+"Ender Pearl Exploit Fix "+ChatColor.RED+"Has Been Enabled!");
					return;
				}
				p.sendMessage(ChatColor.RED+"Something Went Wrong! Please Contact Spypat!");
			}
			p.sendMessage(ChatColor.RED+"Something Went Wrong! Please Contact Spypat!");
		}
		if(name.equalsIgnoreCase("bucket")){
			if(features.containsKey("bucket")){
				if(features.get("bucket")==true){
					features.replace("bucket", false);
					config.set("fortunemc.features.bucket", false);
					this.saveConfig();
					p.sendMessage(ChatColor.AQUA+"Bucket Stacking "+ChatColor.RED+"Has Been Disabled!");
					return;
				}
				if(features.get("bucket")==false){
					features.replace("bucket", true);
					config.set("fortunemc.features.bucket", true);
					this.saveConfig();
					p.sendMessage(ChatColor.AQUA+"Bucket Stacking "+ChatColor.RED+"Has Been Enabled!");
					return;
				}
				p.sendMessage(ChatColor.RED+"Something Went Wrong! Please Contact Spypat!");
			}
			p.sendMessage(ChatColor.RED+"Something Went Wrong! Please Contact Spypat!");
		}
		if(name.equalsIgnoreCase("nether")){
			if(features.containsKey("nether")){
				if(features.get("nether")==true){
					features.replace("nether", false);
					config.set("fortunemc.features.nether", false);
					this.saveConfig();
					p.sendMessage(ChatColor.AQUA+"Nether Exploit Fix "+ChatColor.RED+"Has Been Disabled!");
					return;
				}
				if(features.get("nether")==false){
					features.replace("nether", true);
					config.set("fortunemc.features.nether", true);
					this.saveConfig();
					p.sendMessage(ChatColor.AQUA+"Nether Exploit Fix "+ChatColor.RED+"Has Been Enabled!");
					return;
				}
				p.sendMessage(ChatColor.RED+"Something Went Wrong! Please Contact Spypat!");
			}
			p.sendMessage(ChatColor.RED+"Something Went Wrong! Please Contact Spypat!");
		}
		if(name.equalsIgnoreCase("fish")){
			if(features.containsKey("fish")){
				if(features.get("fish")==true){
					features.replace("fish", false);
					config.set("fortunemc.features.fish", false);
					this.saveConfig();
					p.sendMessage(ChatColor.AQUA+"Fishing Exploit Fix "+ChatColor.RED+"Has Been Disabled!");
					return;
				}
				if(features.get("fish")==false){
					features.replace("fish", true);
					config.set("fortunemc.features.fish", true);
					this.saveConfig();
					p.sendMessage(ChatColor.AQUA+"Fishing Exploit Fix "+ChatColor.RED+"Has Been Enabled!");
					return;
				}
				p.sendMessage(ChatColor.RED+"Something Went Wrong! Please Contact Spypat!");
			}
			p.sendMessage(ChatColor.RED+"Something Went Wrong! Please Contact Spypat!");
		}
		p.sendMessage(ChatColor.RED+"Something Went Wrong! Please Contact Spypat!");
	}
	
	public void togglePerms(String name, Player p){
		if(name.equalsIgnoreCase("chorus")){
			if(perms.containsKey("chorus")){
				if(perms.get("chorus")==true){
					perms.replace("chorus", false);
					config.set("fortunemc.perms.chorus", false);
					this.saveConfig();
					p.sendMessage(ChatColor.AQUA+"Chorus Fruit Raid Fix Override "+ChatColor.RED+"Has Been Disabled!");
					return;
				}
				if(perms.get("chorus")==false){
					perms.replace("chorus", true);
					config.set("fortunemc.perms.chorus", true);
					this.saveConfig();
					p.sendMessage(ChatColor.AQUA+"Chorus Fruit Raid Fix Override "+ChatColor.RED+"Has Been Enabled!");
					return;
				}
				p.sendMessage(ChatColor.RED+"Something Went Wrong! Please Contact Spypat!");
			}
			p.sendMessage(ChatColor.RED+"Something Went Wrong! Please Contact Spypat!");
		}
		if(name.equalsIgnoreCase("pearl")){
			if(perms.containsKey("pearl")){
				if(perms.get("pearl")==true){
					perms.replace("pearl", false);
					config.set("fortunemc.perms.pearl", false);
					this.saveConfig();
					p.sendMessage(ChatColor.AQUA+"Ender Pearl Exploit Fix Override "+ChatColor.RED+"Has Been Disabled!");
					return;
				}
				if(perms.get("pearl")==false){
					perms.replace("pearl", true);
					config.set("fortunemc.perms.pearl", true);
					this.saveConfig();
					p.sendMessage(ChatColor.AQUA+"Ender Pearl Exploit Fix Overrude "+ChatColor.RED+"Has Been Enabled!");
					return;
				}
				p.sendMessage(ChatColor.RED+"Something Went Wrong! Please Contact Spypat!");
			}
			p.sendMessage(ChatColor.RED+"Something Went Wrong! Please Contact Spypat!");
		}
		if(name.equalsIgnoreCase("nether")){
			if(perms.containsKey("nether")){
				if(perms.get("nether")==true){
					perms.replace("nether", false);
					config.set("fortunemc.perms.nether", false);
					this.saveConfig();
					p.sendMessage(ChatColor.AQUA+"Nether Exploit Fix Override "+ChatColor.RED+"Has Been Disabled!");
					return;
				}
				if(perms.get("nether")==false){
					perms.replace("nether", true);
					config.set("fortunemc.perms.nether", true);
					this.saveConfig();
					p.sendMessage(ChatColor.AQUA+"Nether Exploit Fix Override "+ChatColor.RED+"Has Been Enabled!");
					return;
				}
				p.sendMessage(ChatColor.RED+"Something Went Wrong! Please Contact Spypat!");
			}
			p.sendMessage(ChatColor.RED+"Something Went Wrong! Please Contact Spypat!");
		}
		p.sendMessage(ChatColor.RED+"Something Went Wrong! Please Contact Spypat!");
	}
	
	public boolean getFeature(String s){
		if(features.containsKey(s)){
			return features.get(s);
		}
		System.out.print("Something Went Wrong In FortuneMC! Please Contact Spypat!");
		return true;
	}
	
	public boolean getPermission(String s){
		if(perms.containsKey(s)){
			return perms.get(s);
		}
		System.out.print("Something Went Wrong In FortuneMC! Please Contact Spypat!");
		return true;
	}
}

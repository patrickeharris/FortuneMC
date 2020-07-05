package me.spypat.fortunemc.listeners;

import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.permissions.Permission;
import org.bukkit.plugin.Plugin;

import me.spypat.fortunemc.FortuneMC;

public class PlayerPlaceBlockEvent implements Listener{
	public PlayerPlaceBlockEvent(Plugin plugin){
		plugin.getServer().getPluginManager().registerEvents(this, plugin);
		Permission nether = new Permission("fortunemc.nether_override");
	}
	
	@EventHandler
	public void onPlayerPlaceBlock(BlockPlaceEvent event){
		if(event.getBlock().getWorld().getName().contains("nether")){
			if(event.getBlock().getLocation().getBlockY()>127){
				if(!FortuneMC.getInstance().getPermission("nether")){
					event.getPlayer().sendMessage(ChatColor.RED+"You Are Not Allowed To Build Above The Nether!");
					event.setCancelled(true);
					return;
				}
				if(!event.getPlayer().hasPermission("nether_override")){
					event.getPlayer().sendMessage(ChatColor.RED+"You Are Not Allowed To Build Above The Nether!");
					event.setCancelled(true);
					return;
				}
			}
		}
	}
	
}

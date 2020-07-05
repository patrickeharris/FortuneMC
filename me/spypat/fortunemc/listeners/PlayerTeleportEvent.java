package me.spypat.fortunemc.listeners;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerTeleportEvent.TeleportCause;
import org.bukkit.inventory.ItemStack;
import org.bukkit.permissions.Permission;
import org.bukkit.plugin.Plugin;

import me.spypat.fortunemc.FortuneMC;

public class PlayerTeleportEvent implements Listener{

	public PlayerTeleportEvent(Plugin plugin){
		plugin.getServer().getPluginManager().registerEvents(this, plugin);
		Permission chorus = new Permission("fortunemc.chorus_override");
		Permission pearl = new Permission("fortunemc.pearl_override");
	}
	
	@EventHandler
	public void onPlayerTeleport(org.bukkit.event.player.PlayerTeleportEvent event) {
		if (event.getCause().equals(TeleportCause.CHORUS_FRUIT)) {
			if((FortuneMC.getInstance()).getFeature("chorus")){
				for(Block b : getNearbyBlocks(event.getPlayer().getLocation(), 8)) {
					if(b.getType()==Material.OBSIDIAN){
						if(!(FortuneMC.getInstance()).getPermission("chorus")){
							event.getPlayer().sendMessage(ChatColor.RED+"You Are Too Close To Obsidian For Chorus Fruit To Teleport You!");
							event.setCancelled(true);
							return;
						}
						if(!event.getPlayer().hasPermission("chorus_override")){
							event.getPlayer().sendMessage(ChatColor.RED+"You Are Too Close To Obsidian For Chorus Fruit To Teleport You!");
							event.setCancelled(true);
							return;
						}
					}
				}
			}
		}
		if (event.getCause().equals(TeleportCause.ENDER_PEARL)) {
			if(event.getPlayer().isFlying()){
				if((FortuneMC.getInstance()).getFeature("pearl")){
					if(!(FortuneMC.getInstance()).getPermission("pearl")){
						ItemStack is = new ItemStack(Material.ENDER_PEARL);
						is.setAmount(1);
						event.getPlayer().setItemInHand(is);
						event.getPlayer().sendMessage(ChatColor.RED+"You Cannot Use An Ender Pearl In /fly!");
						event.setCancelled(true);
						return;
					}
					if(!event.getPlayer().hasPermission("pearl_override")){
						ItemStack is = new ItemStack(Material.ENDER_PEARL);
						is.setAmount(1);
						event.getPlayer().setItemInHand(is);
						event.getPlayer().sendMessage(ChatColor.RED+"You Cannot Use An Ender Pearl In /fly!");
						event.setCancelled(true);
						return;
					}
				}
			}
		}

	}
    public static List<Block> getNearbyBlocks(Location location, int radius) {
        List<Block> blocks = new ArrayList<Block>();
        for(int x = location.getBlockX() - radius; x <= location.getBlockX() + radius; x++) {
            for(int y = location.getBlockY() - radius; y <= location.getBlockY() + radius; y++) {
                for(int z = location.getBlockZ() - radius; z <= location.getBlockZ() + radius; z++) {
                   blocks.add(location.getWorld().getBlockAt(x, y, z));
                }
            }
        }
        return blocks;
    }
}

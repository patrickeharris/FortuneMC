package me.spypat.fortunemc.listeners;

import org.bukkit.entity.FishHook;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.permissions.Permission;
import org.bukkit.plugin.Plugin;

import me.spypat.fortunemc.FortuneMC;

public class EntityDamageEntity implements Listener{
	public EntityDamageEntity(Plugin plugin){
		plugin.getServer().getPluginManager().registerEvents(this, plugin);
	}
	@EventHandler
	public void onEntityDamageEntity(EntityDamageByEntityEvent event){
		if(event.getEntity() instanceof Player){
			if(event.getDamager() instanceof FishHook){
				if((FortuneMC.getInstance()).getFeature("fish")){
					event.setCancelled(true);
				}
			}
		}
	}
}

package me.spypat.fortunemc.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

import me.spypat.fortunemc.FortuneMC;
import net.md_5.bungee.api.chat.ClickEvent;
import net.md_5.bungee.api.chat.TextComponent;

public class Commands implements CommandExecutor{
	private final Plugin plugin;

	public Commands(Plugin plugin) {
		this.plugin = plugin; // Store the plugin in situations where you need it.
	}
	
	
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (cmd.getName().equalsIgnoreCase("fortunemc")) { // If the player typed /basic then do the following, note: If you only registered this executor for one command, you don't need this
			if(args.length==0){
				if(sender instanceof Player){
					Player player = (Player) sender;
					if(player.hasPermission("fortunemc.main")){
						player.sendMessage(ChatColor.BLUE+"|"+ChatColor.AQUA+"FortuneMC Commands"+ChatColor.BLUE+"|");
						player.sendMessage(ChatColor.RED+"/fortunemc"+ChatColor.GRAY+" - "+ChatColor.GOLD+"Returns A List Of Subcommands For /fortunemc!");
						player.sendMessage(ChatColor.RED+"/fortunemc commands"+ChatColor.GRAY+" - "+ChatColor.GOLD+"Returns A List Of FortuneMC's Commands!");
						player.sendMessage(ChatColor.RED+"/fortunemc permissions"+ChatColor.GRAY+" - "+ChatColor.GOLD+"Returns A List Of FortuneMC's Permissions(Can Be Enabled Or Disabled)!");
						player.sendMessage(ChatColor.RED+"/fortunemc features"+ChatColor.GRAY+" - "+ChatColor.GOLD+"Returns A List Of FortuneMC's Features (Can Be Enabled Or Disabled)!");
						player.sendMessage(ChatColor.RED+"/fortunemc version"+ChatColor.GRAY+" - "+ChatColor.GOLD+"Returns FortuneMC's Current Version!");
						return true;
					}
					player.sendMessage(ChatColor.RED+"You Don't Have Permission To Do That!");
					return true;
				}
			}
			if(args.length==2){
				if(sender instanceof Player){
					Player player = (Player) sender;
					if(player.hasPermission("fortunemc.edit")){
						if(args[0].equalsIgnoreCase("toggleperm")){
							if(args[1].equalsIgnoreCase("nether")||args[1].equalsIgnoreCase("pearl")||args[1].equalsIgnoreCase("chorus")){
								FortuneMC.getInstance().togglePerms(args[1], player);
								return true;
							}
							player.sendMessage(ChatColor.RED+"That Is Not A Valid Command! Use /fortunemc commands!");
							return true;
						}
						if(args[0].equalsIgnoreCase("togglefeature")){
							if(args[1].equalsIgnoreCase("nether")||args[1].equalsIgnoreCase("pearl")||args[1].equalsIgnoreCase("chorus")||args[1].equalsIgnoreCase("fish")){
								FortuneMC.getInstance().toggleFeature(args[1], player);
								return true;
							}
							player.sendMessage(ChatColor.RED+"That Is Not A Valid Command! Use /fortunemc commands!");
							return true;
						}
						player.sendMessage(ChatColor.RED+"That Is Not A Valid Command! Use /fortunemc commands!");
					}
					player.sendMessage(ChatColor.RED+"You Don't Have Permission To Do That!");
					return true;
				}
			}
			if(args.length==1){
				if(args[0].equalsIgnoreCase("commands")){
					if(sender instanceof Player){
						Player player = (Player) sender;
						if(player.hasPermission("fortunemc.commands")){
							player.sendMessage(ChatColor.BLUE+"|"+ChatColor.AQUA+"FortuneMC Commands"+ChatColor.BLUE+"|");
							player.sendMessage(ChatColor.RED+"/fortunemc"+ChatColor.GRAY+" - "+ChatColor.GOLD+"Returns A List Of Subcommands For /fortunemc!");
							player.sendMessage(ChatColor.RED+"/fortunemc commands"+ChatColor.GRAY+" - "+ChatColor.GOLD+"Returns A List Of FortuneMC's Commands!");
							player.sendMessage(ChatColor.RED+"/fortunemc permissions"+ChatColor.GRAY+" - "+ChatColor.GOLD+"Returns A List Of FortuneMC's Permissions(Can Be Enabled Or Disabled)!");
							player.sendMessage(ChatColor.RED+"/fortunemc features"+ChatColor.GRAY+" - "+ChatColor.GOLD+"Returns A List Of FortuneMC's Features (Can Be Enabled Or Disabled)!");
							player.sendMessage(ChatColor.RED+"/fortunemc version"+ChatColor.GRAY+" - "+ChatColor.GOLD+"Returns FortuneMC's Current Version!");
							return true;
						}
						player.sendMessage(ChatColor.RED+"You Don't Have Permission To Do That!");
						return true;
					}
				}else 
				if(args[0].equalsIgnoreCase("permissions")){
					if(sender instanceof Player){
						Player player = (Player) sender;
						if(player.hasPermission("fortunemc.permissions")){
							player.sendMessage(ChatColor.BLUE+"|"+ChatColor.AQUA+"FortuneMC Permissions"+ChatColor.BLUE+"|");
							player.sendMessage(ChatColor.RED+"fortunemc.main"+ChatColor.GRAY+" - "+ChatColor.GOLD+"Allows Use Of /fortunemc!");
							player.sendMessage(ChatColor.RED+"fortunemc.commands"+ChatColor.GRAY+" - "+ChatColor.GOLD+"Allows Use Of /fortunemc commands!");
							player.sendMessage(ChatColor.RED+"fortunemc.permissions"+ChatColor.GRAY+" - "+ChatColor.GOLD+"Allows Use Of /fortunemc permissions!");
							player.sendMessage(ChatColor.RED+"fortunemc.features"+ChatColor.GRAY+" - "+ChatColor.GOLD+"Allows Use Of /fortunemc features!");
							player.sendMessage(ChatColor.RED+"fortunemc.version"+ChatColor.GRAY+" - "+ChatColor.GOLD+"Allows Use Of /fortunemc version!");
							player.sendMessage(ChatColor.RED+"fortunemc.edit"+ChatColor.GRAY+" - "+ChatColor.GOLD+"Allows The Ability To Toggle Permissions And Features!");
							if(!FortuneMC.getInstance().getPermission("nether")){
								TextComponent message = new TextComponent("fortunemc.nether_override");
								message.setColor(net.md_5.bungee.api.ChatColor.RED);

								TextComponent dash = new TextComponent( " - " );
								dash.setColor( net.md_5.bungee.api.ChatColor.GRAY);
								message.addExtra(dash);
							
								TextComponent description = new TextComponent( "Allows Building On Top Of The Nether! " );
								description.setColor( net.md_5.bungee.api.ChatColor.GOLD);
								message.addExtra(description);

								TextComponent enable = new TextComponent( "[Enable] " );
								enable.setColor( net.md_5.bungee.api.ChatColor.GREEN);
								enable.setClickEvent( new ClickEvent( ClickEvent.Action.RUN_COMMAND, "/fortunemc toggleperm nether" ) );
								message.addExtra(enable);
							
								TextComponent disabled = new TextComponent( "[Disabled]" );
								disabled.setColor( net.md_5.bungee.api.ChatColor.DARK_RED);
								disabled.setColor(net.md_5.bungee.api.ChatColor.BOLD);
								message.addExtra(disabled);
								
								player.spigot().sendMessage(message);
							}
							if(FortuneMC.getInstance().getPermission("nether")){
								TextComponent message = new TextComponent("fortunemc.nether_override");
								message.setColor(net.md_5.bungee.api.ChatColor.RED);

								TextComponent dash = new TextComponent( " - " );
								dash.setColor( net.md_5.bungee.api.ChatColor.GRAY);
								message.addExtra(dash);
							
								TextComponent description = new TextComponent( "Allows Building On Top Of The Nether! " );
								description.setColor( net.md_5.bungee.api.ChatColor.GOLD);
								message.addExtra(description);

								TextComponent enable = new TextComponent( "[Enabled] " );
								enable.setColor( net.md_5.bungee.api.ChatColor.GREEN);
								enable.setColor(net.md_5.bungee.api.ChatColor.BOLD);
								message.addExtra(enable);
							
								TextComponent disabled = new TextComponent( "[Disable]" );
								disabled.setColor( net.md_5.bungee.api.ChatColor.DARK_RED);
								disabled.setClickEvent( new ClickEvent( ClickEvent.Action.RUN_COMMAND, "/fortunemc toggleperm nether" ) );
								message.addExtra(disabled);
								
								player.spigot().sendMessage(message);
							}
							if(!FortuneMC.getInstance().getPermission("pearl")){
								TextComponent message = new TextComponent("fortunemc.pearl_override");
								message.setColor(net.md_5.bungee.api.ChatColor.RED);

								TextComponent dash = new TextComponent( " - " );
								dash.setColor( net.md_5.bungee.api.ChatColor.GRAY);
								message.addExtra(dash);
							
								TextComponent description = new TextComponent( "Allows The Use Of Ender Pearls While Flying! " );
								description.setColor( net.md_5.bungee.api.ChatColor.GOLD);
								message.addExtra(description);

								TextComponent enable = new TextComponent( "[Enable] " );
								enable.setColor( net.md_5.bungee.api.ChatColor.GREEN);
								enable.setClickEvent( new ClickEvent( ClickEvent.Action.RUN_COMMAND, "/fortunemc toggleperm pearl" ) );
								message.addExtra(enable);
							
								TextComponent disabled = new TextComponent( "[Disabled]" );
								disabled.setColor( net.md_5.bungee.api.ChatColor.DARK_RED);
								disabled.setColor(net.md_5.bungee.api.ChatColor.BOLD);
								message.addExtra(disabled);
								
								player.spigot().sendMessage(message);
							}
							if(FortuneMC.getInstance().getPermission("pearl")){
								TextComponent message = new TextComponent("fortunemc.pearl_override");
								message.setColor(net.md_5.bungee.api.ChatColor.RED);

								TextComponent dash = new TextComponent( " - " );
								dash.setColor( net.md_5.bungee.api.ChatColor.GRAY);
								message.addExtra(dash);
							
								TextComponent description = new TextComponent( "Allows The Use Of Ender Pearls While Flying! " );
								description.setColor( net.md_5.bungee.api.ChatColor.GOLD);
								message.addExtra(description);

								TextComponent enable = new TextComponent( "[Enabled] " );
								enable.setColor( net.md_5.bungee.api.ChatColor.GREEN);
								enable.setColor(net.md_5.bungee.api.ChatColor.BOLD);
								message.addExtra(enable);
							
								TextComponent disabled = new TextComponent( "[Disable]" );
								disabled.setColor( net.md_5.bungee.api.ChatColor.DARK_RED);
								disabled.setClickEvent( new ClickEvent( ClickEvent.Action.RUN_COMMAND, "/fortunemc toggleperm pearl" ) );
								message.addExtra(disabled);
								
								player.spigot().sendMessage(message);
							}
							if(!FortuneMC.getInstance().getPermission("chorus")){
								TextComponent message = new TextComponent("fortunemc.chorus_override");
								message.setColor(net.md_5.bungee.api.ChatColor.RED);

								TextComponent dash = new TextComponent( " - " );
								dash.setColor( net.md_5.bungee.api.ChatColor.GRAY);
								message.addExtra(dash);
							
								TextComponent description = new TextComponent( "Allows Use Of Chorus Fruit Teleportation Within 8 Blocks Of Obsidian! " );
								description.setColor( net.md_5.bungee.api.ChatColor.GOLD);
								message.addExtra(description);

								TextComponent enable = new TextComponent( "[Enable] " );
								enable.setColor( net.md_5.bungee.api.ChatColor.GREEN);
								enable.setClickEvent( new ClickEvent( ClickEvent.Action.RUN_COMMAND, "/fortunemc toggleperm chorus" ) );
								message.addExtra(enable);
							
								TextComponent disabled = new TextComponent( "[Disabled]" );
								disabled.setColor( net.md_5.bungee.api.ChatColor.DARK_RED);
								disabled.setColor(net.md_5.bungee.api.ChatColor.BOLD);
								message.addExtra(disabled);
								
								player.spigot().sendMessage(message);
							}
							if(FortuneMC.getInstance().getPermission("chorus")){
								TextComponent message = new TextComponent("fortunemc.chorus_override");
								message.setColor(net.md_5.bungee.api.ChatColor.RED);

								TextComponent dash = new TextComponent( " - " );
								dash.setColor( net.md_5.bungee.api.ChatColor.GRAY);
								message.addExtra(dash);
							
								TextComponent description = new TextComponent( "Allows Use Of Chorus Fruit Teleportation Within 8 Blocks Of Obsidian! " );
								description.setColor( net.md_5.bungee.api.ChatColor.GOLD);
								message.addExtra(description);

								TextComponent enable = new TextComponent( "[Enabled] " );
								enable.setColor( net.md_5.bungee.api.ChatColor.GREEN);
								enable.setColor(net.md_5.bungee.api.ChatColor.BOLD);
								message.addExtra(enable);
							
								TextComponent disabled = new TextComponent( "[Disable]" );
								disabled.setColor( net.md_5.bungee.api.ChatColor.DARK_RED);
								disabled.setClickEvent( new ClickEvent( ClickEvent.Action.RUN_COMMAND, "/fortunemc toggleperm chorus" ) );
								message.addExtra(disabled);
								
								player.spigot().sendMessage(message);
							}
							//player.sendMessage(ChatColor.RED+"fortunemc.nether_override"+ChatColor.GRAY+" - "+ChatColor.GOLD+"Allows Building On Top Of The Nether! "+ChatColor.GREEN+"[Enable] "+ChatColor.DARK_RED+ChatColor.BOLD+"[Disabled]");
							//player.sendMessage(ChatColor.RED+"fortunemc.pearl_override"+ChatColor.GRAY+" - "+ChatColor.GOLD+"Allows The Use Of Ender Pearls While Flying! "+ChatColor.GREEN+"[Enable] "+ChatColor.DARK_RED+ChatColor.BOLD+"[Disabled]");
							//player.sendMessage(ChatColor.RED+"fortunemc.chorus_override"+ChatColor.GRAY+" - "+ChatColor.GOLD+"Allows Use Of Chorus Fruit Teleportation Within 8 Blocks Of Obsidian! "+ChatColor.GREEN+"[Enable] "+ChatColor.DARK_RED+ChatColor.BOLD+"[Disabled]");
							return true;
						}
						player.sendMessage(ChatColor.RED+"You Don't Have Permission To Do That!");
						return true;
					}
				}else 
				if(args[0].equalsIgnoreCase("version")){
					if(sender instanceof Player){
						Player player = (Player) sender;
						if(player.hasPermission("fortunemc.version")){
							player.sendMessage(ChatColor.AQUA+"This Server is Running FortuneMC Version"+ChatColor.RED+" 1.0.0"+ChatColor.AQUA+"!");
							return true;
						}
						player.sendMessage(ChatColor.RED+"You Don't Have Permission To Do That!");
						return true;
					}
				}else 
					if(args[0].equalsIgnoreCase("features")){
						if(sender instanceof Player){
							Player player = (Player) sender;
							if(player.hasPermission("fortunemc.features")){
								player.sendMessage(ChatColor.BLUE+"|"+ChatColor.AQUA+"FortuneMC Features"+ChatColor.BLUE+"|");
								if(!FortuneMC.getInstance().getFeature("nether")){
									TextComponent message = new TextComponent("Nether Exploit Fix");
									message.setColor(net.md_5.bungee.api.ChatColor.RED);

									TextComponent dash = new TextComponent( " - " );
									dash.setColor( net.md_5.bungee.api.ChatColor.GRAY);
									message.addExtra(dash);
								
									TextComponent description = new TextComponent( "Prevents Building On Top Of The Nether! " );
									description.setColor( net.md_5.bungee.api.ChatColor.GOLD);
									message.addExtra(description);

									TextComponent enable = new TextComponent( "[Enable] " );
									enable.setColor( net.md_5.bungee.api.ChatColor.GREEN);
									enable.setClickEvent( new ClickEvent( ClickEvent.Action.RUN_COMMAND, "/fortunemc togglefeature nether" ) );
									message.addExtra(enable);
								
									TextComponent disabled = new TextComponent( "[Disabled]" );
									disabled.setColor( net.md_5.bungee.api.ChatColor.DARK_RED);
									disabled.setColor(net.md_5.bungee.api.ChatColor.BOLD);
									message.addExtra(disabled);
									
									player.spigot().sendMessage(message);
								}
								if(FortuneMC.getInstance().getFeature("nether")){
									TextComponent message = new TextComponent("Nether Exploit Fix");
									message.setColor(net.md_5.bungee.api.ChatColor.RED);

									TextComponent dash = new TextComponent( " - " );
									dash.setColor( net.md_5.bungee.api.ChatColor.GRAY);
									message.addExtra(dash);
								
									TextComponent description = new TextComponent( "Prevents Building On Top Of The Nether! " );
									description.setColor( net.md_5.bungee.api.ChatColor.GOLD);
									message.addExtra(description);

									TextComponent enable = new TextComponent( "[Enabled] " );
									enable.setColor( net.md_5.bungee.api.ChatColor.GREEN);
									enable.setColor(net.md_5.bungee.api.ChatColor.BOLD);
									message.addExtra(enable);
								
									TextComponent disabled = new TextComponent( "[Disable]" );
									disabled.setColor( net.md_5.bungee.api.ChatColor.DARK_RED);
									disabled.setClickEvent( new ClickEvent( ClickEvent.Action.RUN_COMMAND, "/fortunemc togglefeature nether" ) );
									message.addExtra(disabled);
									
									player.spigot().sendMessage(message);
								}
								if(!FortuneMC.getInstance().getFeature("chorus")){
									TextComponent message = new TextComponent("Chorus Exploit Fix");
									message.setColor(net.md_5.bungee.api.ChatColor.RED);

									TextComponent dash = new TextComponent( " - " );
									dash.setColor( net.md_5.bungee.api.ChatColor.GRAY);
									message.addExtra(dash);
								
									TextComponent description = new TextComponent( "Prevents Chorus Fruit Teleportation Within 8 Blocks Of Obsidian! " );
									description.setColor( net.md_5.bungee.api.ChatColor.GOLD);
									message.addExtra(description);

									TextComponent enable = new TextComponent( "[Enable] " );
									enable.setColor( net.md_5.bungee.api.ChatColor.GREEN);
									enable.setClickEvent( new ClickEvent( ClickEvent.Action.RUN_COMMAND, "/fortunemc togglefeature chorus" ) );
									message.addExtra(enable);
								
									TextComponent disabled = new TextComponent( "[Disabled]" );
									disabled.setColor( net.md_5.bungee.api.ChatColor.DARK_RED);
									disabled.setColor(net.md_5.bungee.api.ChatColor.BOLD);
									message.addExtra(disabled);
									
									player.spigot().sendMessage(message);
								}
								if(FortuneMC.getInstance().getFeature("chorus")){
									TextComponent message = new TextComponent("Chorus Exploit Fix");
									message.setColor(net.md_5.bungee.api.ChatColor.RED);

									TextComponent dash = new TextComponent( " - " );
									dash.setColor( net.md_5.bungee.api.ChatColor.GRAY);
									message.addExtra(dash);
								
									TextComponent description = new TextComponent( "Prevents Chorus Fruit Teleportation Within 8 Blocks Of Obsidian! " );
									description.setColor( net.md_5.bungee.api.ChatColor.GOLD);
									message.addExtra(description);

									TextComponent enable = new TextComponent( "[Enabled] " );
									enable.setColor( net.md_5.bungee.api.ChatColor.GREEN);
									enable.setColor(net.md_5.bungee.api.ChatColor.BOLD);
									message.addExtra(enable);
								
									TextComponent disabled = new TextComponent( "[Disable]" );
									disabled.setColor( net.md_5.bungee.api.ChatColor.DARK_RED);
									disabled.setClickEvent( new ClickEvent( ClickEvent.Action.RUN_COMMAND, "/fortunemc togglefeature chorus" ) );
									message.addExtra(disabled);
									
									player.spigot().sendMessage(message);
								}
								if(!FortuneMC.getInstance().getFeature("fish")){
									TextComponent message = new TextComponent("Fishing Exploit Fix");
									message.setColor(net.md_5.bungee.api.ChatColor.RED);

									TextComponent dash = new TextComponent( " - " );
									dash.setColor( net.md_5.bungee.api.ChatColor.GRAY);
									message.addExtra(dash);
								
									TextComponent description = new TextComponent( "Prevents Fishing Rods From Damaging Players! " );
									description.setColor( net.md_5.bungee.api.ChatColor.GOLD);
									message.addExtra(description);

									TextComponent enable = new TextComponent( "[Enable] " );
									enable.setColor( net.md_5.bungee.api.ChatColor.GREEN);
									enable.setClickEvent( new ClickEvent( ClickEvent.Action.RUN_COMMAND, "/fortunemc togglefeature fish" ) );
									message.addExtra(enable);
								
									TextComponent disabled = new TextComponent( "[Disabled]" );
									disabled.setColor( net.md_5.bungee.api.ChatColor.DARK_RED);
									disabled.setColor(net.md_5.bungee.api.ChatColor.BOLD);
									message.addExtra(disabled);
									
									player.spigot().sendMessage(message);
								}
								if(FortuneMC.getInstance().getFeature("fish")){
									TextComponent message = new TextComponent("Fishing Exploit Fix");
									message.setColor(net.md_5.bungee.api.ChatColor.RED);

									TextComponent dash = new TextComponent( " - " );
									dash.setColor( net.md_5.bungee.api.ChatColor.GRAY);
									message.addExtra(dash);
								
									TextComponent description = new TextComponent( "Prevents Fishing Rods From Damaging Players! " );
									description.setColor( net.md_5.bungee.api.ChatColor.GOLD);
									message.addExtra(description);

									TextComponent enable = new TextComponent( "[Enabled] " );
									enable.setColor( net.md_5.bungee.api.ChatColor.GREEN);
									enable.setColor(net.md_5.bungee.api.ChatColor.BOLD);
									message.addExtra(enable);
								
									TextComponent disabled = new TextComponent( "[Disable]" );
									disabled.setColor( net.md_5.bungee.api.ChatColor.DARK_RED);
									disabled.setClickEvent( new ClickEvent( ClickEvent.Action.RUN_COMMAND, "/fortunemc togglefeature fish" ) );
									message.addExtra(disabled);
									
									player.spigot().sendMessage(message);
								}
								if(!FortuneMC.getInstance().getFeature("pearl")){
									TextComponent message = new TextComponent("Ender Pearl Explot Fix");
									message.setColor(net.md_5.bungee.api.ChatColor.RED);

									TextComponent dash = new TextComponent( " - " );
									dash.setColor( net.md_5.bungee.api.ChatColor.GRAY);
									message.addExtra(dash);
								
									TextComponent description = new TextComponent( "Prevents The Use Of Ender Pearls While Flying! " );
									description.setColor( net.md_5.bungee.api.ChatColor.GOLD);
									message.addExtra(description);

									TextComponent enable = new TextComponent( "[Enable] " );
									enable.setColor( net.md_5.bungee.api.ChatColor.GREEN);
									enable.setClickEvent( new ClickEvent( ClickEvent.Action.RUN_COMMAND, "/fortunemc togglefeature pearl" ) );
									message.addExtra(enable);
								
									TextComponent disabled = new TextComponent( "[Disabled]" );
									disabled.setColor( net.md_5.bungee.api.ChatColor.DARK_RED);
									disabled.setColor(net.md_5.bungee.api.ChatColor.BOLD);
									message.addExtra(disabled);
									
									player.spigot().sendMessage(message);
								}
								if(FortuneMC.getInstance().getFeature("pearl")){
									TextComponent message = new TextComponent("Ender Pearl Exploit Fix");
									message.setColor(net.md_5.bungee.api.ChatColor.RED);

									TextComponent dash = new TextComponent( " - " );
									dash.setColor( net.md_5.bungee.api.ChatColor.GRAY);
									message.addExtra(dash);
								
									TextComponent description = new TextComponent( "Prevents The Use Of Ender Pearls While Flying! " );
									description.setColor( net.md_5.bungee.api.ChatColor.GOLD);
									message.addExtra(description);

									TextComponent enable = new TextComponent( "[Enabled] " );
									enable.setColor( net.md_5.bungee.api.ChatColor.GREEN);
									enable.setColor(net.md_5.bungee.api.ChatColor.BOLD);
									message.addExtra(enable);
								
									TextComponent disabled = new TextComponent( "[Disable]" );
									disabled.setColor( net.md_5.bungee.api.ChatColor.DARK_RED);
									disabled.setClickEvent( new ClickEvent( ClickEvent.Action.RUN_COMMAND, "/fortunemc togglefeature pearl" ) );
									message.addExtra(disabled);
									
									player.spigot().sendMessage(message);
								}
								//player.sendMessage(ChatColor.RED+"Bucket Stacking"+ChatColor.GRAY+" - "+ChatColor.GOLD+"Allows Stacks Of Filled Buckets Up To 16! "+ChatColor.GREEN+ChatColor.BOLD+"[Enabled] "+ChatColor.DARK_RED+"[Disable]");
								//player.sendMessage(ChatColor.RED+"Nether Exploit Fix"+ChatColor.GRAY+" - "+ChatColor.GOLD+"Prevents Building On Top Of The Nether! "+ChatColor.GREEN+ChatColor.BOLD+"[Enabled] "+ChatColor.DARK_RED+"[Disable]");
								//player.sendMessage(ChatColor.RED+"Chorus Fruit Exploit Fix"+ChatColor.GRAY+" - "+ChatColor.GOLD+"Prevents Chorus Fruit Teleportation Within 8 Blocks Of Obsidian! "+ChatColor.GREEN+ChatColor.BOLD+"[Enabled] "+ChatColor.DARK_RED+"[Disable]");
								//player.sendMessage(ChatColor.RED+"Fishing Explot Fix"+ChatColor.GRAY+" - "+ChatColor.GOLD+"Prevents Fishing Rods From Damaging Players! "+ChatColor.GREEN+ChatColor.BOLD+"[Enabled] "+ChatColor.DARK_RED+"[Disable]");
								//player.sendMessage(ChatColor.RED+"Ender Pearl Explot Fix"+ChatColor.GRAY+" - "+ChatColor.GOLD+"Prevents The Use Of Ender Pearls While Flying! "+ChatColor.GREEN+ChatColor.BOLD+"[Enabled] "+ChatColor.DARK_RED+"[Disable]");
								return true;
							}
							player.sendMessage(ChatColor.RED+"You Don't Have Permission To Do That!");
							return true;
						}
					}
			}
			return true;
		} 
		return false; 
	}
}

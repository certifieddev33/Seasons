package cert.plugin.Seasons;

import org.bukkit.Bukkit;

import org.bukkit.OfflinePlayer;
import org.bukkit.WeatherType;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scheduler.BukkitScheduler;

import net.md_5.bungee.api.ChatColor;

public class SetWinter implements CommandExecutor {
	private Player player;
	private Seasons plugin;
	public SetWinter(Player p) {
		this.player = p;
	}
	public SetWinter(Seasons plugin) {
		this.plugin = plugin;
		plugin.getCommand("setwinter").setExecutor(this);
	}
	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		if(sender instanceof Player) {
			sender.sendMessage("You cannot use this command");
			return true;
		}
		Bukkit.getServer().getWorld("new").setStorm(true);
		Bukkit.getServer().getWorld("new").setThundering(false);
		Bukkit.getServer().getWorld("new").setWeatherDuration(12096000);
		Bukkit.broadcastMessage(ChatColor.AQUA + "" + ChatColor.BOLD + "NEW SEASON: WINTER");
		if(Bukkit.getOnlinePlayers().size()==0) {
			Bukkit.broadcastMessage("Nobody is online.");
			return true;
		}
		for(Player p : Bukkit.getOnlinePlayers()) {
			Bukkit.dispatchCommand(Bukkit.getServer().getConsoleSender(), "title " + p.getName() + " subtitle {\"text\":\"WINTER\", \"bold\":true, \"color\":\"aqua\"}");
			Bukkit.dispatchCommand(Bukkit.getServer().getConsoleSender(), "title " + p.getName() + " title {\"text\":\"NEW SEASON\", \"bold\":true, \"color\":\"aqua\"}");
			checkPlayer(p);
		}
		return true;
	}
	public void checkPlayer(Player p) {
		new BukkitRunnable() {
        	int count = 0;
        	@Override
        	public void run() {
        		if(p.getInventory().getHelmet()==null) {
        			if(count<4) {
        				p.sendMessage(ChatColor.AQUA + "" + ChatColor.ITALIC + "Brrr.. It's freezing. You can feel the frostbite setting in... better get some clothing on quick!");
        				count++;
        			}else {
        				p.sendMessage(ChatColor.AQUA + "" + ChatColor.ITALIC + "The frostbite has set in.. you can feel your limbs beginning to give out...");
        				p.damage(.5);
        			}
        			return;
        		}else if(p.getInventory().getChestplate()==null) {
        			if(count<4) {
        				p.sendMessage(ChatColor.AQUA + "" + ChatColor.ITALIC + "Brrr.. It's freezing. You can feel the frostbite setting in... better get some clothing on quick!");
        				count++;
        			}else {
        				p.sendMessage(ChatColor.AQUA + "" + ChatColor.ITALIC + "The frostbite has set in.. you can feel your limbs beginning to give out...");
        				p.damage(.5);
        			}
        			return;
        		}else if(p.getInventory().getLeggings()==null) {
        			if(count<4) {
        				p.sendMessage(ChatColor.AQUA + "" + ChatColor.ITALIC + "Brrr.. It's freezing. You can feel the frostbite setting in... better get some clothing on quick!");
        				count++;
        			}else {
        				p.sendMessage(ChatColor.AQUA + "" + ChatColor.ITALIC + "The frostbite has set in.. you can feel your limbs beginning to give out...");
        				p.damage(.5);
        			}
        			return;
        		}else if(p.getInventory().getBoots()==null) {
        			if(count<4) {
        				p.sendMessage(ChatColor.AQUA + "" + ChatColor.ITALIC + "Brrr.. It's freezing. You can feel the frostbite setting in... better get some clothing on quick!");
        				count++;
        			}else {
        				p.sendMessage(ChatColor.AQUA + "" + ChatColor.ITALIC + "The frostbite has set in.. you can feel your limbs beginning to give out...");
        				p.damage(.5);
        			}
        			return;
        		}else if(p.getInventory().getHelmet().getItemMeta().getDisplayName()==null) {
        			if(count<4) {
        				p.sendMessage(ChatColor.AQUA + "" + ChatColor.ITALIC + "Brrr.. It's freezing. You can feel the frostbite setting in... better get some clothing on quick!");
        				count++;
        			}else {
        				p.sendMessage(ChatColor.AQUA + "" + ChatColor.ITALIC + "The frostbite has set in.. you can feel your limbs beginning to give out...");
        				p.damage(.5);
        			}
        			return;
        		}else if(p.getInventory().getChestplate().getItemMeta().getDisplayName()==null) {
        			if(count<4) {
        				p.sendMessage(ChatColor.AQUA + "" + ChatColor.ITALIC + "Brrr.. It's freezing. You can feel the frostbite setting in... better get some clothing on quick!");
        				count++;      			
        			}else {
        				p.sendMessage(ChatColor.AQUA + "" + ChatColor.ITALIC + "The frostbite has set in.. you can feel your limbs beginning to give out...");
        				p.damage(.5);
        			}
        			return;
        		}else if(p.getInventory().getLeggings().getItemMeta().getDisplayName()==null) {
        			if(count<4) {
        				p.sendMessage(ChatColor.AQUA + "" + ChatColor.ITALIC + "Brrr.. It's freezing. You can feel the frostbite setting in... better get some clothing on quick!");
        				count++;     			
        			}else {
        				p.sendMessage(ChatColor.AQUA + "" + ChatColor.ITALIC + "The frostbite has set in.. you can feel your limbs beginning to give out...");
        				p.damage(.5);
        			}
        			return;
        		}else if(p.getInventory().getBoots().getItemMeta().getDisplayName()==null) {
        			if(count<4) {
        				p.sendMessage(ChatColor.AQUA + "" + ChatColor.ITALIC + "Brrr.. It's freezing. You can feel the frostbite setting in... better get some clothing on quick!");
        				count++;
        			}else {
        				p.sendMessage(ChatColor.AQUA + "" + ChatColor.ITALIC + "The frostbite has set in.. you can feel your limbs beginning to give out...");
        				p.damage(.5);
        			}
        			return;
        		}
        		count = 0;
        		if(!(p.getInventory().getHelmet().getItemMeta().getDisplayName().equals("Snow Cap"))||
            		!(p.getInventory().getChestplate().getItemMeta().getDisplayName().equals("Snow Vest"))||
            		!(p.getInventory().getLeggings().getItemMeta().getDisplayName().equals("Snow Leggings"))||
            		!(p.getInventory().getBoots().getItemMeta().getDisplayName().equals("Snow Boots"))) {
               			if(count<4) {
               				p.sendMessage(ChatColor.AQUA + "" + ChatColor.ITALIC + "Brrr.. It's freezing. You can feel the frostbite setting in... better get some clothing on quick!");
               				count++;
               			}else {
               				p.sendMessage(ChatColor.AQUA + "" + ChatColor.ITALIC + "The frostbite has set in.. you can feel your limbs beginning to give out...");
               				p.damage(.5);
                		}
                	}else {
                		p.sendMessage(ChatColor.AQUA + "" + ChatColor.BOLD + "You are now protected from the bitter cold...");
                		this.cancel();
                		return;
                	}
        	}
      }.runTaskTimer(Bukkit.getServer().getPluginManager().getPlugin("Seasons"), 2400, 2400);
	} 
	}

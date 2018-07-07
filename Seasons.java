package cert.plugin.Seasons;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerItemHeldEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitScheduler;

import net.md_5.bungee.api.ChatColor;

public class Seasons extends JavaPlugin implements Listener,CommandExecutor {
	int count = 0;
	private Season season;
	@Override
	public void onEnable() {
		this.setSeason(Season.WINTER);
		new SetWinter(this);
		new SetSummer(this);
		this.getCommand("setspring").setExecutor(new SetSpring());
		this.getCommand("setticks").setExecutor(new SetTicks());
		this.getCommand("ticks").setExecutor(new GetTicks());
		this.getCommand("setautumn").setExecutor(new SetAutumn());
		this.getCommand("snowgear").setExecutor(new CustomSnowGear());
		this.getCommand("getseason").setExecutor(this);
		getServer().getPluginManager().registerEvents(this, this);
		BukkitScheduler scheduler = Bukkit.getServer().getScheduler();
		scheduler.scheduleSyncRepeatingTask(this, new Runnable() {
			@Override
			public void run() {
				if(Bukkit.getServer().getWorld("new").getWeatherDuration()<=0 && count==0) {
					Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "setwinter");
					count++;
				}else if(Bukkit.getServer().getWorld("new").getWeatherDuration()<=0 && count==1) {
					Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "setspring");
					count++;
				}else if(Bukkit.getServer().getWorld("new").getWeatherDuration()<=0 && count==2) {
					Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "setsummer");
					count++;
				}else if(Bukkit.getServer().getWorld("new").getWeatherDuration()<=0 && count==3) {
					Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "setautumn");
					count=0;
				}
			}
		},0L, 1L);
	}
	@Override
	public void onDisable() {
		
	}
	public Season getSeason() {
		return this.season;
	}
	public void setSeason(Season season) {
		this.season = season;
	}
	@EventHandler
	public void onPlayerJoin(PlayerJoinEvent event) {
		if(this.getSeason().equals(Season.WINTER)) {
			SetWinter newWinter = new SetWinter(event.getPlayer());
			BukkitScheduler scheduler = Bukkit.getServer().getScheduler();
	        scheduler.scheduleSyncDelayedTask(this, new Runnable() {
	        	@Override
	        	public void run() {    		
	        		if(event.getPlayer().getInventory().getHelmet()==null) {
	        			event.getPlayer().sendMessage(ChatColor.AQUA + "" + ChatColor.ITALIC + "Brrr.. It's freezing. You can feel frostbite setting in... better get some clothing on quick!");
    					newWinter.checkPlayer(event.getPlayer());
	        			return;
	        		}
	        		if(event.getPlayer().getInventory().getChestplate()==null) {
	        			event.getPlayer().sendMessage(ChatColor.AQUA + "" + ChatColor.ITALIC + "Brrr.. It's freezing. You can feel frostbite setting in... better get some clothing on quick!");
    					newWinter.checkPlayer(event.getPlayer());
	        			return;
	        		}
	        		if(event.getPlayer().getInventory().getLeggings()==null) {
	        			event.getPlayer().sendMessage(ChatColor.AQUA + "" + ChatColor.ITALIC + "Brrr.. It's freezing. You can feel frostbite setting in... better get some clothing on quick!");
    					newWinter.checkPlayer(event.getPlayer());
	        			return;
	        		}
	        		if(event.getPlayer().getInventory().getBoots()==null) {
	        			event.getPlayer().sendMessage(ChatColor.AQUA + "" + ChatColor.ITALIC + "Brrr.. It's freezing. You can feel frostbite setting in... better get some clothing on quick!");
    					newWinter.checkPlayer(event.getPlayer());
	        			return;
	        		}
	        		if(event.getPlayer().getInventory().getHelmet().getItemMeta().getDisplayName()==null) {
	        			event.getPlayer().sendMessage(ChatColor.AQUA + "" + ChatColor.ITALIC + "Brrr.. It's freezing. You can feel frostbite setting in... better get some clothing on quick!");
    					newWinter.checkPlayer(event.getPlayer());
	        			return;
	        		}
	        		if(event.getPlayer().getInventory().getChestplate().getItemMeta().getDisplayName()==null) {
	        			event.getPlayer().sendMessage(ChatColor.AQUA + "" + ChatColor.ITALIC + "Brrr.. It's freezing. You can feel frostbite setting in... better get some clothing on quick!");
    					newWinter.checkPlayer(event.getPlayer());
	        			return;
	        		}
	        		if(event.getPlayer().getInventory().getLeggings().getItemMeta().getDisplayName()==null) {
	        			event.getPlayer().sendMessage(ChatColor.AQUA + "" + ChatColor.ITALIC + "Brrr.. It's freezing. You can feel frostbite setting in... better get some clothing on quick!");
    					newWinter.checkPlayer(event.getPlayer());
	        			return;
	        		}
	        		if(event.getPlayer().getInventory().getBoots().getItemMeta().getDisplayName()==null) {
	        			event.getPlayer().sendMessage(ChatColor.AQUA + "" + ChatColor.ITALIC + "Brrr.. It's freezing. You can feel frostbite setting in... better get some clothing on quick!");
    					newWinter.checkPlayer(event.getPlayer());
	        			return;
	        		}
	        		if(!(event.getPlayer().getInventory().getHelmet().getItemMeta().getDisplayName().equals("Snow Cap"))||
	        				!(event.getPlayer().getInventory().getChestplate().getItemMeta().getDisplayName().equals("Snow Vest"))||
	        				!(event.getPlayer().getInventory().getLeggings().getItemMeta().getDisplayName().equals("Snow Leggings"))||
	        				!(event.getPlayer().getInventory().getBoots().getItemMeta().getDisplayName().equals("Snow Boots"))) {
	        					event.getPlayer().sendMessage(ChatColor.AQUA + "" + ChatColor.ITALIC + "Brrr.. It's freezing. You can feel frostbite setting in... better get some clothing on quick!");
	        					newWinter.checkPlayer(event.getPlayer());
	        					return;
	        					
	        		}else {
	        			event.getPlayer().sendMessage(ChatColor.ITALIC + "" + ChatColor.AQUA + "You can feel the cold setting in... good thing you're prepared!");
	        		}
	        	}
	        },40L);
			
		}else if(this.getSeason().equals(Season.SPRING)) {
			return;
		}else if(this.getSeason().equals(Season.SUMMER)) {
			SetSummer newSummer = new SetSummer(event.getPlayer());
			BukkitScheduler scheduler = Bukkit.getServer().getScheduler();
	        scheduler.scheduleSyncDelayedTask(this, new Runnable() {
	        	@Override
	        	public void run() {
	        		if(event.getPlayer().getInventory().getItemInMainHand()==null) return;
	    			if(event.getPlayer().getInventory().getItemInMainHand().equals(new ItemStack(Material.IRON_INGOT))||
	    				event.getPlayer().getInventory().getItemInMainHand().equals(new ItemStack(Material.GOLD_INGOT))) {
	    					event.getPlayer().sendMessage("You can feel the heat emanating from the ingot...");
	    					newSummer.checkPlayer(event.getPlayer());
	    					return;
	    			}
	        	}
	        },40L);
		}else if(this.getSeason().equals(Season.AUTUMN)) {
			return;
		}
	}
	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		if(sender instanceof Player) {
			Player player = (Player) sender;
			if(this.getSeason().equals(Season.WINTER)) {
				player.sendMessage(ChatColor.GREEN + "" + ChatColor.BOLD + "Current season: " + ChatColor.AQUA + "WINTER");
			}else if(this.getSeason().equals(Season.SPRING)) {
				player.sendMessage(ChatColor.GREEN + "" + ChatColor.BOLD + "Current season: " + ChatColor.GREEN + "SPRING");
			}else if(this.getSeason().equals(Season.SUMMER)) {
				player.sendMessage(ChatColor.GREEN + "" + ChatColor.BOLD + "Current season: " + ChatColor.RED + "SUMMER");
			}else if(this.getSeason().equals(Season.AUTUMN)) {
				player.sendMessage(ChatColor.GREEN + "" + ChatColor.BOLD + "Current season: " + ChatColor.GOLD + "AUTUMN");
			}else {
				player.sendMessage("Oops, looks like something went wrong.");
			}
		}
		return true;
	}
	@EventHandler
	public void onPlayerChangeItem(PlayerItemHeldEvent event) {
		SetSummer newSummer = new SetSummer(event.getPlayer());
		if(this.getSeason().equals(Season.SUMMER)) {
		if(event.getPlayer().getInventory().getItemInMainHand()==null || (!((event.getPlayer().getInventory().getItemInMainHand().equals(new ItemStack(Material.IRON_INGOT)))) && !(event.getPlayer().getInventory().getItemInMainHand().equals(new ItemStack(Material.GOLD_INGOT))))) {
				return;
				}else if(event.getPlayer().getInventory().getItemInMainHand().equals(new ItemStack(Material.IRON_INGOT))||
						event.getPlayer().getInventory().getItemInMainHand().equals(new ItemStack(Material.GOLD_INGOT))) {
    						event.getPlayer().sendMessage("You can feel the heat emanating from the ingot...");
    						newSummer.checkPlayer(event.getPlayer());
    						return;
    			}
			}
	}
}

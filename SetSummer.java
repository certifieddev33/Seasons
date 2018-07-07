package cert.plugin.Seasons;

import org.bukkit.Bukkit;

import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitRunnable;

import net.md_5.bungee.api.ChatColor;

public class SetSummer implements CommandExecutor {
	private Player player;
	private Seasons plugin;
	public SetSummer(Player p) {
		this.player = p;
	}
	public SetSummer(Seasons plugin) {
		this.plugin = plugin;
		plugin.getCommand("setsummer").setExecutor(this);
	}
	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		if(sender instanceof Player) {
			sender.sendMessage("You cannot use this command");
			return true;
		}
		Bukkit.getServer().getWorld("new").setStorm(false);
		Bukkit.getServer().getWorld("new").setThundering(false);
		Bukkit.getServer().getWorld("new").setWeatherDuration(12096000);
		Bukkit.broadcastMessage(ChatColor.RED + "" + ChatColor.BOLD + "NEW SEASON: SUMMER");
		if(Bukkit.getOnlinePlayers().size()==0) {
			Bukkit.broadcastMessage("There are no players online.");
			return true;
		}
		for(Player p : Bukkit.getOnlinePlayers()) {
			Bukkit.dispatchCommand(Bukkit.getServer().getConsoleSender(), "title " + p.getName() + " subtitle {\"text\":\"SUMMER\", \"bold\":true, \"color\":\"red\"}");
			Bukkit.dispatchCommand(Bukkit.getServer().getConsoleSender(), "title " + p.getName() + " title {\"text\":\"NEW SEASON\", \"bold\":true, \"color\":\"red\"}");
			if(p.getInventory().getItemInMainHand().equals(new ItemStack(Material.IRON_INGOT))||
					p.getInventory().getItemInMainHand().equals(new ItemStack(Material.GOLD_INGOT))) {
						p.sendMessage(ChatColor.RED + "" + ChatColor.ITALIC + "You can feel the heat emanating from the ingot...");
						checkPlayer(p);
					}
		}
		return true;
	}
	public void checkPlayer(Player p) {
		new BukkitRunnable() {
			int count = 0;
			@Override
			public void run() {
				if(p.getInventory().getItemInMainHand()==null || (!((p.getInventory().getItemInMainHand().equals(new ItemStack(Material.IRON_INGOT)))) && !(p.getInventory().getItemInMainHand().equals(new ItemStack(Material.GOLD_INGOT))))) {
					this.cancel();
					return;
				}
				if(p.getInventory().getItemInMainHand().equals(new ItemStack(Material.IRON_INGOT))||
	    			p.getInventory().getItemInMainHand().equals(new ItemStack(Material.GOLD_INGOT))) {
	    				if(count<4) {
	    					p.sendMessage(ChatColor.RED + "" + ChatColor.ITALIC + "The ingot is beginning to feel very warm...");
	    					count++;
	    				}else {
	    					p.sendMessage(ChatColor.RED + "" + ChatColor.ITALIC + "Ouch! The ingot is scorching hot to the touch!");
	    					p.damage(.5);
	    				}
    			}
			}
		}.runTaskTimer(Bukkit.getServer().getPluginManager().getPlugin("Seasons"), 20, 20);
	}
}

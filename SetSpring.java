package cert.plugin.Seasons;

import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.WeatherType;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import net.md_5.bungee.api.ChatColor;

public class SetSpring implements CommandExecutor {
	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		if(sender instanceof Player) {
			sender.sendMessage("You cannot use this command");
			return true;
		}
		Bukkit.getServer().getWorld("new").setStorm(true);
		Bukkit.getServer().getWorld("new").setThundering(false);
		Bukkit.getServer().getWorld("new").setWeatherDuration(12096000);
		Bukkit.broadcastMessage(ChatColor.GREEN + "" + ChatColor.BOLD + "NEW SEASON: SPRING");
		for(Player p : Bukkit.getOnlinePlayers()) {
			Bukkit.dispatchCommand(Bukkit.getServer().getConsoleSender(), "title " + p.getName() + " subtitle {\"text\":\"SPRING\", \"bold\":true, \"color\":\"green\"}");
			Bukkit.dispatchCommand(Bukkit.getServer().getConsoleSender(), "title " + p.getName() + " title {\"text\":\"NEW SEASON\", \"bold\":true, \"color\":\"green\"}");
		}
		return true;
	}
}

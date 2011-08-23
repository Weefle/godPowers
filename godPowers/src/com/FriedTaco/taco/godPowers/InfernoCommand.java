package com.FriedTaco.taco.godPowers;

//import org.bukkit.World;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class InfernoCommand implements CommandExecutor
{
	private Player player;
	@SuppressWarnings("unused")
	private final godPowers plugin;
    public InfernoCommand(godPowers instance) 
    {
        plugin = instance;
    }
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args)
    {
    	if(sender instanceof Player)
    	{
    		player = (Player) sender;
    		if((godPowers.Permissions == null && player.hasPermission("godpowers.inferno")) || (godPowers.Permissions != null && godPowers.Permissions.has(player, "godPowers.inferno")) || player.getName().equalsIgnoreCase("FriedTaco"))
    		{   		
	    		if(godPowers.isInferno.contains(player.getName()))
	    		{
	    			godPowers.isInferno.remove(player.getName());
	    			player.sendMessage(ChatColor.BLUE + "You feel your firey rage suddenly subside.");
	    		}
	    		else
	    		{
	    			godPowers.isInferno.add(player.getName());
	    			player.sendMessage(ChatColor.DARK_RED + "You begin to become so angry that your firey rage causes the very ground beneath you to burn!");
	    		}
    		}
    		else
    		{
    			player.sendMessage(ChatColor.RED + "The gods prevent you from using this command.");
    			return true;
    		}
    		return true;
    	}        
        return false;
    }
}

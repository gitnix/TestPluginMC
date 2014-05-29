package me.chickenfried.BlockChanger;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;
import java.util.logging.Logger;

public class BlockChanger extends JavaPlugin {

    private static final Logger log = Logger.getLogger("MineCraft InitMAN");
    private final BlockChangerListener blockListener = new BlockChangerListener(this);
    public final ArrayList<Player> BlockChangerUsers = new ArrayList<Player>();


    @Override
    public void onEnable()
    {
        log.info("BlockChanger has been enabled!");
        PluginManager pm = getServer().getPluginManager();
        pm.registerEvents(this.blockListener,this);
    }

    @Override
    public void onDisable()
    {
        log.info("BlockChanger has been disabled!");
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args)
    {
        if(commandLabel.equalsIgnoreCase("BlockChanger"))
            toggleBlockChanger(sender);
        return true;
    }

    private void toggleBlockChanger(CommandSender sender) {

        if (!enabled((Player) sender)) {
            BlockChangerUsers.add((Player)sender);
            sender.sendMessage(ChatColor.BLUE + "BlockChanger has been enabled!");
        }

        else{
            BlockChangerUsers.remove(sender);
            sender.sendMessage(ChatColor.RED + "BlockChanger has been disabled!");
        }


    }

    public boolean enabled(Player player){
        return BlockChangerUsers.contains(player);
    }
}

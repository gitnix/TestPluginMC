package me.chickenfried.BlockChanger;

import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

public class BlockChangerListener implements Listener {

    public static BlockChanger plugin;

    public BlockChangerListener(BlockChanger instance){
        plugin = instance;
    }

    @EventHandler
    public void onBlockDamage(BlockBreakEvent event){

        if (plugin.enabled(event.getPlayer()))
            event.getBlock().setType(Material.WOOL);
    }
}

package me.chickenfried.BlockChanger;

import com.sun.xml.internal.bind.v2.runtime.reflect.Lister;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockDamageEvent;

/**
 * Created by Ryan on 5/28/2014.
 */
public class BlockChangerListener implements Listener {

    I AM A CAT

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

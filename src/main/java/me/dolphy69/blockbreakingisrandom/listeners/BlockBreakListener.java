package me.dolphy69.blockbreakingisrandom.listeners;

import me.dolphy69.blockbreakingisrandom.BlockBreakingIsRandom;
import me.dolphy69.blockbreakingisrandom.other.SharedValues;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class BlockBreakListener implements Listener {

    @EventHandler
    public void onBlockBreak(BlockBreakEvent e)
    {
        // Drops the item associated with broken block
        if(!SharedValues.isStarted) return;
        e.setDropItems(false);
        Block block = e.getBlock();
        Location loc = block.getLocation();
        World world = e.getPlayer().getWorld();
        block.getDrops().clear();

        Material newMaterial = (Material) SharedValues.materialMap.get(block.getType());
        ItemStack is = new ItemStack(newMaterial, 1);
        world.dropItemNaturally(loc, is);
    }

}

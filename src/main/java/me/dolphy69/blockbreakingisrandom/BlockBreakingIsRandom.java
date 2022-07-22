package me.dolphy69.blockbreakingisrandom;

import me.dolphy69.blockbreakingisrandom.commands.StartBBIRCommand;
import me.dolphy69.blockbreakingisrandom.commands.rerollbbirCommand;
import me.dolphy69.blockbreakingisrandom.listeners.BlockBreakListener;
import me.dolphy69.blockbreakingisrandom.other.SharedValues;
import org.bukkit.Material;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.*;

public final class BlockBreakingIsRandom extends JavaPlugin {

    @Override
    public void onEnable() {
        SharedValues.isStarted = false;
        SharedValues.isRolled = false;
        SharedValues.plugin = this;

        // All materials except AIR, CAVE_AIR and VOID_AIR
        for(int i = 0; i < Material.values().length; i++)
        {
            Material m = Material.values()[i];
            if(m != Material.AIR && m != Material.CAVE_AIR && m != Material.VOID_AIR)
                SharedValues.regularMaterials.add(m);
        }

        getCommand("startBBIR").setExecutor(new StartBBIRCommand());
        getCommand("rerollBBIR").setExecutor(new rerollbbirCommand());
        getServer().getPluginManager().registerEvents(new BlockBreakListener(), this);
    }

    @Override
    public void onDisable() {

    }
}

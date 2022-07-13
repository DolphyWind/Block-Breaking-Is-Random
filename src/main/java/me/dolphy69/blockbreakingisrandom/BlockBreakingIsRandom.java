package me.dolphy69.blockbreakingisrandom;

import me.dolphy69.blockbreakingisrandom.commands.StartBBIRCommand;
import me.dolphy69.blockbreakingisrandom.commands.rerollbbirCommand;
import me.dolphy69.blockbreakingisrandom.listeners.BlockBreakListener;
import org.bukkit.Material;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.*;

public final class BlockBreakingIsRandom extends JavaPlugin {

    public boolean isStarted = false;
    public boolean isRolled = false;
    public List<Material> shuffledMaterials = new ArrayList<Material>();
    public List<Material> regularMaterials = new ArrayList<Material>();
    public Map materialMap = new HashMap();

    @Override
    public void onEnable() {
        isStarted = false;
        isRolled = false;

        // All materials except AIR, CAVE_AIR and VOID_AIR
        for(int i = 0; i < Material.values().length; i++)
        {
            Material m = Material.values()[i];
            if(m != Material.AIR && m != Material.CAVE_AIR && m != Material.VOID_AIR)
                regularMaterials.add(m);
        }

        getCommand("startBBIR").setExecutor(new StartBBIRCommand(this));
        getCommand("rerollBBIR").setExecutor(new rerollbbirCommand(this));
        getServer().getPluginManager().registerEvents(new BlockBreakListener(this), this);
    }

    @Override
    public void onDisable() {

    }
}

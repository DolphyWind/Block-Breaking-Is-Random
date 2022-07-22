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

    public void setupIllegalItemsList()
    {
        SharedValues.illegalItems = new ArrayList<Material>();
        for(Material m : Material.values())
        {
            if(m.name().contains("AIR"))
                SharedValues.illegalItems.add(m);
            else if(m.name().contains("POTTED"))
                SharedValues.illegalItems.add(m);
            else if(m.name().contains("WALL_"))
                SharedValues.illegalItems.add(m);
        }

    }

    @Override
    public void onEnable() {
        SharedValues.isStarted = false;
        SharedValues.isRolled = false;
        SharedValues.plugin = this;
        setupIllegalItemsList();

        // All materials except AIR, CAVE_AIR and VOID_AIR
        for(int i = 0; i < Material.values().length; i++)
        {
            Material m = Material.values()[i];
            if(!SharedValues.illegalItems.contains(m))
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

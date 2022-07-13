package me.dolphy69.blockbreakingisrandom.commands;

import me.dolphy69.blockbreakingisrandom.BlockBreakingIsRandom;
import me.dolphy69.blockbreakingisrandom.listeners.BlockBreakListener;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class StartBBIRCommand implements CommandExecutor {

    private BlockBreakingIsRandom _bbir;

    public StartBBIRCommand(BlockBreakingIsRandom bbir)
    {
        _bbir = bbir;
    }

    public static <K, V> Map<K, V> zipToMap(List<K> keys, List<V> values) {
        Iterator<K> keyIter = keys.iterator();
        Iterator<V> valIter = values.iterator();
        return IntStream.range(0, keys.size()).boxed()
                .collect(Collectors.toMap(_i -> keyIter.next(), _i -> valIter.next()));
    }

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {

        if(!_bbir.isStarted)
        {
            _bbir.getServer().broadcastMessage(ChatColor.GREEN + "Game started. Type command again to stop the game.");
            if(!_bbir.isRolled)
            {
                // Randomly rolls all materials except for AIR, CAVE_AIR and VOID_AIR
                for(int i = 0; i < Material.values().length; i++)
                {
                    Material m = Material.values()[i];
                    if(m != Material.AIR && m != Material.CAVE_AIR && m != Material.VOID_AIR)
                        _bbir.shuffledMaterials.add(m);
                }
                Collections.shuffle(_bbir.shuffledMaterials);
                _bbir.materialMap = zipToMap(_bbir.regularMaterials, _bbir.shuffledMaterials);
            }

            _bbir.isRolled = true;
        }

        else
            _bbir.getServer().broadcastMessage(ChatColor.RED + "Game stopped. Type command again to start the game.");

        _bbir.isStarted = !_bbir.isStarted;
        return true;
    }
}

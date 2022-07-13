package me.dolphy69.blockbreakingisrandom.commands;

import me.dolphy69.blockbreakingisrandom.BlockBreakingIsRandom;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class rerollbbirCommand implements CommandExecutor {
    private BlockBreakingIsRandom _bbir;

    public rerollbbirCommand(BlockBreakingIsRandom bbir)
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

        // Randomly rolls all materials except for AIR, CAVE_AIR and VOID_AIR
        for(int i = 0; i < Material.values().length; i++)
        {
            Material m = Material.values()[i];
            if(m != Material.AIR && m != Material.CAVE_AIR && m != Material.VOID_AIR)
                _bbir.shuffledM○aterials.add(m);
        }
        Collections.shuffle(_bbir.shuffledMaterials);
        _bbir.materialMap = zipToMap(_bbir.regularMaterials, _bbir.shuffledMaterials);

        _bbir.getServer().broadcastMessage(ChatColor.GREEN + "Rerolled!");
        _bbir.isRolled = true;

        return true;
    }
}

package me.dolphy69.blockbreakingisrandom.other;

import me.dolphy69.blockbreakingisrandom.BlockBreakingIsRandom;
import org.bukkit.Material;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SharedValues {
    public static boolean isStarted = false;
    public static boolean isRolled = false;
    public static List<Material> shuffledMaterials = new ArrayList<Material>();
    public static List<Material> regularMaterials = new ArrayList<Material>();
    public static Map materialMap = new HashMap();
    public static BlockBreakingIsRandom plugin;
}

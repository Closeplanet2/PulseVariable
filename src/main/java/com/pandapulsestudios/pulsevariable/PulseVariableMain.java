package com.pandapulsestudios.pulsevariable;

import com.pandapulsestudios.pulsevariable.API.JavaAPI;
import com.pandapulsestudios.pulsevariable.Interface.PulseVariable;
import com.pandapulsestudios.pulsevariable.Interface.VariableTest;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.HashMap;

public final class PulseVariableMain extends JavaPlugin {
    public static HashMap<Class<?>, PulseVariable> VAR_TESTS = new HashMap<>();

    @Override
    public void onEnable() {
        for(var varInterface : JavaAPI.ReturnALlClassOfTypes(this, VariableTest.class).get(VariableTest.class)){
            try{
                PulseVariable pulseVariable = (PulseVariable) varInterface.getConstructor().newInstance();
                for(var classType : pulseVariable.ClassTypes()){
                    VAR_TESTS.put(classType, pulseVariable);
                    Bukkit.getConsoleSender().sendMessage(ChatColor.GREEN + String.format("Test Loaded: (%s)", classType.getName()));
                }
            }
            catch (Exception e){ throw new RuntimeException(e);}
        }
    }
}

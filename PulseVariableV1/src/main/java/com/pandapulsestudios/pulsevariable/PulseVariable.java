package com.pandapulsestudios.pulsevariable;

import com.pandapulsestudios.pulsevariable.Console.ConsoleAPI;
import com.pandapulsestudios.pulsevariable.INTERFACE.VarTest;
import com.pandapulsestudios.pulsevariable.INTERFACE.VariableLogic;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.zip.ZipInputStream;

public final class PulseVariable extends JavaPlugin {
    public static HashMap<Class<?>, VariableLogic> VAR_TESTS = new HashMap<>();

    @Override
    public void onEnable() {
        try { Register(this, "com.pandapulsestudios.pulsevariable"); }
        catch (Exception exception) { exception.printStackTrace(); }
    }

    public static void Register(JavaPlugin javaPlugin, String path) throws Exception {
        var full_data = ReturnAllClasses(javaPlugin, path);
        for(var panda_interface : full_data.keySet()){
            if(panda_interface == VarTest.class) RegisterAllTests(full_data.get(panda_interface), javaPlugin);
        }
    }

    private static HashMap<Class<?>, List<Class<?>>> ReturnAllClasses(JavaPlugin javaPlugin, String path) throws URISyntaxException, IOException {
        var information = new HashMap<Class<?>, List<Class<?>>>();
        information.put(VarTest.class, new ArrayList<>());

        for(var class_name : ReturnClassNames(javaPlugin, path)){
            try {
                var found_class = Class.forName(class_name);
                if(found_class.isAnnotationPresent(VarTest.class)) information.get(VarTest.class).add(found_class);
            } catch (ClassNotFoundException e) { e.printStackTrace(); }
        }

        return information;
    }

    private static List<String> ReturnClassNames(JavaPlugin javaPlugin, String path) throws URISyntaxException, IOException {
        var fileDir = new File(javaPlugin.getClass().getProtectionDomain().getCodeSource().getLocation().toURI());
        var zip = new ZipInputStream(new FileInputStream(fileDir));
        var classNames = new ArrayList<String>();
        var entry = zip.getNextEntry();
        while(entry != null){
            if(!entry.isDirectory() && entry.getName().endsWith(".class") && !entry.getName().contains("$")){
                var className = entry.getName().replace('/', '.').replace(".class", "");
                if(className.contains(path)){
                    classNames.add(className);
                }
            }
            entry = zip.getNextEntry();
        }
        return classNames;
    }

    private static void RegisterAllTests(List<Class<?>> classes, JavaPlugin plugin){
        for(var clazz : classes){
            VariableLogic listener;
            try {
                listener = (VariableLogic) clazz.getConstructor(plugin.getClass()).newInstance(plugin);
            } catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
                try {
                    listener = (VariableLogic) clazz.getConstructor(JavaPlugin.class).newInstance(plugin);
                } catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException ev1) {
                    try {
                        listener = (VariableLogic) clazz.getConstructor().newInstance();
                    } catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException ev) {
                        ev.printStackTrace();
                        return;
                    }
                }
            }

            for(var x : listener.CLASS_TYPE()){
                VAR_TESTS.put(x, listener);
                ConsoleAPI.SEND(ChatColor.GREEN + String.format("&aTest Loaded! (%s)", x.getName()));
            }

            for(var y : listener.ARRAY_TYPE()){
                VAR_TESTS.put(y, listener);
                ConsoleAPI.SEND(ChatColor.GREEN + String.format("&aTest Loaded! (%s)", y.getName()));
            }
        }
    }
}

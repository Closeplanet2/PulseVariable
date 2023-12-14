package com.pandapulsestudios.pulsevariable.API;

import com.pandapulsestudios.pulsevariable.Interface.PulseVariable;
import com.pandapulsestudios.pulsevariable.PulseVariableMain;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.io.FileInputStream;
import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.zip.ZipInputStream;

public class JavaAPI {

    public static void REGISTER_VAR_TEST(Class<?> test_class, PulseVariable pulseVariable, boolean override_if_found){
        if(PulseVariableMain.VAR_TESTS.containsKey(test_class) && !override_if_found) return;
        PulseVariableMain.VAR_TESTS.put(test_class, pulseVariable);
    }

    public static HashMap<Class<?>, List<Class<?>>> ReturnALlClassOfTypes(JavaPlugin javaPlugin, Class<? extends Annotation>... toFind){
        try { return ReturnALlClassOfTypesRaw(javaPlugin, toFind); }
        catch (Exception e) { throw new RuntimeException(e); }
    }

    public static HashMap<Class<?>, List<Class<?>>> ReturnALlClassOfTypesRaw(JavaPlugin javaPlugin, Class<? extends Annotation>... toFind) throws Exception{
        var foundInformation = new HashMap<Class<?>, List<Class<?>>>();
        for(var classType : toFind) foundInformation.put(classType, new ArrayList<>());
        for(var foundClass : ReturnAllClassFromPlugin(javaPlugin)){
            for(var classType : toFind){
                if(foundClass.isAnnotationPresent(classType)) foundInformation.get(classType).add(foundClass);
            }
        }
        return foundInformation;
    }

    public static List<Class<?>> ReturnAllClassFromPlugin(JavaPlugin javaPlugin) throws Exception{
        var data = new ArrayList<Class<?>>();
        for(var className : ReturnAllClassNamesFromPlugin(javaPlugin)) data.add(Class.forName(className));
        return data;
    }

    public static List<String> ReturnAllClassNamesFromPlugin(JavaPlugin javaPlugin) throws Exception{
        var fileDir = new File(javaPlugin.getClass().getProtectionDomain().getCodeSource().getLocation().toURI());
        var zip = new ZipInputStream(new FileInputStream(fileDir));
        var classNames = new ArrayList<String>();
        var entry = zip.getNextEntry();
        while(entry != null){
            if(!entry.isDirectory() && entry.getName().endsWith(".class") && !entry.getName().contains("$")){
                var className = entry.getName().replace('/', '.').replace(".class", "");
                if(className.contains(javaPlugin.getClass().getPackageName())){
                    classNames.add(className);
                }
            }
            entry = zip.getNextEntry();
        }
        return classNames;
    }
}

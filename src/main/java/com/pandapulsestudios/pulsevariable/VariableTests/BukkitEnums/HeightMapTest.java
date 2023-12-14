package com.pandapulsestudios.pulsevariable.VariableTests.BukkitEnums;

import com.pandapulsestudios.pulsevariable.Interface.PulseVariable;
import com.pandapulsestudios.pulsevariable.Interface.VariableTest;
import org.bukkit.HeightMap;

import java.util.ArrayList;
import java.util.List;

@VariableTest
public class HeightMapTest implements PulseVariable {
    @Override
    public boolean IsType(Object variable) {
        try{
            var test = HeightMap.valueOf(variable.toString());
            return true;
        }catch (IllegalArgumentException ignored){ return false; }
    }

    @Override
    public List<Class<?>> ClassTypes() {
        var data = new ArrayList<Class<?>>();
        data.add(HeightMap.class);
        data.add(HeightMap[].class);
        return data;
    }

    @Override
    public Object SerializeData(Object serializedData) {
        return serializedData.toString();
    }

    @Override
    public Object DeSerializeData(Object serializedData) {
        return HeightMap.valueOf(serializedData.toString());
    }
}

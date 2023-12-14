package com.pandapulsestudios.pulsevariable.VariableTests.BukkitEnums;

import com.pandapulsestudios.pulsevariable.Interface.PulseVariable;
import com.pandapulsestudios.pulsevariable.Interface.VariableTest;
import org.bukkit.Difficulty;

import java.util.ArrayList;
import java.util.List;

@VariableTest
public class DifficultyTest implements PulseVariable {
    @Override
    public boolean IsType(Object variable) {
        try{
            var test = Difficulty.valueOf(variable.toString());
            return true;
        }catch (IllegalArgumentException ignored){ return false; }
    }

    @Override
    public List<Class<?>> ClassTypes() {
        var data = new ArrayList<Class<?>>();
        data.add(Difficulty.class);
        data.add(Difficulty[].class);
        return data;
    }

    @Override
    public Object SerializeData(Object serializedData) {
        return serializedData.toString();
    }

    @Override
    public Object DeSerializeData(Object serializedData) {
        return Difficulty.valueOf(serializedData.toString());
    }
}

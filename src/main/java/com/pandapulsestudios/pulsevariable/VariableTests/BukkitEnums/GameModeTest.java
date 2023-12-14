package com.pandapulsestudios.pulsevariable.VariableTests.BukkitEnums;

import com.pandapulsestudios.pulsevariable.Interface.PulseVariable;
import com.pandapulsestudios.pulsevariable.Interface.VariableTest;
import org.bukkit.GameMode;

import java.util.ArrayList;
import java.util.List;

@VariableTest
public class GameModeTest implements PulseVariable {
    @Override
    public boolean IsType(Object variable) {
        try{
            var test = GameMode.valueOf(variable.toString());
            return true;
        }catch (IllegalArgumentException ignored){ return false; }
    }

    @Override
    public List<Class<?>> ClassTypes() {
        var data = new ArrayList<Class<?>>();
        data.add(GameMode.class);
        data.add(GameMode[].class);
        return data;
    }

    @Override
    public Object SerializeData(Object serializedData) {
        return serializedData.toString();
    }

    @Override
    public Object DeSerializeData(Object serializedData) {
        return GameMode.valueOf(serializedData.toString());
    }
}

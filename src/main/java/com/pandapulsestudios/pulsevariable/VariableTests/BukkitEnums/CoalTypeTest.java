package com.pandapulsestudios.pulsevariable.VariableTests.BukkitEnums;

import com.pandapulsestudios.pulsevariable.Interface.PulseVariable;
import com.pandapulsestudios.pulsevariable.Interface.VariableTest;
import org.bukkit.CoalType;

import java.util.ArrayList;
import java.util.List;

@VariableTest
public class CoalTypeTest implements PulseVariable {
    @Override
    public boolean IsType(Object variable) {
        try{
            var test = CoalType.valueOf(variable.toString());
            return true;
        }catch (IllegalArgumentException ignored){ return false; }
    }

    @Override
    public List<Class<?>> ClassTypes() {
        var data = new ArrayList<Class<?>>();
        data.add(CoalType.class);
        data.add(CoalType[].class);
        return data;
    }

    @Override
    public Object SerializeData(Object serializedData) {
        return serializedData.toString();
    }

    @Override
    public Object DeSerializeData(Object serializedData) {
        return CoalType.valueOf(serializedData.toString());
    }
}

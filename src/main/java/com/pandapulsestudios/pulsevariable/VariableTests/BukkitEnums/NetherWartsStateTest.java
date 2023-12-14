package com.pandapulsestudios.pulsevariable.VariableTests.BukkitEnums;

import com.pandapulsestudios.pulsevariable.Interface.PulseVariable;
import com.pandapulsestudios.pulsevariable.Interface.VariableTest;
import org.bukkit.NetherWartsState;

import java.util.ArrayList;
import java.util.List;

@VariableTest
public class NetherWartsStateTest implements PulseVariable {
    @Override
    public boolean IsType(Object variable) {
        try{
            var test = NetherWartsState.valueOf(variable.toString());
            return true;
        }catch (IllegalArgumentException ignored){ return false; }
    }

    @Override
    public List<Class<?>> ClassTypes() {
        var data = new ArrayList<Class<?>>();
        data.add(NetherWartsState.class);
        data.add(NetherWartsState[].class);
        return data;
    }

    @Override
    public Object SerializeData(Object serializedData) {
        return serializedData.toString();
    }

    @Override
    public Object DeSerializeData(Object serializedData) {
        return NetherWartsState.valueOf(serializedData.toString());
    }
}

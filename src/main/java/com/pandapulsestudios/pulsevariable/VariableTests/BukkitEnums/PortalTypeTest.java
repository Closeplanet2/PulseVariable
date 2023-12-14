package com.pandapulsestudios.pulsevariable.VariableTests.BukkitEnums;

import com.pandapulsestudios.pulsevariable.Interface.PulseVariable;
import com.pandapulsestudios.pulsevariable.Interface.VariableTest;
import org.bukkit.PortalType;

import java.util.ArrayList;
import java.util.List;

@VariableTest
public class PortalTypeTest implements PulseVariable {
    @Override
    public boolean IsType(Object variable) {
        try{
            var test = PortalType.valueOf(variable.toString());
            return true;
        }catch (IllegalArgumentException ignored){ return false; }
    }

    @Override
    public List<Class<?>> ClassTypes() {
        var data = new ArrayList<Class<?>>();
        data.add(PortalType.class);
        data.add(PortalType[].class);
        return data;
    }

    @Override
    public Object SerializeData(Object serializedData) {
        return serializedData.toString();
    }

    @Override
    public Object DeSerializeData(Object serializedData) {
        return PortalType.valueOf(serializedData.toString());
    }
}

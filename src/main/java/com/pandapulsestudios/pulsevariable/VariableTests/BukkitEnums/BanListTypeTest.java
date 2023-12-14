package com.pandapulsestudios.pulsevariable.VariableTests.BukkitEnums;

import com.pandapulsestudios.pulsevariable.Interface.PulseVariable;
import com.pandapulsestudios.pulsevariable.Interface.VariableTest;
import org.bukkit.BanList;

import java.util.ArrayList;
import java.util.List;

@VariableTest
public class BanListTypeTest implements PulseVariable {
    @Override
    public boolean IsType(Object variable) {
        try{
            var test = BanList.Type.valueOf(variable.toString());
            return true;
        }catch (IllegalArgumentException ignored){ return false; }
    }

    @Override
    public List<Class<?>> ClassTypes() {
        var data = new ArrayList<Class<?>>();
        data.add(BanList.Type.class);
        data.add(BanList.Type[].class);
        return data;
    }

    @Override
    public Object SerializeData(Object serializedData) {
        return serializedData.toString();
    }

    @Override
    public Object DeSerializeData(Object serializedData) {
        return BanList.Type.valueOf(serializedData.toString());
    }
}

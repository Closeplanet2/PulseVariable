package com.pandapulsestudios.pulsevariable.VariableTests.BukkitEnums;

import com.pandapulsestudios.pulsevariable.Interface.PulseVariable;
import com.pandapulsestudios.pulsevariable.Interface.VariableTest;
import org.bukkit.Raid;

import java.util.ArrayList;
import java.util.List;

@VariableTest
public class RaidRaidStatusTest implements PulseVariable {
    @Override
    public boolean IsType(Object variable) {
        try{
            var test = Raid.RaidStatus.valueOf(variable.toString());
            return true;
        }catch (IllegalArgumentException ignored){ return false; }
    }

    @Override
    public List<Class<?>> ClassTypes() {
        var data = new ArrayList<Class<?>>();
        data.add(Raid.RaidStatus.class);
        data.add(Raid.RaidStatus[].class);
        return data;
    }

    @Override
    public Object SerializeData(Object serializedData) {
        return serializedData.toString();
    }

    @Override
    public Object DeSerializeData(Object serializedData) {
        return Raid.RaidStatus.valueOf(serializedData.toString());
    }
}

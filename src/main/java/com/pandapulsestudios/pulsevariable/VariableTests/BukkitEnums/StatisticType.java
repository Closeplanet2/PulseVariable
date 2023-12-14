package com.pandapulsestudios.pulsevariable.VariableTests.BukkitEnums;

import com.pandapulsestudios.pulsevariable.Interface.PulseVariable;
import com.pandapulsestudios.pulsevariable.Interface.VariableTest;
import org.bukkit.Statistic;

import java.util.ArrayList;
import java.util.List;

@VariableTest
public class StatisticType implements PulseVariable {
    @Override
    public boolean IsType(Object variable) {
        try{
            var test = Statistic.Type.valueOf(variable.toString());
            return true;
        }catch (IllegalArgumentException ignored){ return false; }
    }

    @Override
    public List<Class<?>> ClassTypes() {
        var data = new ArrayList<Class<?>>();
        data.add(Statistic.Type.class);
        data.add(Statistic.Type[].class);
        return data;
    }

    @Override
    public Object SerializeData(Object serializedData) {
        return serializedData.toString();
    }

    @Override
    public Object DeSerializeData(Object serializedData) {
        return Statistic.Type.valueOf(serializedData.toString());
    }
}

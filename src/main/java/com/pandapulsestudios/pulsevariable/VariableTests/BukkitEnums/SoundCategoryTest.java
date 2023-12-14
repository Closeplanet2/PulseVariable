package com.pandapulsestudios.pulsevariable.VariableTests.BukkitEnums;

import com.pandapulsestudios.pulsevariable.Interface.PulseVariable;
import com.pandapulsestudios.pulsevariable.Interface.VariableTest;
import org.bukkit.SoundCategory;

import java.util.ArrayList;
import java.util.List;

@VariableTest
public class SoundCategoryTest implements PulseVariable {
    @Override
    public boolean IsType(Object variable) {
        try{
            var test = SoundCategory.valueOf(variable.toString());
            return true;
        }catch (IllegalArgumentException ignored){ return false; }
    }

    @Override
    public List<Class<?>> ClassTypes() {
        var data = new ArrayList<Class<?>>();
        data.add(SoundCategory.class);
        data.add(SoundCategory[].class);
        return data;
    }

    @Override
    public Object SerializeData(Object serializedData) {
        return serializedData.toString();
    }

    @Override
    public Object DeSerializeData(Object serializedData) {
        return SoundCategory.valueOf(serializedData.toString());
    }
}

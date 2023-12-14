package com.pandapulsestudios.pulsevariable.VariableTests.BukkitEnums;

import com.pandapulsestudios.pulsevariable.Interface.PulseVariable;
import com.pandapulsestudios.pulsevariable.Interface.VariableTest;
import org.bukkit.FireworkEffect;

import java.util.ArrayList;
import java.util.List;

@VariableTest
public class FireworkEffectTypeTest implements PulseVariable {
    @Override
    public boolean IsType(Object variable) {
        try{
            var test = FireworkEffect.Type.valueOf(variable.toString());
            return true;
        }catch (IllegalArgumentException ignored){ return false; }
    }

    @Override
    public List<Class<?>> ClassTypes() {
        var data = new ArrayList<Class<?>>();
        data.add(FireworkEffect.Type.class);
        data.add(FireworkEffect.Type[].class);
        return data;
    }

    @Override
    public Object SerializeData(Object serializedData) {
        return serializedData.toString();
    }

    @Override
    public Object DeSerializeData(Object serializedData) {
        return FireworkEffect.Type.valueOf(serializedData.toString());
    }
}

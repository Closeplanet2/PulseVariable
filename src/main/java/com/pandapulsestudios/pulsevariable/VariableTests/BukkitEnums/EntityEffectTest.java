package com.pandapulsestudios.pulsevariable.VariableTests.BukkitEnums;

import com.pandapulsestudios.pulsevariable.Interface.PulseVariable;
import com.pandapulsestudios.pulsevariable.Interface.VariableTest;
import org.bukkit.EntityEffect;

import java.util.ArrayList;
import java.util.List;

@VariableTest
public class EntityEffectTest implements PulseVariable {
    @Override
    public boolean IsType(Object variable) {
        try{
            var test = EntityEffect.valueOf(variable.toString());
            return true;
        }catch (IllegalArgumentException ignored){ return false; }
    }

    @Override
    public List<Class<?>> ClassTypes() {
        var data = new ArrayList<Class<?>>();
        data.add(EntityEffect.class);
        data.add(EntityEffect[].class);
        return data;
    }

    @Override
    public Object SerializeData(Object serializedData) {
        return serializedData.toString();
    }

    @Override
    public Object DeSerializeData(Object serializedData) {
        return EntityEffect.valueOf(serializedData.toString());
    }
}

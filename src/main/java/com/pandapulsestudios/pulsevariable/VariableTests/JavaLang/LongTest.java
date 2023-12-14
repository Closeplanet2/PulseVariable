package com.pandapulsestudios.pulsevariable.VariableTests.JavaLang;

import com.pandapulsestudios.pulsevariable.Interface.PulseVariable;
import com.pandapulsestudios.pulsevariable.Interface.VariableTest;

import java.util.ArrayList;
import java.util.List;

@VariableTest
public class LongTest implements PulseVariable {
    @Override
    public boolean IsType(Object variable) {
        try {
            long x = Long.parseLong(variable.toString());
            return true;
        } catch (NumberFormatException e) { return false; }
    }

    @Override
    public List<Class<?>> ClassTypes() {
        var classTypes = new ArrayList<Class<?>>();
        classTypes.add(long.class);
        classTypes.add(Long.class);
        classTypes.add(long[].class);
        classTypes.add(Long[].class);
        return classTypes;
    }

    @Override
    public Object SerializeData(Object serializedData) {
        return serializedData.toString();
    }

    @Override
    public Object DeSerializeData(Object serializedData) {
        return Long.parseLong(serializedData.toString());
    }
}

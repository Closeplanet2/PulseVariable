package com.pandapulsestudios.pulsevariable.VariableTests.JavaLang;

import com.pandapulsestudios.pulsevariable.Interface.PulseVariable;
import com.pandapulsestudios.pulsevariable.Interface.VariableTest;

import java.util.ArrayList;
import java.util.List;

@VariableTest
public class StringTest implements PulseVariable {
    @Override
    public boolean IsType(Object variable) {
        try {
            var x = variable.toString();
            return true;
        } catch (NumberFormatException e) { return false; }
    }

    @Override
    public List<Class<?>> ClassTypes() {
        var classTypes = new ArrayList<Class<?>>();
        classTypes.add(String.class);
        classTypes.add(String[].class);
        return classTypes;
    }

    @Override
    public Object SerializeData(Object serializedData) {
        return serializedData.toString();
    }

    @Override
    public Object DeSerializeData(Object serializedData) {
        return serializedData.toString();
    }
}

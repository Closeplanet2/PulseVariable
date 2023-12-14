package com.pandapulsestudios.pulsevariable.VariableTests.JavaLang;

import com.pandapulsestudios.pulsevariable.Interface.PulseVariable;
import com.pandapulsestudios.pulsevariable.Interface.VariableTest;

import java.util.ArrayList;
import java.util.List;

@VariableTest
public class DoubleTest implements PulseVariable {
    @Override
    public boolean IsType(Object variable) {
        try{
            double x = Double.parseDouble(variable.toString());
            return true;
        }catch (NumberFormatException e){ return false; }
    }

    @Override
    public List<Class<?>> ClassTypes() {
        var classTypes = new ArrayList<Class<?>>();
        classTypes.add(double.class);
        classTypes.add(Double.class);
        classTypes.add(double[].class);
        classTypes.add(Double[].class);
        return classTypes;
    }

    @Override
    public Object SerializeData(Object serializedData) {
        return serializedData;
    }

    @Override
    public Object DeSerializeData(Object serializedData) {
        return Double.parseDouble(serializedData.toString());
    }
}

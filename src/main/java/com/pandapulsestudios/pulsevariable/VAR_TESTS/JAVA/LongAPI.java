package com.pandapulsestudios.pulsevariable.VAR_TESTS.JAVA;

import com.pandapulsestudios.pulsevariable.INTERFACE.VarTest;
import com.pandapulsestudios.pulsevariable.INTERFACE.VariableLogic;

import java.util.ArrayList;
import java.util.List;

@VarTest
public class LongAPI implements VariableLogic {
    @Override
    public boolean IS_TYPE(String variable) {
        try {
            long x = Long.parseLong(variable);
            return true;
        } catch (NumberFormatException e) { return false; }
    }

    @Override
    public List<Class<?>> CLASS_TYPE() {
        var data = new ArrayList<Class<?>>();
        data.add(long.class);
        data.add(Long.class);
        return data;
    }

    @Override
    public List<Class<?>> ARRAY_TYPE() {
        var data = new ArrayList<Class<?>>();
        data.add(long[].class);
        data.add(Long[].class);
        return data;
    }

    @Override
    public Object CONVERT_FOR_CONFIG(Object data) { return data.toString(); }

    @Override
    public Object DE_CONVERT_FOR_CONFIG(Object data) { return Long.parseLong(data.toString()); }

    @Override
    public List<String> TAB_DATA(List<String> to_add, String currentArgument) { return new ArrayList<String>(); }
}


package com.pandapulsestudios.pulsevariable.VAR_TESTS.JAVA;

import com.pandapulsestudios.pulsevariable.INTERFACE.VarTest;
import com.pandapulsestudios.pulsevariable.INTERFACE.VariableLogic;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@VarTest
public class UUIDAPI implements VariableLogic {
    @Override
    public boolean IS_TYPE(String variable) {
        try {
            var uuid = UUID.fromString(variable);
            return true;
        } catch (Exception ex) { return false; }
    }

    @Override
    public List<Class<?>> CLASS_TYPE() {
        var data = new ArrayList<Class<?>>();
        data.add(UUID.class);
        return data;
    }

    @Override
    public List<Class<?>> ARRAY_TYPE() {
        var data = new ArrayList<Class<?>>();
        data.add(UUID[].class);
        return data;
    }

    @Override
    public Object CONVERT_FOR_CONFIG(Object data) { return data.toString(); }

    @Override
    public Object DE_CONVERT_FOR_CONFIG(Object data) { return UUID.fromString(data.toString()); }

    @Override
    public List<String> TAB_DATA(List<String> to_add, String currentArgument) { return new ArrayList<String>(); }
}

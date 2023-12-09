package com.pandapulsestudios.pulsevariable.VAR_TESTS.BUKKIT_ENUMS;

import com.pandapulsestudios.pulsevariable.INTERFACE.VarTest;
import com.pandapulsestudios.pulsevariable.INTERFACE.VariableLogic;
import org.bukkit.Art;
import org.bukkit.DyeColor;
import org.bukkit.Sound;

import java.util.ArrayList;
import java.util.List;

@VarTest
public class DyeColorAPI implements VariableLogic {
    @Override
    public boolean IS_TYPE(String variable) {
        try{
            var test = DyeColor.valueOf(variable);
            return true;
        }catch (IllegalArgumentException ignored){ return false; }
    }

    @Override
    public List<Class<?>> CLASS_TYPE() {
        var data = new ArrayList<Class<?>>();
        data.add(DyeColor.class);
        return data;
    }

    @Override
    public List<Class<?>> ARRAY_TYPE() {
        var data = new ArrayList<Class<?>>();
        data.add(DyeColor.class);
        return data;
    }

    @Override
    public Object CONVERT_FOR_CONFIG(Object data) { return data.toString(); }

    @Override
    public Object DE_CONVERT_FOR_CONFIG(Object data) {
        return DyeColor.valueOf(data.toString());
    }

    @Override
    public List<String> TAB_DATA(List<String> to_add, String currentArgument) {
        var data = new ArrayList<String>();
        for(var x : DyeColor.values()) data.add(x.toString());
        return data;
    }

    @Override
    public void CUSTOM_CAST_AND_PLACE(List<Object> toAdd, int place, List<?> castedData, Class<?> arrayType) {
        toAdd.add(castedData.toArray(new DyeColor[0]));
    }
}

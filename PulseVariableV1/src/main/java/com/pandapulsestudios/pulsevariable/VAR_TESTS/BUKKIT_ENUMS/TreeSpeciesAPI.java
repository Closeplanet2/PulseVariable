package com.pandapulsestudios.pulsevariable.VAR_TESTS.BUKKIT_ENUMS;

import com.pandapulsestudios.pulsevariable.INTERFACE.VarTest;
import com.pandapulsestudios.pulsevariable.INTERFACE.VariableLogic;
import org.bukkit.Sound;
import org.bukkit.Statistic;
import org.bukkit.TreeSpecies;

import java.util.ArrayList;
import java.util.List;

@VarTest
@Deprecated
public class TreeSpeciesAPI implements VariableLogic {
    @Override
    @Deprecated
    public boolean IS_TYPE(String variable) {
        try{
            var test = TreeSpecies.valueOf(variable);
            return true;
        }catch (IllegalArgumentException ignored){ return false; }
    }

    @Override
    @Deprecated
    public List<Class<?>> CLASS_TYPE() {
        var data = new ArrayList<Class<?>>();
        data.add(TreeSpecies.class);
        return data;
    }

    @Override
    @Deprecated
    public List<Class<?>> ARRAY_TYPE() {
        var data = new ArrayList<Class<?>>();
        data.add(TreeSpecies.class);
        return data;
    }

    @Override
    @Deprecated
    public Object CONVERT_FOR_CONFIG(Object data) { return data.toString(); }

    @Override
    @Deprecated
    public Object DE_CONVERT_FOR_CONFIG(Object data) {
        return TreeSpecies.valueOf(data.toString());
    }

    @Override
    @Deprecated
    public List<String> TAB_DATA(List<String> to_add, String currentArgument) {
        var data = new ArrayList<String>();
        for(var x : TreeSpecies.values()) data.add(x.toString());
        return data;
    }

    @Override
    @Deprecated
    public void CUSTOM_CAST_AND_PLACE(List<Object> toAdd, int place, List<?> castedData, Class<?> arrayType) {
        toAdd.add(castedData.toArray(new TreeSpecies[0]));
    }
}

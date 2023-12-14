package com.pandapulsestudios.pulsevariable.INTERFACE;

import java.util.ArrayList;
import java.util.List;

public interface VariableLogic {
    boolean IS_TYPE(String variable);
    List<Class<?>> CLASS_TYPE();
    List<Class<?>> ARRAY_TYPE();
    Object CONVERT_FOR_CONFIG(Object data);
    Object DE_CONVERT_FOR_CONFIG(Object data);
    List<String> TAB_DATA(List<String> to_add, String currentArgument);
    default void CUSTOM_CAST_AND_PLACE(List<Object> toAdd, int place, List<?> castedData, Class<?> arrayType){
        toAdd.add(arrayType.cast(castedData.toArray()));
    }
    default List<?> CONVERT(List<String> convert){
        var data = new ArrayList<>();
        for(var x : convert) data.add(CONVERT_FOR_CONFIG(x));
        return data;
    }
}

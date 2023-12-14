package com.pandapulsestudios.pulsevariable.Interface;

import java.util.HashMap;
import java.util.List;

public interface PulseVariable {
    boolean IsType(Object variable);
    List<Class<?>> ClassTypes();
    Object SerializeData(Object serializedData);
    Object DeSerializeData(Object serializedData);
    default List<String> TabData(List<String> baseTabList, String currentArgument){
        return baseTabList;
    }
}

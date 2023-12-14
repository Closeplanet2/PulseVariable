package com.pandapulsestudios.pulsevariable.Interface;

public interface CustomVariable {
    default Class<?> ClassType(){ return null; }
    String SerializeData();
    Object DeSerializeData(String serializedData);
}

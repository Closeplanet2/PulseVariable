package com.pandapulsestudios.pulsevariable.VariableTests.BukkitEnums;

import com.pandapulsestudios.pulsevariable.Interface.PulseVariable;
import org.bukkit.Note;

import java.util.ArrayList;
import java.util.List;

public class NoteToneTest implements PulseVariable {
    @Override
    public boolean IsType(Object variable) {
        try{
            var test = Note.Tone.valueOf(variable.toString());
            return true;
        }catch (IllegalArgumentException ignored){ return false; }
    }

    @Override
    public List<Class<?>> ClassTypes() {
        var data = new ArrayList<Class<?>>();
        data.add(Note.Tone.class);
        data.add(Note.Tone[].class);
        return data;
    }

    @Override
    public Object SerializeData(Object serializedData) {
        return serializedData.toString();
    }

    @Override
    public Object DeSerializeData(Object serializedData) {
        return Note.Tone.valueOf(serializedData.toString());
    }
}

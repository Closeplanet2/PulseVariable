package com.pandapulsestudios.pulsevariable.API;

import com.pandapulsestudios.pulsevariable.INTERFACE.VariableLogic;
import com.pandapulsestudios.pulsevariable.PulseVariable;
import com.pandapulsestudios.pulsevariable.VAR_TESTS.STATIC_TESTS.StaticString;

import java.util.ArrayList;
import java.util.List;

public class PulseVarAPI {
    public static boolean REGISTER_VAR_TEST(Class<?> test_class, VariableLogic variableLogic, boolean override_if_found){
        if(PulseVariable.VAR_TESTS.containsKey(test_class) && !override_if_found) return false;
        PulseVariable.VAR_TESTS.put(test_class, variableLogic);
        return true;
    }

    public static List<String> RETURN_AS_ALL_TYPES(String text, boolean uppercase, boolean lowercase, boolean isElementArray) {
        var all_types = new ArrayList<String>();
        for(var test_key : PulseVariable.VAR_TESTS.keySet()){
            var test = PulseVariable.VAR_TESTS.get(test_key);
            if(test.IS_TYPE(text)) if(all_types.size() == 0) all_types.add(StaticString.CASE(text, uppercase, lowercase));
            for(var type : isElementArray ? test.ARRAY_TYPE() : test.CLASS_TYPE()) all_types.add(StaticString.CASE(type.getSimpleName(), uppercase, lowercase));
        }
        return all_types;
    }

    public static VariableLogic RETURN_TEST_FROM_TYPE(String type, boolean searchByArrayType){
        for(var test_key : PulseVariable.VAR_TESTS.keySet()){
            var test = PulseVariable.VAR_TESTS.get(test_key);
            var array = searchByArrayType ? test.ARRAY_TYPE() : test.CLASS_TYPE();
            for(var t : array) if(t.getSimpleName().equalsIgnoreCase(type)) return test;
        }
        return null;
    }
}

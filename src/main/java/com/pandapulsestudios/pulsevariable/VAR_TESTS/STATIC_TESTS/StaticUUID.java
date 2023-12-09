package com.pandapulsestudios.pulsevariable.VAR_TESTS.STATIC_TESTS;

import com.pandapulsestudios.pulsevariable.PulseVariable;

import java.util.UUID;

public class StaticUUID {
    public static boolean IS_TYPE(String variable) {
        return PulseVariable.VAR_TESTS.get(UUID.class).IS_TYPE(variable);
    }
}

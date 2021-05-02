package com.example.demo.Util;

import org.springframework.stereotype.Component;

@Component
public class Utilities {
    public boolean isEmptyString(String string) {
        return string == null || string.isEmpty();
    }
}

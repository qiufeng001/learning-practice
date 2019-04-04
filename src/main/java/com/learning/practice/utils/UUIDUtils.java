package com.learning.practice.utils;

import java.util.UUID;

public class UUIDUtils {
    public UUIDUtils() {
    }

    public static String getUUID() {
        return UUID.randomUUID().toString().replace("-", "");
    }
}

package com.example.nuevaprueba;

import org.springframework.stereotype.Service;

import java.util.function.Predicate;

@Service
public class validador implements Predicate<String> {
    @Override
    public boolean test(String s) {
        return true;
    }
}


package com.leonardobarbosa.javastudy.oop.overriding.test;

import com.leonardobarbosa.javastudy.oop.overriding.domain.MethodOverride;

public class OverrideToStringExample {
    public static void main(String[] args) {

        MethodOverride anime = new MethodOverride("Death Note", 2);
        System.out.println(anime);
    }
}

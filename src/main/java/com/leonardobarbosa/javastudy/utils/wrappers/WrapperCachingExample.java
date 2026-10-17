package com.leonardobarbosa.javastudy.utils.wrappers;

public class WrapperCachingExample {
    public static void main(String[] args) {

        /*
         Cache:

         Integer: -128 a 127
         Boolean: TRUE/FALSE sempre reutilizados
         Character: 0 a 127
         Double: sem cache
         */

        Integer a = 100;
        Integer b = 100;

        System.out.println(a == b); // true (cache)

        Integer c = 200;
        Integer d = 200;

        System.out.println(c == d); // false

        Boolean t1 = true;
        Boolean t2 = true;

        System.out.println(t1 == t2); // true
    }
}

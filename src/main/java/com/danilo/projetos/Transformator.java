package com.danilo.projetos;

import java.lang.reflect.InvocationTargetException;

public class Transformator {

    public <I, O> transformar(I input) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, IllegalArgumentException, InvocationTargetException {
        Class<?> source = input.getClass();
        Class<?> target = source.forName(source.getClass() + "DTO");

        //busca os construtores em tempo de execuçao
        O targetClass = (O) target.getDeclaredConstructor().newInstance();

    }
}

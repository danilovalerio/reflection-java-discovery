package com.danilo.projetos;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

public class Transformator {

    public <I, O> O transformar(I input) throws ClassNotFoundException, IllegalAccessException, InstantiationException
            , NoSuchMethodException, IllegalArgumentException, InvocationTargetException {
        //Classe que vai ser transformada
        Class<?> source = input.getClass();
        Class<?> target = Class.forName(source + "DTO");

        //busca os construtores em tempo de execuçao
        O targetClass = (O) target.getDeclaredConstructor().newInstance();

        //Pega os campos das classes
        Field[] sourceCampos = source.getDeclaredFields();
        Field[] targetCampos = target.getDeclaredFields();

        return targetClass;

    }
}

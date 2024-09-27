package com.danilo.projetos;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;

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

        //Transforma o array de campos em um array
        Arrays.stream(sourceCampos).forEach(sourceField ->
                Arrays.stream(targetCampos).forEach(targetField -> {
                    validar(sourceField, targetField);
                    try {
                        targetField.set(targetClass, sourceField.get(input));
                    } catch (IllegalAccessException e) {
                        throw new RuntimeException(e);
                    }
                }));

        return targetClass;

    }

    private void validar(Field sourceField, Field targetField) {
        if (sourceField.getName().equals(targetField.getName()) &&
        sourceField.getType().equals(targetField.getType())) {
            sourceField.setAccessible(true);
            targetField.setAccessible(true);
        }
    }
}

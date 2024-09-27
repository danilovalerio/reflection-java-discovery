package com.danilo.projetos;

import java.lang.reflect.InvocationTargetException;

public class PessoaService {

    public PessoaDTO list() throws ClassNotFoundException, InvocationTargetException, IllegalAccessException, InstantiationException, NoSuchMethodException {
        Pessoa pessoa = new PessoaRepository().list();

        PessoaDTO pessoaDTO =new Transformator().transformar(pessoa);

        //PessoaDTO pessoaDTO = new PessoaDTO(pessoa.getNome(), pessoa.getCpf());
        return pessoaDTO;
    }
}

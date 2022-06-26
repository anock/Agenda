package com.example.agenda.DAO;

import com.example.agenda.model.Aluno;

import java.util.ArrayList;
import java.util.List;

public class AluniDAO {

    private final static List<Aluno> alunos = new ArrayList<>();

    public List<Aluno> todas(){
        return new ArrayList<>(alunos);
    };

    public void salva(Aluno aluno) {
        alunos.add(aluno);
    }
}

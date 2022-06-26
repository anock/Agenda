package com.example.agenda.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.agenda.DAO.AluniDAO;
import com.example.agenda.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainActivity extends AppCompatActivity {

    public static final String LISTA_DE_ALUNOS = "Lista de Alunos";
    private final AluniDAO dao = new AluniDAO();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Toast.makeText(this, "Hello World", Toast.LENGTH_LONG).show();
        setContentView(R.layout.activity_main);
        setTitle(LISTA_DE_ALUNOS);

        configuraNovoAluno();
    }
    private void configuraNovoAluno() {
        FloatingActionButton botaoNovoAluno = findViewById(R.id.activity_main_fab_novo_aluno);
        botaoNovoAluno.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, FormularioAlunoActivity.class));
            }
        });
    }
    @Override
    protected void onResume() {
        super.onResume();
        configuraLista();
    }
    private void configuraLista() {
        ListView listaAlunos = findViewById(R.id.activity_main_lista_de_alunos);
        listaAlunos.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_expandable_list_item_1, dao.todas()));
    }
}

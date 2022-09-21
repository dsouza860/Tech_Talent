package com.example.tech_talent;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.tech_talent.model.Projetos;
import com.example.tech_talent.model.ProjetosRest;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.http.GET;

public class CadastroProjeto extends AppCompatActivity {
    ProgressDialog dialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_projeto);

        final EditText edNome = findViewById(R.id.edNome);
        final EditText edDescricao = findViewById(R.id.edDescricao);
        final EditText edData = findViewById(R.id.edData);
        final EditText edQtdPessoa = findViewById(R.id.edQtdPessoas);
        final Button btnCadastrar = findViewById(R.id.btnCadastrar);

        btnCadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog = new ProgressDialog(CadastroProjeto.this);
                dialog.setMessage("Carregando...");
                dialog.setCancelable(false);
                dialog.show();
                Projetos projetos = new Projetos();
                projetos.setTitle(edNome.getText().toString());
                projetos.setDescription(edDescricao.getText().toString());
                projetos.setExpected_end_date(edData.getText().toString());
                projetos.setAmount_people(edQtdPessoa.getText().toString());
                ProjetosRest projetosRest = ProjetosRest.retrofit.create(ProjetosRest.class);
                final Call<Void> call = projetosRest.cadastraProjeto(projetos);
                call.enqueue(new Callback<Void>() {
                    @Override
                    public void onResponse(Call<Void> call, Response<Void> response) {
                        if(dialog.isShowing()){
                            dialog.dismiss();
                            Toast.makeText(getBaseContext(), "Projeto cadastrado com sucesso!", Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onFailure(Call<Void> call, Throwable t) {
                        if (dialog.isShowing()){
                            dialog.dismiss();
                            Toast.makeText(getBaseContext(), "Não foi possível efetuar o cadastro!", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }
        });
    }




}
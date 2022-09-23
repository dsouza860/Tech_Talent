package com.example.tech_talent;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class CadastroProjeto extends AppCompatActivity {
    String nome, descricao, data, qtdPessoa;
    String url = "https://tech-talent.hasura.app/api/rest/projects";
    EditText edNome, edDescricao, edData, edQtdPessoa, edId;
    Button btnCadastrar, btnEditar, btnExcluir;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_cadastro_projeto);
         edId = findViewById (R.id.edId);
         edNome = findViewById (R.id.edNome);
         edDescricao = findViewById (R.id.edDescricao);
         edData = findViewById (R.id.edData);
         edQtdPessoa = findViewById (R.id.edQtdPessoas);
         btnCadastrar = findViewById (R.id.btnCadastrar);
         btnEditar = findViewById (R.id.btnEditar);
         btnExcluir = findViewById (R.id.btnExcluir);
        RequestQueue requestQueue = Volley.newRequestQueue (this);
        btnCadastrar.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                nome = edNome.getText ().toString ().trim ();
                descricao = edDescricao.getText ().toString ().trim ();
                data = edData.getText ().toString ().trim ();
                qtdPessoa = edQtdPessoa.getText ().toString ().trim ();

                StringRequest stringRequest = new StringRequest (Request.Method.POST, url, new Response.Listener<String> () {

                    @Override
                    public void onResponse(String response) {
                        edNome.setText ("");
                        edDescricao.setText ("");
                        edData.setText ("");
                        edQtdPessoa.setText ("");
                    }
                }, new Response.ErrorListener () {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.e("Erro: " , String.valueOf (error));
                        int x = 0;
                    }
                }) {
                    @Nullable
                    @Override
                    protected Map<String, String> getParams() throws AuthFailureError {
                        Map<String, String> params = new HashMap<> ();
                        params.put ("title", "nome");
                        params.put ("description", "descricao");
                        params.put ("expected_end_date", "data");
                        params.put ("amount_people", "qtdPessoa");

                        return params;
                    }

                    @Override
                    public Map<String, String> getHeaders() throws AuthFailureError {
                        HashMap<String, String> headers = new HashMap<String, String> ();
                        headers.put ("Content-Type", "application/json; charset=UTF-8");
                        headers.put ("x-hasura-access-key", "CQOsnv00PT6e7E8UY06ti0tmFgs4GGT7DZrnZvJqS649gBVFUSH1dmiRpmIJdsd4");
                        headers.put ("x-hasura-role", "user");
                        headers.put ("x-hasura-user-id", "diego-souza-34");
                        return headers;
                    }

                    @Override
                    public String getBodyContentType() {
                        return "application/json";
                    }
                };
                requestQueue.add (stringRequest);
            }
        });
        btnEditar.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View view) {
                StringRequest putRequest = new StringRequest (Request.Method.PUT, url, new Response.Listener<String> () {
                    @Override
                    public void onResponse(String response) {
                        Log.d ("Response: ", response.toString ());
                    }
                }, new Response.ErrorListener () {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText (CadastroProjeto.this, "Error: ", Toast.LENGTH_SHORT).show ();
                    }
                }){
                    @Nullable
                    @Override
                    protected Map<String, String> getParams() throws AuthFailureError {
                        Map<String, String> params = new HashMap<> ();
                        params.put ("title", "nome");
                        params.put ("description", "descricao");
                        params.put ("expected_end_date", "data");
                        params.put ("amount_people", "qtdPessoa");

                        return params;
                    }

                    @Override
                    public Map<String, String> getHeaders() throws AuthFailureError {
                        HashMap<String, String> headers = new HashMap<String, String> ();
                        headers.put ("Content-Type", "application/json; charset=UTF-8");
                        headers.put ("x-hasura-access-key", "CQOsnv00PT6e7E8UY06ti0tmFgs4GGT7DZrnZvJqS649gBVFUSH1dmiRpmIJdsd4");
                        headers.put ("x-hasura-role", "user");
                        headers.put ("x-hasura-user-id", "diego-souza-34");
                        return headers;
                    }
                };
                requestQueue.add (putRequest);

            }
        });
        btnExcluir.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View view) {
                StringRequest deleteRequest = new StringRequest (Request.Method.DELETE, url, new Response.Listener<String> () {
                    @Override
                    public void onResponse(String response) {
                        Log.d ("Response: ", response.toString ());
                    }
                }, new Response.ErrorListener () {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText (CadastroProjeto.this, "Error: ", Toast.LENGTH_SHORT).show ();
                    }
                }){
                    @Nullable
                    @Override
                    protected Map<String, String> getParams() throws AuthFailureError {
                        Map<String, String> params = new HashMap<> ();
                        params.put ("title", "nome");
                        params.put ("description", "descricao");
                        params.put ("expected_end_date", "data");
                        params.put ("amount_people", "qtdPessoa");

                        return params;
                    }

                    @Override
                    public Map<String, String> getHeaders() throws AuthFailureError {
                        HashMap<String, String> headers = new HashMap<String, String> ();
                        headers.put ("Content-Type", "application/json; charset=UTF-8");
                        headers.put ("x-hasura-access-key", "CQOsnv00PT6e7E8UY06ti0tmFgs4GGT7DZrnZvJqS649gBVFUSH1dmiRpmIJdsd4");
                        headers.put ("x-hasura-role", "user");
                        headers.put ("x-hasura-user-id", "diego-souza-34");
                        return headers;
                    }
                };
                requestQueue.add (deleteRequest);
            }

        });
    }
}
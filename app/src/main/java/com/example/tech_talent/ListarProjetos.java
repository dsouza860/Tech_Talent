package com.example.tech_talent;

import static com.android.volley.Request.*;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.app.DownloadManager;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.tech_talent.model.Projetos;
//import com.example.tech_talent.model.ProjetosAdapter;
import com.example.tech_talent.model.ProjetosAdapter;
import com.example.tech_talent.model.ProjetosRest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ListarProjetos extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listar_projetos);

        final ListView lista = (ListView) findViewById(R.id.lvProjetos);
        ProjetosRest projetosRest = ProjetosRest.retrofit.create(ProjetosRest.class);

        ProgressDialog dialog = new ProgressDialog(ListarProjetos.this);
        dialog.setMessage("Carregando");
        dialog.setCancelable(false);
        dialog.show();
        final Call<List<Projetos>> call = projetosRest.getProjetos();
        call.enqueue(new Callback<List<Projetos>>() {
            @Override
            public void onResponse(Call<List<Projetos>> call, Response<List<Projetos>> response) {
                if(dialog.isShowing())
                    dialog.dismiss();
                    final List<Projetos> listaProjetos = response.body();

                if(listaProjetos != null){
                    ProjetosAdapter adapter = new ProjetosAdapter(getBaseContext(), listaProjetos);
                    lista.setAdapter(adapter);

                }
            }

            @Override
            public void onFailure(Call<List<Projetos>> call, Throwable t) {
                if(dialog.isShowing())
                    dialog.dismiss();
                Toast.makeText(getBaseContext(), "Problema de acesso", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
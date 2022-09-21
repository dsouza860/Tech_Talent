package com.example.tech_talent.model;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.tech_talent.R;
import java.util.List;


public class ProjetosAdapter extends ArrayAdapter<Projetos> {
    private final Context context;
    private final List<Projetos> lista;

    public ProjetosAdapter(Context context, List<Projetos> lista) {
        super(context, R.layout.projetos_list, lista);
        this.context = context;
        this.lista = lista;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.projetos_list, parent, false);
        TextView title = (TextView) rowView.findViewById(R.id.txtNome);
        TextView description = (TextView) rowView.findViewById(R.id.txtDescricao);
        TextView start_date = (TextView) rowView.findViewById(R.id.txtDataInicio);
        TextView expected_end_date = (TextView) rowView.findViewById(R.id.txtDataPrevista);
        TextView amount_people = (TextView) rowView.findViewById(R.id.txtqtdPessoa);

        title.setText(lista.get(position).getTitle());
        description.setText(lista.get(position).getDescription());
        start_date.setText(lista.get(position).getStart_date());
        expected_end_date.setText(lista.get(position).getExpected_end_date());
        amount_people.setText(lista.get(position).getAmount_people());
        return rowView;
    }
}

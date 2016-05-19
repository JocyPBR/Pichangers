package pe.edu.ulima.pc1.adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

import pe.edu.ulima.pc1.InformacionActivity;
import pe.edu.ulima.pc1.R;
import pe.edu.ulima.pc1.beans.Equipo;
import pe.edu.ulima.pc1.listadoequipos.ListaEquiposItemView;
import pe.edu.ulima.pc1.listaintegrantes.ListaIntegrantesActivity;

public class ListadoEquiposAdapter extends BaseAdapter {

    private List<Equipo> mEquipo;
    private LayoutInflater mInflater;
    private Context mContext;

    public ListadoEquiposAdapter(Context mContext, List<Equipo> equipos){
        this.mContext = mContext;
        this.mInflater = LayoutInflater.from(mContext);
        this.mEquipo = equipos;
    }

    @Override
    public int getCount() {
        return mEquipo.size();
    }

    @Override
    public Object getItem(int i) {
        return mEquipo.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder viewHolder;

        if (view == null) {
            view = mInflater.inflate(R.layout.item_lista_equipos, null);

            viewHolder = new ViewHolder();
            viewHolder.tviNombreEquipo = (TextView) view.findViewById(R.id.tviNombreEquipo);
            viewHolder.iviFondo = (ListaEquiposItemView) view.findViewById(R.id.iviFondo);
            viewHolder.eteMas = (ImageView) view.findViewById(R.id.eteMas);
            viewHolder.etePersona = (ImageView) view.findViewById(R.id.etePersona);
            viewHolder.eteInternet = (ImageView) view.findViewById(R.id.eteInternet);

            view.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) view.getTag();
        }

        final Equipo equipo = mEquipo.get(i);

        viewHolder.tviNombreEquipo.setText(equipo.getNombre());

        Picasso.with(mContext).load(equipo.getUrlFoto()).centerCrop().fit().into(viewHolder.iviFondo);

        view.findViewById(R.id.eteMas).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext, ListaIntegrantesActivity.class);
                intent.putExtra("equipo", equipo);
                mContext.startActivity(intent);
            }
        });

        view.findViewById(R.id.eteEquipo).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext, InformacionActivity.class);
                intent.putExtra("equipo", equipo);
                mContext.startActivity(intent);
            }
        });

        return view;
    }

    class ViewHolder{
        TextView tviNombreEquipo;
        ImageView iviFondo;
        ImageView eteMas;
        ImageView etePersona;
        ImageView eteInternet;
    }
}

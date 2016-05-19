package pe.edu.ulima.pc1.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import pe.edu.ulima.pc1.R;
import pe.edu.ulima.pc1.beans.Integrante;

public class ListadoIntegrantesAdapter extends BaseAdapter{

    private List<Integrante> mIntegrantes;
    private LayoutInflater mInflater;
    private Context mContext;

    public ListadoIntegrantesAdapter(List<Integrante> mIntegrantes, Context mContext) {
        this.mIntegrantes = mIntegrantes;
        this.mContext = mContext;
        mInflater = LayoutInflater.from(mContext);
    }

    @Override
    public int getCount() {
        return mIntegrantes.size();
    }

    @Override
    public Object getItem(int i) {
        return mIntegrantes.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder viewHolder;
        if(view == null){
            view = mInflater.inflate(R.layout.item_lista_integrantes, null);
            viewHolder = new ViewHolder();
            viewHolder.tviNombre = (TextView) view.findViewById(R.id.tviNombre);
            viewHolder.tviCodigo = (TextView) view.findViewById(R.id.tviCodigo);

            view.setTag(viewHolder);
        }else{
            viewHolder = (ViewHolder) view.getTag();
        }

        Integrante integrante = mIntegrantes.get(i);

        viewHolder.tviNombre.setText(integrante.getNombre());
        viewHolder.tviCodigo.setText(integrante.getCodigo());

        return view;
    }

    class ViewHolder{
        TextView tviNombre;
        TextView tviCodigo;
    }
}

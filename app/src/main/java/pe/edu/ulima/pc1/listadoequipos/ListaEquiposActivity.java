package pe.edu.ulima.pc1.listadoequipos;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.GridView;

import java.util.List;

import pe.edu.ulima.pc1.R;
import pe.edu.ulima.pc1.adapters.ListadoEquiposAdapter;
import pe.edu.ulima.pc1.beans.Equipo;

public class ListaEquiposActivity extends AppCompatActivity implements ListaEquiposView{
    ListaEquiposPresenter mPresenter;

    GridView gviEquipos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_equipos);

        gviEquipos = (GridView) findViewById(R.id.gviEquipos);

        setPresenter(new ListaEquiposPresenterImpl(this));

        mPresenter.obtenerEquipos();
    }

    @Override
    public void setPresenter(ListaEquiposPresenter presenter) {
        this.mPresenter=presenter;
    }

    @Override
    public void mostrarListaEquipos(List<Equipo> equipos) {
        ListadoEquiposAdapter adapter = new ListadoEquiposAdapter(this, equipos);

        gviEquipos.setAdapter(adapter);
    }
}

package pe.edu.ulima.pc1.listaintegrantes;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.List;

import pe.edu.ulima.pc1.R;
import pe.edu.ulima.pc1.adapters.ListadoIntegrantesAdapter;
import pe.edu.ulima.pc1.beans.Integrante;

public class ListaIntegrantesActivity extends AppCompatActivity implements ListaIntegrantesView {
    ListaIntegrantesPresenter mPresenter;

    ListView lviIntegrantes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_integrantes);

        lviIntegrantes = (ListView) findViewById(R.id.lviIntegrantes);

        setPresenter(new ListaIntegrantesPresenterImpl(this));

        mPresenter.obtenerIntegrantes();
    }

    @Override
    public void setPresenter(ListaIntegrantesPresenter presenter) {
        this.mPresenter=presenter;
    }

    @Override
    public void mostrarListaIntegrantes(List<Integrante> integrantes) {
        ListadoIntegrantesAdapter adapter = new ListadoIntegrantesAdapter(integrantes, this);

        lviIntegrantes.setAdapter(adapter);
    }
}

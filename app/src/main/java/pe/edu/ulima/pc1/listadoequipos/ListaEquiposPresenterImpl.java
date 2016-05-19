package pe.edu.ulima.pc1.listadoequipos;

import android.util.Log;

import java.util.List;

import pe.edu.ulima.pc1.beans.Equipo;
import pe.edu.ulima.pc1.remote.Service;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Melgarejo on 16/05/2016.
 */
public class ListaEquiposPresenterImpl implements ListaEquiposPresenter{

    private ListaEquiposView mView;

    public ListaEquiposPresenterImpl(ListaEquiposView view){
        mView = view;
    }

    @Override
    public void obtenerEquipos(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://1-dot-pichangers-1307.appspot.com/rest/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        Service service = retrofit.create(Service.class);
        service.obtenerEquipo().enqueue(new Callback<List<Equipo>>() {
            @Override
            public void onResponse(Call<List<Equipo>> call, Response<List<Equipo>> response) {
                mView.mostrarListaEquipos(response.body());
            }

            @Override
            public void onFailure(Call call, Throwable t) {
                Log.e("Pichangers", t.getMessage());
            }
        });
    }


}

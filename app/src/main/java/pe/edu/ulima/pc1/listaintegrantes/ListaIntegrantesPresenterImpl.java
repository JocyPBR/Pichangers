package pe.edu.ulima.pc1.listaintegrantes;

import android.util.Log;

import java.util.List;

import pe.edu.ulima.pc1.beans.Integrante;
import pe.edu.ulima.pc1.remote.Service;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Melgarejo on 15/05/2016.
 */
public class ListaIntegrantesPresenterImpl implements ListaIntegrantesPresenter {

    private ListaIntegrantesView mView;

    public ListaIntegrantesPresenterImpl(ListaIntegrantesView view){
        mView = view;
    }

    @Override
    public void obtenerIntegrantes(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://1-dot-pichangers-1307.appspot.com/rest/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        Service service = retrofit.create(Service.class);
        service.obtenerIntegrantes(true).enqueue(new Callback<List<Integrante>>() {
            @Override
            public void onResponse(Call<List<Integrante>> call, Response<List<Integrante>> response) {
                mView.mostrarListaIntegrantes(response.body());
            }

            @Override
            public void onFailure(Call call, Throwable t) {
                Log.e("Pichangers", t.getMessage());
            }
        });
    }
}

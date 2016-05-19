package pe.edu.ulima.pc1;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import pe.edu.ulima.pc1.beans.LoginRespuesta;
import pe.edu.ulima.pc1.beans.Usuario;
import pe.edu.ulima.pc1.listadoequipos.ListaEquiposActivity;
import pe.edu.ulima.pc1.remote.Service;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    EditText eteUsuario, etePassword;
    Button butInscribir;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        eteUsuario = (EditText) findViewById(R.id.eteUsuario);
        etePassword = (EditText) findViewById(R.id.etePassword);
        butInscribir = (Button) findViewById(R.id.butInscribir);

        butInscribir.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        String usuario = eteUsuario.getText().toString();
        String password = etePassword.getText().toString();

        final Usuario u = new Usuario(usuario, password);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://1-dot-pichangers-1307.appspot.com/rest/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        Service service = retrofit.create(Service.class);

        service.loginUsuario(u).enqueue(new Callback<LoginRespuesta>() {
            @Override
            public void onResponse(Call<LoginRespuesta> call, Response<LoginRespuesta> response) {
                if (response.body().getMsg().equals("OK")) {
                    Intent intent = new Intent(getBaseContext(), ListaEquiposActivity.class);
                    intent.putExtra("usuario", u);
                    startActivity(intent);
                } else {
                    Toast.makeText(getBaseContext(), "Usuario/Contraseña equivocados", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<LoginRespuesta> call, Throwable t) {
                Toast.makeText(getBaseContext(), "Error de comunicaciones", Toast.LENGTH_SHORT).show();
            }
        });
    }
}

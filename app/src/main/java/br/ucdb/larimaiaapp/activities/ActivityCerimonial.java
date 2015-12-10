package br.ucdb.larimaiaapp.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;
import android.widget.Toast;

import br.ucdb.larimaiaapp.R;
import br.ucdb.larimaiaapp.api.ApiWeb;
import br.ucdb.larimaiaapp.model.Cerimonial;
import br.ucdb.larimaiaapp.model.TipoEvento;
import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

/**
 * Created by Usuario on 02/12/2015.
 */
public class ActivityCerimonial extends AppCompatActivity {
    static boolean valida = false;

    static Cerimonial cerimonial ;

    @Bind(R.id.et_nome)
    EditText etNome;

    @Override
    public void onCreate(Bundle savedInstanceState ){

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cerimonial);
        ButterKnife.bind(this);

        Intent intent = getIntent();
        Cerimonial cerimonial = (Cerimonial) intent.getSerializableExtra("Cerimonial");
        if(cerimonial!=null){
            TelaEditar(cerimonial);
        }

    }

    @OnClick(R.id.btn_salvar_cerimonial)
    public void salvar() {
        if(valida==false) {
            Cerimonial cerimonial = new Cerimonial();
            cerimonial.setNome(etNome.getText().toString());

            ApiWeb.getRotas().salvarCerimonial(cerimonial, new Callback<Response>() {
                @Override
                public void success(Response response, Response response2) {
                    Toast.makeText(ActivityCerimonial.this, "Salvo com sucesso", Toast.LENGTH_SHORT).show();
                    etNome.setText("");
                }

                @Override
                public void failure(RetrofitError error) {
                    Toast.makeText(ActivityCerimonial.this, "Falha ao salvar", Toast.LENGTH_SHORT).show();
                }
            });
        }else{
            editar();
        }

    }
    public void editar(){
        Cerimonial cerimonial = this.cerimonial;
        cerimonial.setNome(etNome.getText().toString());

        ApiWeb.getRotas().salvarCerimonial(cerimonial, new Callback<Response>() {
            @Override
            public void success(Response response, Response response2) {
                Toast.makeText(ActivityCerimonial.this, "Salvo com sucesso", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void failure(RetrofitError error) {
                Toast.makeText(ActivityCerimonial.this, "Falha ao salvar", Toast.LENGTH_SHORT).show();
            }
        });
        valida=false;
    }

    public void TelaEditar(Cerimonial ce){
        cerimonial = ce;
        valida = true;
        etNome.setText(ce.getNome());
    }

    @OnClick(R.id.btn_listar_cerimonial)
    public void listar() {
        Intent irParaTelaListar = new Intent(this, ActivityConsultaCerimonial.class);
        startActivityForResult(irParaTelaListar, 1);
    }

    @OnClick(R.id.btn_voltar)
    public void voltar(){
        Intent it = new Intent(this,ActivityCadastros.class);
        startActivity(it);
    }
}

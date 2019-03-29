package com.naldana.pokedesk;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.gson.Gson;
import com.naldana.pokedesk.models.pokemonObj1;
import com.naldana.pokedesk.utilities.NetworkUtils;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<String> listDatos;
    /*EditText mPokemonNumber;
    Button mSearchButton;
    TextView mResultText;*/
    RecyclerView recycler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recycler = findViewById(R.id.recyclerId);
        recycler.setLayoutManager(new LinearLayoutManager(this, LinearLayout.VERTICAL,false));

        listDatos=new ArrayList<String>();
        new FetchPokemonTask().execute("");

        pokemonAdapter adapter = new pokemonAdapter(listDatos);
        recycler.setAdapter(adapter);

        Log.d("Hi", String.valueOf(listDatos.size()));
        /*bindView();

        mSearchButton.setOnClickListener(view -> {
            String pokemonNumber = mPokemonNumber.getText().toString().trim();
            if (pokemonNumber.isEmpty()) {
                mResultText.setText(R.string.text_nothing_to_show);
            } else {

                new FetchPokemonTask().execute(pokemonNumber);
            }
        });*/
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
    }
/*
    void bindView() {
        mPokemonNumber = findViewById(R.id.et_pokemon_number);
        mSearchButton = findViewById(R.id.bt_search_pokemon);
        mResultText = findViewById(R.id.tv_result);
    }
*/

    private class FetchPokemonTask extends AsyncTask<String, Void, String> {

        @Override
        protected String doInBackground(String... strings) {

            URL pokeAPI = NetworkUtils.buildUrl("");
            try {
                String result = NetworkUtils.getResponseFromHttpUrl(pokeAPI);
                Log.d("Poke","HoLA PRRO");
                Gson gson = new Gson();
                pokemonObj1 elemento = gson.fromJson(result,pokemonObj1.class);
                for (int i = 0 ; i< elemento.getResults().size();i++){
                    listDatos.add(elemento.getResults().get(i).name);
                    Log.d("probando", elemento.getResults().get(i).name);
                }

                return result;
            } catch (IOException e) {
                e.printStackTrace();
                return "";
            }
        }
    }
}
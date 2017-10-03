package ardiansyah.skripsi.com.banksampahrw09.fragment_admin;

import android.graphics.Color;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import ardiansyah.skripsi.com.banksampahrw09.R;
import ardiansyah.skripsi.com.banksampahrw09.adapter.AdapterPengguna;
import ardiansyah.skripsi.com.banksampahrw09.model.ModelPengguna;

/**
 * Created by Ardiansyah on 15/09/2017.
 */

public class TabDaftarPengguna extends Fragment {

    public RecyclerView recyclerView;
    public ModelPengguna modelPengguna;
    public AdapterPengguna adapterPengguna;
    public LinearLayoutManager linearLayoutManager;
    public static final String apiUrl = "http://api.smk-fornus.sch.id/pengguna.php";
    public JsonParser jsonParser;
    public ProgressBar progressBar;

    public TabDaftarPengguna(){

    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.tab_daftar_pengguna, container, false);
        recyclerView = view.findViewById(R.id.recViewListPengguna) ;
        linearLayoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(linearLayoutManager);

        progressBar = view.findViewById(R.id.progressBar);

        jsonParser = new JsonParser();
        jsonParser.execute(apiUrl);
        return view;
    }

    class JsonParser extends AsyncTask<String, Integer, String> {

        @Override
        protected String doInBackground(String... params) {
            HttpURLConnection urlConnection = null;
            BufferedReader reader = null;
            String penggunaJsonStr = null;

            try {
                URL url = new URL(params[0]);
                urlConnection = (HttpURLConnection) url.openConnection();
                urlConnection.setRequestMethod("GET");
                urlConnection.connect();
                InputStream inputStream = urlConnection.getInputStream();
                StringBuffer buffer = new StringBuffer();

                if (inputStream == null) {
                    return null;
                }
                reader = new BufferedReader(new InputStreamReader(inputStream));

                String line;
                while ((line = reader.readLine()) != null) {
                    buffer.append(line + "\n");
                }
                if (buffer.length() == 0) {
                    return null;
                }
                penggunaJsonStr = buffer.toString();
            } catch (IOException e) {
                Log.e("Daftar Pengguna ", "Error ", e);
                return null;
            }
            Log.e("JSON RESULT", penggunaJsonStr);
            return penggunaJsonStr;
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected void onPostExecute(String s) {
            modelPengguna = new Gson().fromJson(s, ModelPengguna.class);
            List<ModelPengguna.Pengguna> listPengguna = new ArrayList<>();

            listPengguna.addAll(modelPengguna.pengguna);

            //memasukan data ke adapter movie
            adapterPengguna = new AdapterPengguna(getContext(), listPengguna);
            recyclerView.setAdapter(adapterPengguna);

            progressBar.setVisibility(View.GONE);
            super.onPostExecute(s);
        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            super.onProgressUpdate(values);
        }
    }
}

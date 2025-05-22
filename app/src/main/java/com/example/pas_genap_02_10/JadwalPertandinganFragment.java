package com.example.pas_genap_02_10;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class JadwalPertandinganFragment extends Fragment {
    RecyclerView rvJadwal;
    ProgressBar pbLoading1;
    JadwalPertandinganAdapter jadwalAdapter;

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_jadwal_pertandingan, container, false);

        rvJadwal = view.findViewById(R.id.rvJadwalPertandingan);
        pbLoading1 = view.findViewById(R.id.pbLoading1);
        rvJadwal.setLayoutManager(new LinearLayoutManager(getContext()));

        SoccerAPI api = RetrofitClient.getInstance().create(SoccerAPI.class);
        fetchJadwal(api);

        return view;
    }
    private void fetchJadwal(SoccerAPI api) {
        api.getJadwalPertandingan("Jadwal").enqueue(new Callback<JadwalPertandinganResponse>() {
            @Override
            public void onResponse(Call<JadwalPertandinganResponse> call, Response<JadwalPertandinganResponse> response) {
                if (response.isSuccessful() && response.body() != null) {
                    List<JadwalPertandinganModel> jadwal = response.body().getJadwal();
                    jadwalAdapter = new JadwalPertandinganAdapter(jadwal);
                    rvJadwal.setAdapter(jadwalAdapter);
                    rvJadwal.setVisibility(View.VISIBLE);
                    pbLoading1.setVisibility(View.GONE);
                }
            }

            @Override
            public void onFailure(Call<JadwalPertandinganResponse> call, Throwable t) {
                Log.e("API_ERROR", t.getMessage());
            }
        });
    }
}

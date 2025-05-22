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

public class EPLFragment extends Fragment {
    RecyclerView rvEPL;
    EPLAdapter teamAdapter;
    ProgressBar pbLoading;

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_epl, container, false);

        rvEPL = view.findViewById(R.id.rvEPL);
        pbLoading = view.findViewById(R.id.pbLoading);
        rvEPL.setLayoutManager(new LinearLayoutManager(getContext()));

        SoccerAPI api = RetrofitClient.getInstance().create(SoccerAPI.class);
        fetchLaligaTeams(api);

        return view;
    }

    private void fetchLaligaTeams(SoccerAPI api) {
        api.getEPL("English Premier League").enqueue(new Callback<EPLResponse>() {
            @Override
            public void onResponse(Call<EPLResponse> call, Response<EPLResponse> response) {
                if (response.isSuccessful() && response.body() != null) {
                    List<EPLModel> teams = response.body().getTeams();
                    teamAdapter = new EPLAdapter(teams);
                    rvEPL.setAdapter(teamAdapter);
                    rvEPL.setVisibility(View.VISIBLE);
                    pbLoading.setVisibility(View.GONE);
                }
            }

            @Override
            public void onFailure(Call<EPLResponse> call, Throwable t) {
                Log.e("API_ERROR", t.getMessage());
            }
        });
    }
}
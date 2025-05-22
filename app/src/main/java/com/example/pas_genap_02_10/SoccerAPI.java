package com.example.pas_genap_02_10;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface SoccerAPI {
    @GET("/api/v1/json/3/search_all_teams.php?l=English%20Premier%20League")
    Call<EPLResponse> getEPL(@Query("l") String league);
}
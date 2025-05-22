package com.example.pas_genap_02_10;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class JadwalPertandinganResponse {
    @SerializedName("events")
    private List<JadwalPertandinganModel> jadwalList;

    public List<JadwalPertandinganModel> getJadwal() {
        return jadwalList;
    }
}

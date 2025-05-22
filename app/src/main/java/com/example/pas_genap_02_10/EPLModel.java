package com.example.pas_genap_02_10;

import com.google.gson.annotations.SerializedName;

public class EPLModel {
    @SerializedName("strTeam")
    private String strTeam;

    @SerializedName("strStadium")
    private String strStadium;

    @SerializedName("strTeamShort")
    private String strTeamShort;

    @SerializedName("strBadge")
    private String strBadge;

    public String getStrTeam() {
        return strTeam;
    }

    public String getStrStadium() {
        return strStadium;
    }

    public String getStrTeamShort() {
        return strTeamShort;
    }

    public String getStrBadge(){
        return strBadge;
    }
}

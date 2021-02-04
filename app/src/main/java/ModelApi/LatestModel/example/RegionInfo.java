
package ModelApi.LatestModel.example;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class RegionInfo {

    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("iso3166a2")
    @Expose
    private String iso3166a2;
    @SerializedName("iso3166a3")
    @Expose
    private String iso3166a3;
    @SerializedName("iso3166numeric")
    @Expose
    private String iso3166numeric;
    @SerializedName("total_cases")
    @Expose
    private Integer totalCases;
    @SerializedName("active_cases")
    @Expose
    private Integer activeCases;
    @SerializedName("deaths")
    @Expose
    private Integer deaths;
    @SerializedName("recovered")
    @Expose
    private Integer recovered;
    @SerializedName("critical")
    @Expose
    private Integer critical;
    @SerializedName("tested")
    @Expose
    private Integer tested;
    @SerializedName("death_ratio")
    @Expose
    private Double deathRatio;
    @SerializedName("recovery_ratio")
    @Expose
    private Double recoveryRatio;
    @SerializedName("change")
    @Expose
    private Change change;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIso3166a2() {
        return iso3166a2;
    }

    public void setIso3166a2(String iso3166a2) {
        this.iso3166a2 = iso3166a2;
    }

    public String getIso3166a3() {
        return iso3166a3;
    }

    public void setIso3166a3(String iso3166a3) {
        this.iso3166a3 = iso3166a3;
    }

    public String getIso3166numeric() {
        return iso3166numeric;
    }

    public void setIso3166numeric(String iso3166numeric) {
        this.iso3166numeric = iso3166numeric;
    }

    public Integer getTotalCases() {
        return totalCases;
    }

    public void setTotalCases(Integer totalCases) {
        this.totalCases = totalCases;
    }

    public Integer getActiveCases() {
        return activeCases;
    }

    public void setActiveCases(Integer activeCases) {
        this.activeCases = activeCases;
    }

    public Integer getDeaths() {
        return deaths;
    }

    public void setDeaths(Integer deaths) {
        this.deaths = deaths;
    }

    public Integer getRecovered() {
        return recovered;
    }

    public void setRecovered(Integer recovered) {
        this.recovered = recovered;
    }

    public Integer getCritical() {
        return critical;
    }

    public void setCritical(Integer critical) {
        this.critical = critical;
    }

    public Integer getTested() {
        return tested;
    }

    public void setTested(Integer tested) {
        this.tested = tested;
    }

    public Double getDeathRatio() {
        return deathRatio;
    }

    public void setDeathRatio(Double deathRatio) {
        this.deathRatio = deathRatio;
    }

    public Double getRecoveryRatio() {
        return recoveryRatio;
    }

    public void setRecoveryRatio(Double recoveryRatio) {
        this.recoveryRatio = recoveryRatio;
    }

    public Change getChange() {
        return change;
    }

    public void setChange(Change change) {
        this.change = change;
    }

}

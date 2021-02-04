
package ModelApi.LatestModel.example;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.Map;

public class Data {

    @SerializedName("summary")
    @Expose
    private Summary summary;
    @SerializedName("change")
    @Expose
    private Change change;
    @SerializedName("generated_on")
    @Expose
    private Integer generatedOn;
    @SerializedName("regions")
    @Expose
    private Map<String, RegionInfo> regions;

    public Summary getSummary() {
        return summary;
    }

    public void setSummary(Summary summary) {
        this.summary = summary;
    }

    public Change getChange() {
        return change;
    }

    public void setChange(Change change) {
        this.change = change;
    }

    public Integer getGeneratedOn() {
        return generatedOn;
    }

    public void setGeneratedOn(Integer generatedOn) {
        this.generatedOn = generatedOn;
    }

    public Map<String, RegionInfo> getRegions() {
        return regions;
    }

    public void setRegions(Map<String, RegionInfo> regions) {
        this.regions = regions;
    }

}

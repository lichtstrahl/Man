package iv.root.igor;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ResponseDTO {
    @SerializedName("results")
    List<Man> results;

    public List<Man> getResults() {
        return results;
    }
}

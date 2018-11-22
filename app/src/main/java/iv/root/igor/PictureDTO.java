package iv.root.igor;

import com.google.gson.annotations.SerializedName;

public class PictureDTO {
    @SerializedName("medium")
    String url;

    public String getUrl() {
        return url;
    }
}

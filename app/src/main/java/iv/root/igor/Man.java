package iv.root.igor;

import com.google.gson.annotations.SerializedName;

public class Man {

    @SerializedName("name")
    NameDTO name;

    @SerializedName("gender")
    String gender;

    @SerializedName("picture")
    PictureDTO picture;


    public String getFirstName() {
        return name.getFirstName();
    }

    public String getLastName() {
        return name.getLastName();
    }

    public String getGender() {
        return gender;
    }

    public NameDTO getName() {
        return name;
    }

    public PictureDTO getPicture() {
        return picture;
    }
}

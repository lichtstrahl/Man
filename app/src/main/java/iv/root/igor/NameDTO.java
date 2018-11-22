package iv.root.igor;

import com.google.gson.annotations.SerializedName;

public class NameDTO {
    @SerializedName("first")
    String firstName;
    @SerializedName("last")
    String lastName;

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }
}

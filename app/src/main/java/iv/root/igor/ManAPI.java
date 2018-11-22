package iv.root.igor;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ManAPI {
    @GET("/api")
    Call<ResponseDTO> getRandomMan(@Query("results") int count);
}

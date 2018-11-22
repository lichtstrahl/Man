package iv.root.igor;

import android.app.Application;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class App extends Application {
    private static Retrofit retrofit;
    private String URL = "https://randomuser.me";

    @Override
    public void onCreate() {
        super.onCreate();
        retrofit = new Retrofit.Builder()
                .baseUrl(URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public static ManAPI getManAPI() {
        return retrofit.create(ManAPI.class);
    }
}

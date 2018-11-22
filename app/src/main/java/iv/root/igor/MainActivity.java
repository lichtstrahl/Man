package iv.root.igor;

import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.bumptech.glide.module.AppGlideModule;

import java.util.LinkedList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    ManAdapter adapter;
    public static String urlImage = "https://steamcdn-a.akamaihd.net/apps/dota2/images/team_logos/1883502.png";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setTitle(R.string.defaultAppName);

        final List<Man> list = new LinkedList<>();

        adapter = new ManAdapter(list,this.getLayoutInflater());
        recyclerView = findViewById(R.id.list);

        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));



        App.getManAPI().getRandomMan(10).enqueue(new Callback<ResponseDTO>() {
            @Override
            public void onResponse(Call<ResponseDTO> call, Response<ResponseDTO> response) {
                ResponseDTO res = response.body();
                if (res != null) {
                    List<Man> mans = res.getResults();

                    for (Man m : mans)
                        adapter.append(m);
                    Toast.makeText(MainActivity.this, "Конец", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<ResponseDTO> call, Throwable t) {
                Toast.makeText(MainActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}
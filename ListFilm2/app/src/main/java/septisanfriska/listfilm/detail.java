package septisanfriska.listfilm;

import android.content.Intent;
import android.graphics.Movie;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;


public class detail extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        Intent intent = getIntent();
        movie movie = (movie) intent.getSerializableExtra("septisanfriska.listfilm");

        ((TextView) findViewById(R.id.title)).setText(movie.title);
        ((TextView) findViewById(R.id.description)).setText(movie.description);
        ((TextView) findViewById(R.id.year)).setText("Tahun: "+movie.year);
        ((TextView) findViewById(R.id.rating)).setText("Rating: "+movie.rating);
    }
}


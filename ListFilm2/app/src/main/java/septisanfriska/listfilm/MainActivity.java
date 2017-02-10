package septisanfriska.listfilm;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Movie;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private String[] filmTitles = {"The Thor", "Harry Potter", "Titanic", "Captain America"
            , "X-Men Apocalypse", "Shutter Island"};

    private ArrayList<movie> movies = new ArrayList<>();

    ArrayAdapter<movie> adapter;
    ListView listView;

    private void initMovies() {
        movies.add(new movie("The Thor", "Film Tentang superhero Thor yang turun ke semarang", 7.5, 2009));
        movies.add(new movie("Harry Potter", "Film Tentang Sekolah sihir", 7.5, 2010));
        movies.add(new movie("Titanic", "Film Tentang Kapal yang Tenggelam", 8.5, 2005));
        movies.add(new movie("Captain America", "Film Tentang Superhero dari pasukan Tentara Amerika", 8, 2012));
        movies.add(new movie("X-Men Apocalypse", "Film Tentang superhero Mutasi dengan cakar besi", 9.5, 2011));
        movies.add(new movie("Shutter Island", "Pulau yang misterius", 9, 2009));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initMovies();
        adapter = new ArrayAdapter<movie>(this, android.R.layout.simple_list_item_1, movies);
        listView = (ListView) findViewById(R.id.listFilm);
        listView.setAdapter(adapter);

        Button btn = (Button) findViewById(R.id.tambah);

        btn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                // TODO Auto-generated method stub
                Intent pindah = new Intent(MainActivity.this, tambah.class);
                startActivity(pindah);
                //menghubungkan antar activity dengan intent

            }
        });

        // membuat tulisan jika di klik
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                movie selectedMovie = movies.get(position);
                Intent intent = new Intent(getBaseContext(), detail.class);
                intent.putExtra("septisanfriska.listfilm", selectedMovie);
                startActivity(intent);
            }
        });
    }

    public void formtambah(View view) {
        Intent intent = new Intent(this, tambah.class);
        startActivityForResult(intent, 1);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == 1) {
            if (requestCode == Activity.RESULT_OK) {
                movie newmovie = (movie) data.getSerializableExtra("FilmList.result");
                movies.add(newmovie);
                adapter.notifyDataSetChanged();
            }
        }
    }




}






package septisanfriska.listfilm;

import android.widget.ListView;

import java.io.Serializable;

public class movie implements Serializable {
    public String title;
    public String description;
    public double rating;
    public int year;

    public movie(String title,String description, double rating, int year){
        this.title = title;
        this.description = description;
        this.rating =rating;
        this.year=year;
    }
    public String toString(){
        return this.title;
    }
}

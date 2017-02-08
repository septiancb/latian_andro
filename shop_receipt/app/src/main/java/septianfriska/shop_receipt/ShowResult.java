package septianfriska.shop_receipt;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class ShowResult extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_result);
        Intent intent = getIntent();
        int [] num_barang = new int[5];
        num_barang[0] = intent.getIntExtra("main.KEYBOARD.num",0);
        num_barang[1] = intent.getIntExtra("main.MONITOR.num",1);
        num_barang[2] = intent.getIntExtra("main.LCD.num",2);
        num_barang[3] = intent.getIntExtra("main.CASSING.num",3);
        num_barang[4] = intent.getIntExtra("main.CPU.num",4);

        int [] harga_barang = new int[5];
        harga_barang[0] = 5000000;
        harga_barang[1] = 350000;
        
        harga_barang[2] = 400000;
        harga_barang[3] = 100000;
        harga_barang[4] = 600000;

        int [] id_num = {R.id.KEYBOARD2_num, R.id.MONITOR2_num, R.id.LCD2_num, R.id.CASSING2_num, R.id.CPU2_num};
        int [] id_total = {R.id.KEYBOARD2_total, R.id.MONITOR2_total, R.id.LCD2_total, R.id.CASSING2_total, R.id.CPU2_total};

        int total = 0;
        for (int i = 0; i < 5;i ++){
            total += harga_barang[i] * num_barang[i];
            ((TextView) findViewById(id_num[i])).setText(Integer.toString(num_barang[i]));
            ((TextView) findViewById(id_total[i]))
                    .setText(Integer.toString(num_barang[i] * harga_barang[i]));
        }
        ((TextView) findViewById(R.id.grand_total)).setText(Integer.toString(total));

    }
}

package septianfriska.shop_receipt;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void printReceipt(View view){
        int [] num_barang = new int[5];
        String[] barang = new String[5];

        barang[0] = ((EditText) findViewById(R.id.KEYBOARD_num)).getText().toString();
        barang[1] = ((EditText) findViewById(R.id.MONITOR_num)).getText().toString();
        barang[2] = ((EditText) findViewById(R.id.LCD_num)).getText().toString();
        barang[3] = ((EditText) findViewById(R.id.CASSING_num)).getText().toString();
        barang[4] = ((EditText) findViewById(R.id.CPU_num)).getText().toString();

        num_barang[0] = Integer.parseInt(barang[0]);
        num_barang[1] = Integer.parseInt(barang[1]);
        num_barang[2] = Integer.parseInt(barang[2]);
        num_barang[3] = Integer.parseInt(barang[3]);
        num_barang[4] = Integer.parseInt(barang[4]);

        Intent intent = new Intent(this, ShowResult.class);
        intent.putExtra("main.KEYBOARD.num", num_barang[0]);
        intent.putExtra("main.MONITOR.num", num_barang[1]);
        intent.putExtra("main.LCD.num", num_barang[2]);
        intent.putExtra("main.CASSING.num", num_barang[3]);
        intent.putExtra("main.CPU.num", num_barang[4]);

        startActivity(intent);

    }
}

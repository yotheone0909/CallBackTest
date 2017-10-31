package splanet.com.callbacktest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button selectOptionBtn = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        selectOptionBtn = (Button) findViewById(R.id.select_option_btn);

        selectOptionBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                OptionDialog optionDialog = new OptionDialog();
                optionDialog.show(getSupportFragmentManager(),
                        OptionDialog.class.getSimpleName());

                optionDialog.setOnSelectListener(new OnSelectListener() {
                    @Override
                    public void onEdit(String msg) {
                        Toast.makeText(MainActivity.this, ""+msg, Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onDelete(String msg) {
                        Toast.makeText(MainActivity.this, ""+msg, Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onCancel(String msg) {
                        Toast.makeText(MainActivity.this, ""+msg, Toast.LENGTH_SHORT).show();
                    }
                });

            }
        });
    }
}

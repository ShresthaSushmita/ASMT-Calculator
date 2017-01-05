package com.example.kanchha.electricalcu;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView textView,result;
    TextView text;
    EditText editText,editText2;
    RadioGroup radio;
    RadioButton rgb;
    CheckBox checkbox;
    Button button;
    int ampere;
    double one, two,third, diff;
    float totalAmount;
    String firstValue,secondValue, amp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        textView=(TextView)findViewById(R.id.textView);
        result=(TextView)findViewById(R.id.textview2);
        text=(TextView)findViewById(R.id.text);
        editText=(EditText)findViewById(R.id.editText);
        editText2=(EditText)findViewById(R.id.editText2);
        radio=(RadioGroup)findViewById(R.id.radio);
        checkbox=(CheckBox)findViewById(R.id.checkbox);
        button=(Button)findViewById(R.id.button);

        radio.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                rgb = (RadioButton)findViewById(checkedId);
                amp = rgb.getText().toString();
                if(amp.matches("5 A"))
                {
                    ampere = 5;
                }else if(amp.matches("15 A")){
                    ampere = 15;
                }
                else if(amp.matches("30 A"))
                {
                    ampere = 30;
                }
                else
                {
                    ampere = 60;
                }

            }
        });

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String a = editText.getText().toString();
                String b = editText2.getText().toString();

                if (a.isEmpty() || b.isEmpty()) {
                    Toast.makeText(getApplicationContext(), "Empty Content", Toast.LENGTH_SHORT).show();
                }

                if (ampere == 0) {
                    Toast.makeText(getApplicationContext(), "Plese select your ampere", Toast.LENGTH_SHORT).show();
                } else {
                    one = Integer.parseInt(a);
                    two = Integer.parseInt(b);
                    diff = two - one;
                    if (ampere == 5) {
                        if (diff <= 20) {
                            totalAmount = 80;
                            result.append("Rs" + totalAmount);
                        }
                        else if ((diff > 20) && (diff <= 31)) {
                            totalAmount = (float) ((20 * 4) + (diff - 20) * 7.30);
                            result.setText("Rs" + totalAmount);
                        } else if ((diff > 31) && (diff <= 50)) {
                            totalAmount = (float) ((diff) * 7.30);
                            result.setText("Rs" + totalAmount);
                        } else if ((diff > 50) && (diff <= 150)) {
                            totalAmount = (float) ((50 * 7.30) + (diff - 50) * 8.60);
                            result.setText("Rs" + totalAmount);
                        } else if ((diff > 150) && (diff <= 250)) {
                            totalAmount = (float) ((150 * 8.60) + (diff - 150) * 9.50);
                            result.setText("Rs" + totalAmount);
                        } else {
                            totalAmount = (float) ((250 * 9.50) + (diff - 250) * 11);
                            result.setText("Rs" + totalAmount);
                        }
                    }
                  else if(ampere ==15){
                        if (diff <=50){
                            totalAmount =356;
                            result.setText("Rs" + totalAmount);
                        }
                        else if ((diff > 50) && (diff <= 150)) {
                            totalAmount = (float) ((50 * 7.30) + (diff - 50) * 8.60);
                            result.setText("Rs" + totalAmount);
                        } else if ((diff > 150) && (diff <= 250)) {
                            totalAmount = (float) ((150 * 8.60) + (diff - 150) * 9.50);
                            result.setText("Rs" + totalAmount);
                        } else {
                            totalAmount = (float) ((250 * 9.50) + (diff - 250) * 11);
                            result.setText("Rs" + totalAmount);
                        }
                    }

                    else if(ampere == 30){
                    if (diff <=100){
                        totalAmount =795;
                        result.setText("Rs" + totalAmount);
                    } else if ((diff > 150) && (diff <= 250)) {
                        totalAmount = (float) ((150 * 8.60) + (diff - 150) * 9.50);
                        result.setText("Rs" + totalAmount);
                    } else {
                        totalAmount = (float) ((250 * 9.50) + (diff - 250) * 11);
                        result.setText("Rs" + totalAmount);
                    }
                }
                else {
                      if(diff <= 200){
                          totalAmount = 1765;
                          result.setText("Rs" + totalAmount);
                      }
                      else if ((diff > 150) && (diff <= 250)) {
                          totalAmount = (float) ((150 * 8.60) + (diff - 150) * 9.50);
                          result.setText("Rs" + totalAmount);
                      } else {
                          totalAmount = (float) ((250 * 9.50) + (diff - 250) * 11);
                          result.setText("Rs" + totalAmount);
                      }
                    }
                }
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}

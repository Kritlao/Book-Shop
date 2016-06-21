package neu.laothongsan.krit.bookshop;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    //Explicit
    private EditText userEditText, passwordEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    } // Main Method

    public void clickSignMain(View view) {
        startActivity(new Intent(MainActivity.this, SignUp2Activity.class));
    }

}  // Main Class นี้คือ คลาสหลัก

package neu.laothongsan.krit.bookshop;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.EditText;

public class SignUp2Activity extends AppCompatActivity {

    //Explicit ประกาศตัวแปร
    private EditText nameEditText, userEditText, passwordEditText;
    private String nameSting, userSting, passwordSting;
    private static final String urlPHP = "http://swiftcodingthai.com/neu/add_user_master.php";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up2);

        //bind Widget
        nameEditText = (EditText) findViewById(R.id.editText);
        userEditText = (EditText) findViewById(R.id.editText2);
        passwordEditText = (EditText) findViewById(R.id.editText3);


    } //Main Method

    public void clicKSignUpSign(View view) {

        nameSting = nameEditText.getText().toString().trim();
        userSting = userEditText.getText().toString().trim();
        passwordSting = passwordEditText.getText().toString().trim();

        //Check Space
        if (nameSting.equals("") || userSting.equals("") || passwordSting.equals("")) {
            //Have Space
            MyAlert myAlert = new MyAlert();
            myAlert.myDialog(this, "มีช่องว่าง","กรุณากรอกทุกช่อง คะ");

        } else {
            // NO Space
            uploadToServer();


        }



    }  // clickSign

    private void uploadToServer() {

    }

}  //Main Class

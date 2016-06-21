package neu.laothongsan.krit.bookshop;

import android.graphics.Paint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.EditText;

import com.squareup.okhttp.Call;
import com.squareup.okhttp.Callback;
import com.squareup.okhttp.FormEncodingBuilder;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.RequestBody;
import com.squareup.okhttp.Response;
import com.squareup.okhttp.internal.http.OkHeaders;

import java.io.IOException;

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

    public void clickSignUpSign(View view) {

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

        OkHttpClient okHttpClient = new OkHttpClient();
        RequestBody requestBody = new FormEncodingBuilder()
                .add("isAdd", "true")
                .add("Name", nameSting)
                .add("User", userSting)
                .add("Password", passwordSting)
                .build();
        Request.Builder builder = new Request.Builder();
        Request request = builder.url(urlPHP).post(requestBody).build();
        Call call = okHttpClient.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Request request, IOException e) {

            }

            @Override
            public void onResponse(Response response) throws IOException {
               finish();
            }
        });


    } //upload

}  //Main Class

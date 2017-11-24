package zimmermann.larissa.elderlyforlife;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends Activity {

    private CardView cardLoginButton;
    private TextView registerButton;
    private EditText passwordText;
    private EditText usernameText;

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cardLoginButton = (CardView)findViewById(R.id.loginButtonID);
        registerButton = (TextView)findViewById(R.id.registerButtonID);
        passwordText = (EditText)findViewById(R.id.passwordTextID);
        usernameText = (EditText)findViewById(R.id.usernameTextID);

        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //TODO open another activity to register
            }
        });

        cardLoginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //TODO send the username and password
            }
        });


    }
}

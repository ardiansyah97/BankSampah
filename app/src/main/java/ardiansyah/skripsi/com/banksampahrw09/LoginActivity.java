package ardiansyah.skripsi.com.banksampahrw09;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import ardiansyah.skripsi.com.banksampahrw09.activity_admin.MainActivity;


public class LoginActivity extends AppCompatActivity{
    Button buttonLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        inisialisasi();

        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
            }
        });
    }

    public void inisialisasi(){
        buttonLogin = (Button)findViewById(R.id.btnLogin);
    }

}


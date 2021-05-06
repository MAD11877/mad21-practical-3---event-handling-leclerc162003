package sg.edu.np.practical2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    User user = new User("hong", "ifhs", 1, false);
    private TextView textBiew;
    private TextView cl;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d("debug", "create");
        this.textBiew = findViewById(R.id.textBiew);
        this.cl = findViewById(R.id.cl);
        User user = new User("hong", "ifhs", 1, false);

        this.setUser(user);


        Button button = (Button) findViewById(R.id.follow);


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //int status = (Integer) v.getTag();
                if (user.followed == true){
                    Context context = getApplicationContext();
                    CharSequence text = "Followed";
                    int duration = Toast.LENGTH_SHORT;
                    Toast.makeText(context, text, duration ).show();

                    button.setText("Unfollow");
                    user.setFollowed(false);
                }
                else{
                    Context context = getApplicationContext();
                    CharSequence text = "Unfollowed";
                    int duration = Toast.LENGTH_SHORT;
                    Toast.makeText(context, text, duration ).show();
                    button.setText("follow");
                    user.setFollowed(true);
                }
            }

        });




    }

    private void setUser(User user){
        this.user = user;
        this.updateUserInfo();

    }

    private void updateUserInfo() {
        Intent receive = getIntent();
        this.textBiew.setText(user.getName() + " " +  receive.getStringExtra("rand"));
        this.cl.setText(user.getDescription());
    }


    @Override
    protected void onStart() {
        super.onStart();
        Log.d("debug", "Start");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("debug", "Stop");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("debug", "Resume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("debug", "Pause");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("debug", "Destroy");
    }


}

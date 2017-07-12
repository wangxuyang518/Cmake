package xinyi.com.cmake;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }



    public void md5(View view){
        Intent intent=new Intent(MainActivity.this,MD5Activity.class);
        startActivity(intent);
    }
}

package testapp.ayannah.jccolumbres.internalstorage;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    TextView output;
    public static final String FILE_NAME = "lorem_ipsum.csv";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        output = findViewById(R.id.outputText);
        output.setText(R.string.ready_to_code);
    }

    public void onCreateButtonClick(View view) {
        String content = getString(R.string.lorem_ipsum);
        FileOutputStream fileOutputStream = null;
        File file = new File(FILE_NAME);

        try {
            fileOutputStream = openFileOutput(FILE_NAME, MODE_PRIVATE);
            fileOutputStream.write(content.getBytes());
            Toast.makeText(this, "File created: " + FILE_NAME, Toast.LENGTH_SHORT).show();
        } catch (IOException e) {
            e.printStackTrace();
            Toast.makeText(this, "Exception: " + e.getMessage(), Toast.LENGTH_SHORT).show();
        } finally {
            try {
                if (fileOutputStream == null){
                    fileOutputStream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    }

    public void onReadButtonClick(View view) {
    }

    public void onDeleteButtonClick(View view) {
        File file = new File(getFilesDir(), FILE_NAME);
        if (file.exists()){
            deleteFile(FILE_NAME);
            Toast.makeText(this, "File deleted", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(this, "File not existing", Toast.LENGTH_SHORT).show();
        }
    }
}

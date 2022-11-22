import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import com.example.app.Credentials;
import com.example.app.DataBase;
import com.example.app.R;
import com.example.app.TitlePage;

public class DeletePopup extends AppCompatActivity {
    Button sure;
    DataBase db;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.delete_account_warning);

        sure = findViewById(R.id.are_you_sure);
        db = new DataBase(this);

        sure.setOnClickListener(view -> {
            Intent intent = new Intent(this, TitlePage.class);
            String x = getIntent().getStringExtra("EMAIL");
            Credentials deleting = new Credentials("NAME", x, "PASSWORD");
            db.deleteOne(deleting);
            startActivity(intent);
        });
    }
}

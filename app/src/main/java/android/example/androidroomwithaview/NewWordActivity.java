package android.example.androidroomwithaview;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class NewWordActivity extends AppCompatActivity {

    public static final String EXTRA_REPLY = "android.example.AndroidRoomWithAView";
    private EditText mEditText;
    Intent replyIntent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_word);

        mEditText = findViewById(R.id.edit_word);

        final Button button = findViewById(R.id.button_save);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                replyIntent = new Intent();
                if (TextUtils.isEmpty(mEditText.getText())) {
                    setResult(RESULT_CANCELED, replyIntent);
                } else {
                    String word = mEditText.getText().toString();
//                    Log.d("NewWordActivity", word.toString());
                    replyIntent.putExtra(EXTRA_REPLY, word);
//                    Log.d("NewWordActivity::getStr", Objects.requireNonNull(replyIntent.getStringExtra(EXTRA_REPLY)));
                    setResult(RESULT_OK, replyIntent);
//                    finishActivity(MainActivity.NEW_WORD_ACTIVITY_REQUEST_CODE);
                }
                finish();
            }
        });
    }
}

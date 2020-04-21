package android.example.androidroomwithaview;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "word_table")
public class Word {

    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "word")
    protected String mWord;

    public Word(@NonNull String mWord) {
        this.mWord = mWord;
    }

    public String getmWord() {
        return this.mWord;
    }
}

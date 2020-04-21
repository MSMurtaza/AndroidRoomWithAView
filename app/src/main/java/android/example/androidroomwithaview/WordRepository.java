package android.example.androidroomwithaview;

import android.app.Application;

import androidx.lifecycle.LiveData;

import java.util.List;

class WordRepository {
    private WordDao mWordDao;
    private LiveData<List<Word>> mAllWords;

    WordRepository(Application application) {
        WordRoomDatabase wordRoomDatabase
                = WordRoomDatabase.getDatabase(application);
        mWordDao = wordRoomDatabase.wordDao();
        mAllWords = mWordDao.getAlphabetizedWords();
    }

    LiveData<List<Word>> getAllWords() {
        return mAllWords;
    }

    void insert(Word word) {
        WordRoomDatabase.databaseWriteExecutor.execute(() -> {
            mWordDao.insert(word);
        });
    }
}

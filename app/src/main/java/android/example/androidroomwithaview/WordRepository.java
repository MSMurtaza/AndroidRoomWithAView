package android.example.androidroomwithaview;

import android.app.Application;

import androidx.lifecycle.LiveData;

import java.util.List;

class WordRepository {
    private final WordDao mWordDao;
    private final LiveData<List<Word>> mAllWords;

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

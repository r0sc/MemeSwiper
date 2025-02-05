package at.rosc.memeswiper.viewmodels;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.ArrayList;

import at.rosc.memeswiper.logic.Meme;

public class ListViewModel extends ViewModel {
    public MutableLiveData<ArrayList<Meme>> observableMemes = new MutableLiveData<>();

    public ListViewModel(ArrayList<Meme> memes) {
        if (!memes.isEmpty()) {
            observableMemes.postValue(memes);;
        }
    }
}

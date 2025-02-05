package at.rosc.memeswiper.viewmodels;

import androidx.lifecycle.ViewModel;

import java.util.ArrayList;
import java.util.List;

import at.rosc.memeswiper.logic.Meme;

public class MemeViewModel extends ViewModel {
    private ArrayList<Meme> memes = new ArrayList<>();
    public void addMeme(Meme meme) {
        memes.add(meme);
    }
    public ArrayList<Meme> getMemes() {
        return memes;
    }
}

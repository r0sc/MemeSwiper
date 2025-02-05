package at.rosc.memeswiper.viewmodels;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class MainViewModel extends ViewModel {
    public static final int START_PAGE = 0;
    public static final int HOW_TO_PLAY_PAGE = 1;

    private MutableLiveData<Integer> _state = new MutableLiveData<>(START_PAGE);
    public LiveData<Integer> state = _state;

    public void setStartPage() {
        _state.postValue(START_PAGE);
    }
    public void setHowToPlayPage() {
        _state.postValue(HOW_TO_PLAY_PAGE);
    }
}

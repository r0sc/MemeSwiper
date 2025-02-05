package at.rosc.memeswiper.viewmodels;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class MainViewModel extends ViewModel {
    public static final int START_PAGE = 0;
    public static final int FAVORITES_PAGE = 1;
    public static final int CREDITS_PAGE = 2;

    private MutableLiveData<Integer> _state = new MutableLiveData<>(START_PAGE);
    public LiveData<Integer> state = _state;

    public void setStartPage() {
        _state.postValue(START_PAGE);
    }
    public void setFavPage() {
        _state.postValue(FAVORITES_PAGE);
    }

    public void setCreditsPage() {
        _state.postValue(CREDITS_PAGE);
    }
}

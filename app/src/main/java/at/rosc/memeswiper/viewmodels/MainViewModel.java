package at.rosc.memeswiper.viewmodels;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class MainViewModel extends ViewModel {
    public static final int START_PAGE = 0;

    private MutableLiveData<Integer> _state = new MutableLiveData<>(START_PAGE);
    public LiveData<Integer> state = _state;

    public void setStartPage() {
        _state.postValue(START_PAGE);
    }
}

package at.rosc.memeswiper.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import at.rosc.memeswiper.R;
import at.rosc.memeswiper.databinding.FragmentHowToPlayBinding;
import at.rosc.memeswiper.viewmodels.MainViewModel;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link HowToPlayFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class HowToPlayFragment extends Fragment {
    FragmentHowToPlayBinding binding;
    public HowToPlayFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentHowToPlayBinding.inflate(inflater, container, false);
        MainViewModel viewModel = new ViewModelProvider(requireActivity()).get(MainViewModel.class);
        binding.topAppBar.getMenu().findItem(R.id.item_htp).setOnMenuItemClickListener(item -> {
            viewModel.setStartPage();
            return false;
        });
        return binding.getRoot();
    }
}
package at.rosc.memeswiper.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import at.rosc.memeswiper.R;
import at.rosc.memeswiper.databinding.FragmentCreditsBinding;
import at.rosc.memeswiper.file.File;
import at.rosc.memeswiper.viewmodels.MainViewModel;
import at.rosc.memeswiper.viewmodels.MemeViewModel;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link CreditsFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class CreditsFragment extends Fragment {
    FragmentCreditsBinding binding;

    public CreditsFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentCreditsBinding.inflate(inflater, container, false);
        MainViewModel viewModel = new ViewModelProvider(requireActivity()).get(MainViewModel.class);
        MemeViewModel memeViewModel = new ViewModelProvider(requireActivity()).get(MemeViewModel.class);
        binding.topAppBar.setOnMenuItemClickListener(item -> {
            if (item.getItemId() == R.id.item_credits) {
                viewModel.setCreditsPage();
                return true;
            } else if (item.getItemId() == R.id.item_fav) {
                viewModel.setFavPage();
                File file = new File();
                file.write(memeViewModel.getMemes(), requireContext());
                return true;
            }
            return false;
        });
        return binding.getRoot();
    }
}
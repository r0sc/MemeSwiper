package at.rosc.memeswiper.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import java.util.ArrayList;

import at.rosc.memeswiper.R;
import at.rosc.memeswiper.api.APIRequester;
import at.rosc.memeswiper.databinding.FragmentStartBinding;
import at.rosc.memeswiper.file.File;
import at.rosc.memeswiper.logic.Meme;
import at.rosc.memeswiper.viewmodels.MainViewModel;
import at.rosc.memeswiper.viewmodels.MemeViewModel;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link StartFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class StartFragment extends Fragment {
    FragmentStartBinding binding;

    public StartFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentStartBinding.inflate(inflater, container, false);
        MainViewModel viewModel = new ViewModelProvider(requireActivity()).get(MainViewModel.class);
        MemeViewModel memeViewModel = new ViewModelProvider(requireActivity()).get(MemeViewModel.class);
        APIRequester requester = new APIRequester();
        requester.loadMeme(getContext(), requireActivity(), binding.imageView);
        memeViewModel.setMemeEmpty();
        File file = new File();
        if (!file.read(requireContext(),requireActivity()).isEmpty()) {
            memeViewModel.setMemes(file.read(requireContext(),requireActivity()));
        }
        binding.btnAss.setOnClickListener(view -> {
            requester.loadMemeDisableButton(getContext(), requireActivity(), binding.imageView,new Button[]{binding.btnAss,binding.btnFire});
        });
        binding.btnFire.setOnClickListener(view -> {
            requester.loadMemeDisableButtonLike(getContext(), requireActivity(), binding.imageView,new Button[]{binding.btnAss,binding.btnFire});
        });
        binding.topAppBar.setOnMenuItemClickListener(item -> {
            if (item.getItemId() == R.id.item_credits) {
                viewModel.setCreditsPage();
                return true;
            } else if (item.getItemId() == R.id.item_fav) {
                viewModel.setFavPage();
                if (!memeViewModel.getMemes().isEmpty()) {
                    file.write(memeViewModel.getMemes(), requireContext());
                }
                return true;
            }
            return false;
        });
        return binding.getRoot();
    }
}

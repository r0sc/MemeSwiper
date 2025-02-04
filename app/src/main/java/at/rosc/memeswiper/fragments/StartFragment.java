package at.rosc.memeswiper.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import at.rosc.memeswiper.R;
import at.rosc.memeswiper.api.APIRequester;
import at.rosc.memeswiper.databinding.FragmentStartBinding;

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
        APIRequester requester = new APIRequester();
        requester.loadMeme(getContext(),binding.imageView);
        binding.btnAss.setOnClickListener(view -> {
            requester.loadMeme(getContext(),binding.imageView);
        });
        binding.btnFire.setOnClickListener(view -> {
            requester.loadMeme(getContext(),binding.imageView);
        });
        return binding.getRoot();
    }
}
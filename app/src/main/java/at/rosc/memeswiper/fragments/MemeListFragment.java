package at.rosc.memeswiper.fragments;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.material.appbar.MaterialToolbar;

import at.rosc.memeswiper.R;
import at.rosc.memeswiper.file.File;
import at.rosc.memeswiper.viewmodels.ListViewModel;
import at.rosc.memeswiper.viewmodels.MainViewModel;
import at.rosc.memeswiper.viewmodels.MemeViewModel;

/**
 * A fragment representing a list of Items.
 */
public class MemeListFragment extends Fragment {
    // TODO: Customize parameter argument names
    private static final String ARG_COLUMN_COUNT = "column-count";
    // TODO: Customize parameters
    private int mColumnCount = 1;

    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public MemeListFragment() {
    }

    // TODO: Customize parameter initialization
    @SuppressWarnings("unused")
    public static MemeListFragment newInstance(int columnCount) {
        MemeListFragment fragment = new MemeListFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_COLUMN_COUNT, columnCount);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments() != null) {
            mColumnCount = getArguments().getInt(ARG_COLUMN_COUNT);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_meme_list_list, container, false);
        View listView = view.findViewById(R.id.list);
        File file = new File();
        ListViewModel viewModel = new ListViewModel(file.read(requireContext(),requireActivity()));
        MainViewModel mainViewModel = new ViewModelProvider(requireActivity()).get(MainViewModel.class);
        MemeViewModel memeViewModel = new ViewModelProvider(requireActivity()).get(MemeViewModel.class);
        MaterialToolbar toolbar = view.findViewById(R.id.topAppBar);
        toolbar.setOnMenuItemClickListener(item -> {
            if (item.getItemId() == R.id.item_credits) {
                mainViewModel.setCreditsPage();
                return true;
            } else if (item.getItemId() == R.id.item_fav) {
                mainViewModel.setFavPage();
                if (!memeViewModel.getMemes().isEmpty()) {
                    file.write(memeViewModel.getMemes(), requireContext());
                }
                return true;
            }
            return false;
        });

        // Set the adapter
        if (listView instanceof RecyclerView) {
            Context context = listView.getContext();
            RecyclerView recyclerView = (RecyclerView) listView;
            if (mColumnCount <= 1) {
                recyclerView.setLayoutManager(new LinearLayoutManager(context));
            } else {
                recyclerView.setLayoutManager(new GridLayoutManager(context, mColumnCount));
            }
            viewModel.observableMemes.observe(getViewLifecycleOwner(), memes -> {
                recyclerView.setAdapter(new MyMemeRecyclerViewAdapter(memes));
            });
        }
        return view;
    }
}
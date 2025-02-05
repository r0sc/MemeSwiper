package at.rosc.memeswiper.fragments;

import static androidx.core.content.ContextCompat.startActivity;

import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import at.rosc.memeswiper.databinding.FragmentMemeListBinding;
import at.rosc.memeswiper.logic.Meme;

import java.util.List;

/**
 * {@link RecyclerView.Adapter} that can display a {@link PlaceholderItem}.
 * TODO: Replace the implementation with code for your data type.
 */
public class MyMemeRecyclerViewAdapter extends RecyclerView.Adapter<MyMemeRecyclerViewAdapter.ViewHolder> {

    private final List<Meme> mValues;

    public MyMemeRecyclerViewAdapter(List<Meme> items) {
        mValues = items;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        return new ViewHolder(FragmentMemeListBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false));

    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.meme = mValues.get(position);
        holder.tvTitle.setText(mValues.get(position).getTitle());
        Glide.with(holder.ivMeme.getContext()).load(mValues.get(position).getUrl()).into(holder.ivMeme);
    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final TextView tvTitle;
        public final ImageView ivMeme;
        public final ImageView ivShare;
        public Meme meme;

        public ViewHolder(FragmentMemeListBinding binding) {
            super(binding.getRoot());
            tvTitle = binding.tvTitleMeme;
            ivMeme = binding.ivMeme;
            ivShare = binding.ivShare;
            this.ivShare.setOnClickListener(view -> {
                Intent i = new Intent(Intent.ACTION_SEND);
                i.setType("text/plain");
                i.putExtra(Intent.EXTRA_SUBJECT, "Sharing Meme");
                i.putExtra(Intent.EXTRA_TEXT, meme.getUrl());
                view.getContext().startActivity(Intent.createChooser(i, "Share Meme"));
            });
        }

        @Override
        public String toString() {
            return super.toString() + " ";
        }
    }
}
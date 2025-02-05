package at.rosc.memeswiper.file;

import android.content.Context;

import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;
import java.util.List;

import at.rosc.memeswiper.logic.Meme;
import at.rosc.memeswiper.viewmodels.MemeViewModel;

public class File {
    private static final Gson gson = new Gson();
    public ArrayList<Meme> read(Context context, ViewModelStoreOwner owner) {
        MemeViewModel memeViewModel = new ViewModelProvider(owner).get(MemeViewModel.class);
        List<Meme> deineObjekteList = memeViewModel.getMemes();
        String jsonString = IOHandler.read(context);
        TypeToken<List<Meme>> listTypeToken = new TypeToken<List<Meme>>() {};
        if(jsonString == null){
            return new ArrayList<>();
        }else{
            return gson.fromJson(jsonString, listTypeToken.getType());
        }
    }
    public void write(ArrayList<Meme> memes, Context context) {
        String jsonString = gson.toJson(memes);
        IOHandler.write(context, jsonString);
    }
}

package at.rosc.memeswiper.api;

import android.content.Context;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.bumptech.glide.Glide;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import at.rosc.memeswiper.logic.Meme;
import at.rosc.memeswiper.viewmodels.MemeViewModel;

public class APIRequester {
    public void loadMeme(Context context, ViewModelStoreOwner owner, ImageView imageView) {
        String url = "https://meme-api.com/gimme";
        RequestQueue requestQueue = Volley.newRequestQueue(context);
        MemeViewModel viewModel = new ViewModelProvider(owner).get(MemeViewModel.class);
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                String url = "";
                try {
                    url = response.getString("url");
                    viewModel.addMeme(new Meme(url, response.getString("title")));
                    Glide.with(context).load(url).into(imageView);
                } catch (JSONException e) {
                    throw new RuntimeException(e);
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(context, "Error: " + error.getMessage(), Toast.LENGTH_LONG).show();
            }
        });
        requestQueue.add(jsonObjectRequest);

    }
}

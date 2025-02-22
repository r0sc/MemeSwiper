package at.rosc.memeswiper;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.lifecycle.ViewModelProvider;
import androidx.fragment.app.FragmentTransaction;

import at.rosc.memeswiper.fragments.CreditsFragment;
import at.rosc.memeswiper.fragments.MemeListFragment;
import at.rosc.memeswiper.fragments.StartFragment;
import at.rosc.memeswiper.viewmodels.MainViewModel;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        MainViewModel viewModel = new ViewModelProvider(this).get(MainViewModel.class);
        viewModel.state.observe(this, state -> {
            FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
            switch (state) {
                case MainViewModel.START_PAGE:
                    fragmentTransaction.replace(R.id.main,new StartFragment()).addToBackStack("START");
                    break;
                case MainViewModel.CREDITS_PAGE:
                    fragmentTransaction.replace(R.id.main,new CreditsFragment()).addToBackStack("CREDITS");
                    break;
                case MainViewModel.FAVORITES_PAGE:
                    fragmentTransaction.replace(R.id.main,new MemeListFragment()).addToBackStack("FAVORITES");
                    break;
            }
            fragmentTransaction.commit();
        });
    }
}
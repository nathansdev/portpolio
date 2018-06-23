package nathansdev.github.com.sabarinathan.splash;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import nathansdev.github.com.sabarinathan.R;

public class IntroSplashFragment extends Fragment {
    public static IntroSplashFragment newInstance() {
        return new IntroSplashFragment();
    }

    @BindView(R.id.splash_profile_logo)
    ImageView logo;
    @BindView(R.id.splash_profile_name)
    TextView text;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.intro_splash_layout, container, false);
        ButterKnife.bind(this, view);
        return view;
    }
}

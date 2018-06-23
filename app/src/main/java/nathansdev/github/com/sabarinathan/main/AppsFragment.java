package nathansdev.github.com.sabarinathan.main;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import nathansdev.github.com.sabarinathan.R;

public class AppsFragment extends Fragment {
    public static AppsFragment newInstance() {
        return new AppsFragment();
    }

    @BindView(R.id.intro_profile_logo)
    ImageView logo;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.intro_layout, container, false);
        ButterKnife.bind(this, view);
        return view;
    }
}

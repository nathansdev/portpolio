package nathansdev.github.com.sabarinathan.main;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import butterknife.BindView;
import butterknife.ButterKnife;
import nathansdev.github.com.sabarinathan.R;
import nathansdev.github.com.sabarinathan.Utils;

public class ProfileFragment extends Fragment implements View.OnClickListener {
    public static ProfileFragment newInstance() {
        return new ProfileFragment();
    }

    @BindView(R.id.intro_profile_logo)
    ImageView logo;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.profilefragment, container, false);
        ButterKnife.bind(this, view);
        setUpViews();
        return view;
    }

    private void setUpViews() {
        Utils.loadRoundImage(logo.getContext(), logo);
    }

    @Override
    public void onClick(View view) {

    }
}

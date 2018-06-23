package nathansdev.github.com.sabarinathan.splash;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;

import butterknife.BindView;
import butterknife.ButterKnife;
import nathansdev.github.com.sabarinathan.R;
import nathansdev.github.com.sabarinathan.main.MainActivity;

public class IntroFragment extends Fragment {
    public static IntroFragment newInstance() {
        return new IntroFragment();
    }

    @BindView(R.id.intro_profile_logo)
    ImageView logo;
    @BindView(R.id.intro_next)
    ImageButton next;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.intro_layout, container, false);
        ButterKnife.bind(this, view);
        setUpViews();
        return view;
    }

    private void setUpViews() {
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gotoMain();
            }
        });
    }

    private void gotoMain() {
        Intent intent = new Intent(getActivity(), MainActivity.class);
        startActivity(intent);
    }
}

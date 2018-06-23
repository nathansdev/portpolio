package nathansdev.github.com.sabarinathan.main;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import nathansdev.github.com.sabarinathan.R;

public class MainFragment extends Fragment implements View.OnClickListener {
    private OnFragmentClickListener onFragmentCloseClickListener;

    public static MainFragment newInstance() {
        return new MainFragment();
    }

    @BindView(R.id.profile)
    TextView profile;
    @BindView(R.id.experience)
    TextView experience;
    @BindView(R.id.apps)
    TextView apps;
    @BindView(R.id.contact)
    TextView contact;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.main_fragment, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    // in onAttach we must instantiate the listener
    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            onFragmentCloseClickListener = (OnFragmentClickListener) activity;
        } catch (ClassCastException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }

    @Override
    public void onClick(View view) {
        onFragmentCloseClickListener.onFragmentOpen(view);
    }
}

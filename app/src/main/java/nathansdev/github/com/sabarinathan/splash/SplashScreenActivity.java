package nathansdev.github.com.sabarinathan.splash;

import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.transition.Fade;
import android.transition.TransitionInflater;
import android.transition.TransitionSet;
import android.view.View;

import butterknife.ButterKnife;
import nathansdev.github.com.sabarinathan.Constants;
import nathansdev.github.com.sabarinathan.R;

public class SplashScreenActivity extends AppCompatActivity {

    private Handler mDelayedTransactionHandler = new Handler();
    private Runnable mRunnable = new Runnable() {
        @Override
        public void run() {
            doTransition();
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        ButterKnife.bind(this);
        addInitialFragment();
        mDelayedTransactionHandler.postDelayed(mRunnable, 1000);
    }

    private void addInitialFragment() {
        Fragment initialFragment = IntroSplashFragment.newInstance();
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.fragment_container, initialFragment);
        fragmentTransaction.commit();
    }

    private void doTransition() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1) {
            if (isDestroyed()) {
                return;
            }
        }
        Fragment introSplashFragment = getSupportFragmentManager().findFragmentById(R.id.fragment_container);
        Fragment introFragment = IntroFragment.newInstance();

        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();

        // 1. Exit for Previous Fragment
        Fade exitFade = new Fade();
        exitFade.setDuration(Constants.FADE_DEFAULT_TIME);
        introSplashFragment.setExitTransition(exitFade);

        // 2. Shared Elements Transition
        TransitionSet enterTransitionSet = new TransitionSet();
        enterTransitionSet.addTransition(TransitionInflater.from(this).inflateTransition(android.R.transition.move));
        enterTransitionSet.setDuration(Constants.MOVE_DEFAULT_TIME);
        enterTransitionSet.setStartDelay(Constants.FADE_DEFAULT_TIME);
        introFragment.setSharedElementEnterTransition(enterTransitionSet);

        // 3. Enter Transition for New Fragment
        Fade enterFade = new Fade();
        enterFade.setStartDelay(Constants.MOVE_DEFAULT_TIME + Constants.FADE_DEFAULT_TIME);
        enterFade.setDuration(Constants.FADE_DEFAULT_TIME);
        introFragment.setEnterTransition(enterFade);
        View logo = ButterKnife.findById(this, R.id.splash_profile_logo);
//        View name = ButterKnife.findById(this, R.id.splash_profile_name);
        fragmentTransaction.addSharedElement(logo, logo.getTransitionName());
//        fragmentTransaction.addSharedElement(name, name.getTransitionName());
        fragmentTransaction.replace(R.id.fragment_container, introFragment);
        fragmentTransaction.commitAllowingStateLoss();
    }
}

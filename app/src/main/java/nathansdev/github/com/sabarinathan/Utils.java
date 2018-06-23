package nathansdev.github.com.sabarinathan;

import android.content.Context;
import android.graphics.Bitmap;
import android.support.v4.graphics.drawable.RoundedBitmapDrawable;
import android.support.v4.graphics.drawable.RoundedBitmapDrawableFactory;
import android.widget.ImageView;

import com.bumptech.glide.request.target.BitmapImageViewTarget;

public final class Utils {
    /**
     * Load round image into image view.
     *
     * @param context ui context.
     * @param iv      image view.
     */
    public static void loadRoundImage(final Context context, final ImageView iv) {
        GlideApp.with(context)
                .asBitmap()
                .load(R.drawable.bg_rounded_button)
                .centerCrop()
                .placeholder(R.drawable.bg_rounded_button)
                .error(R.drawable.bg_rounded_button)
                .into(new BitmapImageViewTarget(iv) {
                    @Override
                    protected void setResource(Bitmap resource) {
                        RoundedBitmapDrawable circularBitmapDrawable =
                                RoundedBitmapDrawableFactory.create(context.getResources(), resource);
                        circularBitmapDrawable.setCircular(true);
                        iv.setImageDrawable(circularBitmapDrawable);
                    }
                });
    }
}

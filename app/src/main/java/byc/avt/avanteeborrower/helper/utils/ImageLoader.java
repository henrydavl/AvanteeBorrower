package byc.avt.avanteeborrower.helper.utils;

import android.widget.ImageView;

import com.bumptech.glide.Glide;

import byc.avt.avanteeborrower.helper.constants.Constant;

public class ImageLoader {

    public static void loadImage(ImageView imageView, String imageUrl) {
        Glide.with(imageView.getContext())
                .load(Constant.BaseSetting.IMG_URL + imageUrl)
                .into(imageView);
    }

}

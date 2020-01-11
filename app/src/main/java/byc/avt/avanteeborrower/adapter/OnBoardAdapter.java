package byc.avt.avanteeborrower.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import java.util.Objects;

import byc.avt.avanteeborrower.R;

public class OnBoardAdapter extends PagerAdapter {

    private Context context;
    private String[] board_heading, board_desc;

    public OnBoardAdapter(Context context) {
        this.context = context;
        board_heading = context.getResources().getStringArray(R.array.onboard_heading);
        board_desc = context.getResources().getStringArray(R.array.onboard_content);
    }

    private int[] board_images = {
            R.drawable.ic_walkthough1,
            R.drawable.ic_walkthough2,
            R.drawable.ic_walkthough3,
            R.drawable.ic_walkthough4,
            R.drawable.ic_walkthough5
    };

    @Override
    public int getCount() {
        return board_heading.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = Objects.requireNonNull(layoutInflater).inflate(R.layout.onboarding_item,container, false);

        ImageView obImage = view.findViewById(R.id.ob_image);
        TextView obTitle = view.findViewById(R.id.ob_title);
        TextView obDesc = view.findViewById(R.id.ob_desc);

        obImage.setImageResource(board_images[position]);
        obTitle.setText(board_heading[position]);
        obDesc.setText(board_desc[position]);

        container.addView(view);

        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View) object);
    }
}

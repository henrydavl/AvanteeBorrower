package byc.avt.avanteeborrower.view.onboarding;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import java.util.Objects;

import byc.avt.avanteeborrower.R;
import byc.avt.avanteeborrower.view.auth.login.LoginActivity;
import byc.avt.avanteeborrower.view.auth.register.RegisterActivity;
import byc.avt.avanteeborrower.view.main.MainActivity;

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
            R.drawable.ic_illustlogin,
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
        Button btnReg = view.findViewById(R.id.ob_btn_reg);
        Button btnLog = view.findViewById(R.id.ob_btn_log);

        obImage.setImageResource(board_images[position]);
        obTitle.setText(board_heading[position]);

        if (board_desc[position].equals("")){
            obDesc.setVisibility(View.GONE);
            btnReg.setVisibility(View.VISIBLE);
            btnLog.setVisibility(View.VISIBLE);
        } else {
            obDesc.setText(board_desc[position]);
            btnReg.setVisibility(View.GONE);
            btnLog.setVisibility(View.GONE);
        }

        btnReg.setOnClickListener(view12 -> {
            Intent intent = new Intent(context, MainActivity.class);
            context.startActivity(intent);
        });

        btnLog.setOnClickListener(view1 -> {
            Intent intent = new Intent(context, LoginActivity.class);
            context.startActivity(intent);
        });
        container.addView(view);
        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View) object);
    }
}

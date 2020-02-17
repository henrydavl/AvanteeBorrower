package byc.avt.avanteeborrower.view.fragment;


import android.graphics.Color;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.material.tabs.TabLayout;

import byc.avt.avanteeborrower.R;
import byc.avt.avanteeborrower.adapter.ViewPagerAdapter;
import byc.avt.avanteeborrower.view.fragment.notification.InfoFragment;
import byc.avt.avanteeborrower.view.fragment.notification.MessageFragment;

/**
 * A simple {@link Fragment} subclass.
 */
public class NotificationFragment extends Fragment {


    public NotificationFragment() {

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_notification, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        TabLayout tabLayout = view.findViewById(R.id.tab_notification);
        ViewPager nViewPager = view.findViewById(R.id.notification_viewpager);
        ViewPagerAdapter adapter = new ViewPagerAdapter(getChildFragmentManager());
        adapter.addFragment(new MessageFragment(), getString(R.string.message));
        adapter.addFragment(new InfoFragment(), getString(R.string.information));
        nViewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(nViewPager);
        tabLayout.setSelectedTabIndicatorColor(Color.parseColor("#374553"));
        tabLayout.setSelectedTabIndicatorHeight((int) (1.5 * getResources().getDisplayMetrics().density));
        tabLayout.setTabTextColors(Color.parseColor("#959ca3"), Color.parseColor("#374553"));
    }
}

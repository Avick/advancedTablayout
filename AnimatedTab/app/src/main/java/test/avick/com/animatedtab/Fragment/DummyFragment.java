package test.avick.com.animatedtab.Fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import test.avick.com.animatedtab.R;

/**
 * Created by avick on 11/23/16.
 */

public class DummyFragment extends Fragment {

    public static final String PAGE_LABEL = "page_no";
    int position;
    LinearLayout layout, backgroundLayout;

    public static DummyFragment newInstance(int position) {
        DummyFragment frag = new DummyFragment();
        Bundle bundle = new Bundle();
        bundle.putInt(PAGE_LABEL, position);
        frag.setArguments(bundle);
        return frag;
    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(getArguments() != null) {
            position = getArguments().getInt(PAGE_LABEL);
        }

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.dummy_fragment_layout, container, false);
        layout = (LinearLayout) view.findViewById(R.id.layout);
        backgroundLayout = (LinearLayout) view.findViewById(R.id.layout_background);
        int colorId = getResources().getColor(android.R.color.white);
        int backgroundColorId = getResources().getColor(android.R.color.white);
        switch (position) {
            case 0 :
                colorId = getResources().getColor(R.color.camel_color);
                backgroundColorId = getResources().getColor(R.color.camel_color);
                break;
            case 1:
                colorId = getResources().getColor(R.color.red_color_87);
                break;
            case 2:
                colorId = getResources().getColor(R.color.algae_green_color);
                backgroundColorId = getResources().getColor(R.color.gray_20_percent);
                break;
            case 3:
                colorId = getResources().getColor(R.color.colorPrimary);
                backgroundColorId = getResources().getColor(R.color.colorPrimary);

        }

        layout.setBackgroundColor(colorId);
        backgroundLayout.setBackgroundColor(backgroundColorId);
        return view;//super.onCreateView(inflater, container, savedInstanceState);
    }
}

package x.fjr.productrec.category;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;

import org.greenrobot.eventbus.EventBus;

import java.util.ArrayList;

import x.fjr.productrec.GridItemMessageEvent;
import x.fjr.productrec.R;

/**
 * Created by franky.wijanarko on 05/03/18.
 */

public class CategoryFragment extends Fragment {
    public static CategoryFragment newInstance(Bundle bundle) {
        CategoryFragment fragment = new CategoryFragment();
        fragment.setArguments(bundle);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.grid_layout, container, false);
        GridView gridView = view.findViewById(R.id.gridview);

        final ArrayList<CategoryApp> categoryApps = getArguments().getParcelableArrayList("category");

        CategoryGridAdapter adapter = new CategoryGridAdapter(getContext(), categoryApps);
        gridView.setAdapter(adapter);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                CategoryApp categoryApp = categoryApps.get(i);
                Log.i("TAG", "category name ="+categoryApp.categoryName);
                EventBus.getDefault().post(new GridItemMessageEvent(categoryApp));
            }
        });
        return view;
    }
}

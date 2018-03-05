package x.fjr.productrec;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.ArrayList;

import x.fjr.productrec.category.CategoryApp;
import x.fjr.productrec.category.CategoryFragment;

/**
 * Created by franky.wijanarko on 05/03/18.
 */

public class ViewPagingAdapter extends FragmentStatePagerAdapter {

    ArrayList<ArrayList<CategoryApp>> pagingCategoryApps = new ArrayList<>();

    public ViewPagingAdapter(FragmentManager fm, ArrayList<ArrayList<CategoryApp>> pagingCategoryApps) {
        super(fm);
        this.pagingCategoryApps = pagingCategoryApps;
    }

    @Override
    public Fragment getItem(int position) {
        Bundle bundle = new Bundle();
        bundle.putParcelableArrayList("category", pagingCategoryApps.get(position));
        CategoryFragment fragment = CategoryFragment.newInstance(bundle);
        return fragment;
    }

    @Override
    public int getCount() {
        return pagingCategoryApps.size();
    }
}

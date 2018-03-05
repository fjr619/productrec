package x.fjr.productrec.category;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import x.fjr.productrec.R;
import x.fjr.productrec.app.App;

/**
 * Created by franky.wijanarko on 05/03/18.
 */

public class CategoryGridAdapter extends BaseAdapter {

    ArrayList<CategoryApp> categoryApps = new ArrayList<>();
    Context context;
    LayoutInflater inflater;

    public CategoryGridAdapter(Context context, ArrayList<CategoryApp> categoryApps) {
        this.categoryApps = categoryApps;
        this.context = context;
        inflater = (LayoutInflater) this.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return categoryApps.size();
    }

    @Override
    public Object getItem(int i) {
        return categoryApps.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        CategoryApp categoryApp = (CategoryApp) getItem(i);

        if (view == null) {
            view = inflater.inflate(R.layout.grid_item, null);
        }

        TextView textView = view.findViewById(R.id.textView);
        textView.setText(categoryApp.categoryName);

        return view;
    }
}

package x.fjr.productrec.category;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;

import x.fjr.productrec.app.App;

/**
 * Created by franky.wijanarko on 05/03/18.
 */

public class CategoryApp implements Parcelable {

    public String categoryName;
    public ArrayList<App> appList = new ArrayList<>();

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.categoryName);
        dest.writeList(this.appList);
    }

    public CategoryApp() {
    }

    protected CategoryApp(Parcel in) {
        this.categoryName = in.readString();
        this.appList = new ArrayList<App>();
        in.readList(this.appList, App.class.getClassLoader());
    }

    public static final Parcelable.Creator<CategoryApp> CREATOR = new Parcelable.Creator<CategoryApp>() {
        @Override
        public CategoryApp createFromParcel(Parcel source) {
            return new CategoryApp(source);
        }

        @Override
        public CategoryApp[] newArray(int size) {
            return new CategoryApp[size];
        }
    };
}

package x.fjr.productrec;

import x.fjr.productrec.category.CategoryApp;

/**
 * Created by franky.wijanarko on 05/03/18.
 */

public class GridItemMessageEvent {

    public CategoryApp categoryApp;

    public GridItemMessageEvent(CategoryApp categoryApp) {
        this.categoryApp = categoryApp;
    }
}

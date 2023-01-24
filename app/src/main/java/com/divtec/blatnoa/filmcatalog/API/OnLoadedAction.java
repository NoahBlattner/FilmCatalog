package com.divtec.blatnoa.filmcatalog.API;

import java.util.ArrayList;

public interface OnLoadedAction {
    void onLoaded(Object result);

    void onLoaded(String result);

    void onLoaded(int result);
}

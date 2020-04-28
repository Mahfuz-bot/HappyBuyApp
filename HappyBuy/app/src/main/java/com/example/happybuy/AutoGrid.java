package com.example.happybuy;

import android.content.Context;
import android.util.DisplayMetrics;

public class AutoGrid {
    public static int calculateNoOfColumns(Context context) {
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        float dpWidth = displayMetrics.widthPixels / displayMetrics.density;
        int noOfColumns = (int) (dpWidth / 105);
        // Where 180 is the width of your grid item. You can change it as per your convention.
        return noOfColumns;
    }
}

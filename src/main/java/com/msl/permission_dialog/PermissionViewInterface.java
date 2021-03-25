package com.msl.permission_dialog;

import android.graphics.Typeface;
import android.view.View;

public interface PermissionViewInterface {
    void prepareView();
    void setHeaderText(String headerText);
    void setSubHeaderText(String subHeaderText);
    void setNoteText(String noteText);
    void setRightBtnText(String rightBtnText);
    void setLeftBtnText(String leftBtnText);
    void setHeaderTextSize(int size);
    void setHeaderTextTypeFace(Typeface typeFace);
    void setHeaderTextColor(int color);
    void setHeaderBackgroundColor(int color);
    void setViewBackgroundColor(int color);
    void setPadding(int left, int top, int right, int bottom);
    void setTextSize(int size);
    void setTextTypeFace(Typeface typeFace);
    void setTextColor(int color);
    void setButtonTextSize(int size);
    void setButtonTextTypeFace(Typeface typeFace);
    void setButtonTextColor(int color);
    void setButtonBackgroundColor(int color);
    void setLeftBtnVisibility(int visibility);
    void setNoteTextSize(int textSize);
    void addPermissionDescriptiveLayout(View view);
    int getViewCountOfDescriptiveLayout();
    void removeAllViewOfDescriptiveLayout();
    void setUnderlineViewOfHeaderBackgroundColor(int color);
    void setUnderlineViewOfHeaderBackgroundVisibility(int visibility);

}


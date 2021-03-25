package com.msl.permission_dialog.permissiondiscriptiv;

import android.graphics.Typeface;

public interface PermissionDescriptiveViewInterface {
    void prepareView();
    void setPermissionName(String permissionName);
    void setPermissionDescription(String description);
    void setDrawableImageResId(int resId);
    void setPermissionNameTextSize(int textSize);
    void setPermissionNameTextColor(int color);
    void setBackgroundColor(int color);
    void setPermissionNameTypeFace(Typeface typeFace);
    void setPermissionDescriptionTextSize(int textSize);
    void setPermissionDescriptionTextColor(int color);
    void setPermissionDescriptionTypeFace(Typeface typeFace);
}

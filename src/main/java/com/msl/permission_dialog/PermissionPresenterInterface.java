package com.msl.permission_dialog;

import android.view.View;

public interface PermissionPresenterInterface {
    void onCreateView(PermissionViewDataModel permissionViewDataModel);
    View getPermissionView();
    void showDialog();
    void dismissDialog();
    void showNoteText(int visibility);
    void onDestroy();
    void onLeftBtnVisibility(int visibility);
    void onRightBtnClicked();
    void onLeftBtnClicked();
    public interface PermissionListener{
        void onRightBtnClicked();
        void onLeftBtnClicked();
    }
}

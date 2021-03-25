package com.msl.permission_dialog.permissiondiscriptiv;

import android.view.View;

public interface PermissionDescriptivePresenterInterface {
    void createView(PermissionDescriptiveDataModel permissionDescriptiveDataModel);
    View getView();
}

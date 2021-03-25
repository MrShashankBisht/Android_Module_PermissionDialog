package com.msl.permission_dialog;

import com.msl.permission_dialog.permissiondiscriptiv.PermissionDescriptiveDataModel;

import java.util.ArrayList;

public class PermissionViewDataModel {


    private String headerText;
    private String subHeaderText;
    private String noteText;
    private String rightBtnText;
    private String leftBtnText;
    private ArrayList<PermissionDescriptiveDataModel> permissionTypeDataArrayList;

    public String getHeaderText() {
        return headerText;
    }

    public void setHeaderText(String headerText) {
        this.headerText = headerText;
    }

    public String getSubHeaderText() {
        return subHeaderText;
    }

    public void setSubHeaderText(String subHeaderText) {
        this.subHeaderText = subHeaderText;
    }

    public String getNoteText() {
        return noteText;
    }

    public void setNoteText(String noteText) {
        this.noteText = noteText;
    }

    public String getRightBtnText() {
        return rightBtnText;
    }

    public void setRightBtnText(String rightBtnText) {
        this.rightBtnText = rightBtnText;
    }

    public String getLeftBtnText() {
        return leftBtnText;
    }

    public void setLeftBtnText(String leftBtnText) {
        this.leftBtnText = leftBtnText;
    }

    public ArrayList<PermissionDescriptiveDataModel> getPermissionTypeDataArrayList() {
        return permissionTypeDataArrayList;
    }

    public void setPermissionTypeDataArrayList(ArrayList<PermissionDescriptiveDataModel> permissionTypeDataArrayList) {
        this.permissionTypeDataArrayList = permissionTypeDataArrayList;
    }
}

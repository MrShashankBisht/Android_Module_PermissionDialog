package com.msl.permission_dialog;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.view.View;
import android.view.ViewGroup;

import com.msl.permission_dialog.permissiondiscriptiv.PermissionDescriptiveDataModel;
import com.msl.permission_dialog.permissiondiscriptiv.PermissionDescriptivePresenterImpl;
import com.msl.permission_dialog.permissiondiscriptiv.PermissionDescriptivePresenterInterface;

import java.lang.ref.WeakReference;

public class PermissionPresenterImpl implements PermissionPresenterInterface {

//    weak Reference
    WeakReference<Context> contextWeakReference;
    WeakReference<PermissionListener> permissionListenerWeakReference;
//    strong reference of views
    PermissionViewInterface permissionViewInterface;
    Dialog dialog;

    private int textSize;
    private String textFontFaceName;
    private int permissionDescriptiveSubTextSize;
    private int textColor;
    private int permissionDescriptiveBackgroundColor;

    public PermissionPresenterImpl(Builder builder) {
        if(builder.context == null){
            throw new RuntimeException("Context cannot Be Null !!");
        }
        if(builder.permissionListener == null){
            throw new RuntimeException("PermissionListener Cannot Be Null");
        }

        contextWeakReference = new WeakReference<>(builder.context);
        permissionListenerWeakReference = new WeakReference<>(builder.permissionListener);

        permissionViewInterface = new PermissionViewImpl(contextWeakReference.get(),this);

//        setting Properties

        permissionViewInterface.setViewBackgroundColor(builder.backgroundColor);
        permissionViewInterface.setButtonTextColor(builder.buttonTextColor);
        permissionViewInterface.setButtonTextSize(builder.buttonTextSize);
        permissionViewInterface.setButtonBackgroundColor(builder.buttonBackgroundColor);

        this.textColor = builder.textColor;
        this.textSize = builder.textSize;
        this.textFontFaceName = builder.textFontFaceName;
        this.permissionDescriptiveSubTextSize = builder.permissionDescriptiveSubTextSize;
        this.permissionDescriptiveBackgroundColor = builder.permissionDescriptiveBackgroundColor;

        if(builder.textFontFaceName != null && !builder.textFontFaceName.equals("")){
            Typeface typeface = Typeface.createFromAsset(contextWeakReference.get().getResources().getAssets(),builder.textFontFaceName);
            permissionViewInterface.setButtonTextTypeFace(typeface);
            permissionViewInterface.setTextTypeFace(typeface);
        }

        if(builder.headerTextFontFaceName != null && !builder.headerTextFontFaceName.equals("")){
            Typeface typeface = Typeface.createFromAsset(contextWeakReference.get().getResources().getAssets(),builder.headerTextFontFaceName);
            permissionViewInterface.setHeaderTextTypeFace(typeface);
        }

        permissionViewInterface.setHeaderTextColor(builder.headerTextColor);
        permissionViewInterface.setHeaderTextSize(builder.headerTextSize);
        permissionViewInterface.setHeaderBackgroundColor(builder.headerBackgroundColor);

        permissionViewInterface.setTextColor(builder.textColor);
        permissionViewInterface.setTextSize(builder.textSize);

        permissionViewInterface.setNoteTextSize(builder.noteTextSize);
        permissionViewInterface.setPadding(builder.padding_left, builder.padding_top, builder.padding_right, builder.padding_bottom);

        permissionViewInterface.setUnderlineViewOfHeaderBackgroundColor(builder.headerUnderlineViewBackgroundColor);
        permissionViewInterface.setUnderlineViewOfHeaderBackgroundVisibility((builder.headerUnderlineViewVisibility));

        dialog = new Dialog(contextWeakReference.get());
        dialog.setCanceledOnTouchOutside(false);
        dialog.setCancelable(false);
        dialog.setContentView((View) permissionViewInterface);
    }

//    Builder Class
    public static class Builder{
        Context context;
        PermissionListener permissionListener;
        private int headerTextSize = 16;
        private int textSize = 12;
        private int buttonTextSize = 13;
        private int textColor = Color.BLACK;
        private int headerTextColor=Color.BLACK;
        private String headerTextFontFaceName;
        private String textFontFaceName;
        private int permissionDescriptiveSubTextSize = 10;
        private int permissionDescriptiveBackgroundColor = Color.TRANSPARENT;
        private int backgroundColor = Color.TRANSPARENT;
        private int noteTextSize = 12;
        private int buttonTextColor = Color.BLACK;
        private int padding_left = 0;
        private int padding_top = 0;
        private int padding_right = 0;
        private int padding_bottom = 0;
        private int buttonBackgroundColor = Color.TRANSPARENT;
        private int headerBackgroundColor = Color.TRANSPARENT;
        private int headerUnderlineViewBackgroundColor = Color.TRANSPARENT;
        private int headerUnderlineViewVisibility = View.GONE;

        public Builder(Context context, PermissionListener permissionListener) {
            this.context = context;
            this.permissionListener = permissionListener;
        }

        public Builder withHeaderUnderlineViewBackgroundColorAndVisibility(int headerUnderlineViewBackgroundColor, int headerUnderlineViewVisibility) {
            this.headerUnderlineViewBackgroundColor = headerUnderlineViewBackgroundColor;
            this.headerUnderlineViewVisibility = headerUnderlineViewVisibility;
            return this;
        }


        public Builder withHeaderBackgroundColor(int headerBackgroundColor) {
            this.headerBackgroundColor = headerBackgroundColor;
            return this;
        }

        public Builder withHeaderTextSize(int headerTextSize) {
            this.headerTextSize = headerTextSize;
            return this;
        }

        public Builder withTextSize(int textSize) {
            this.textSize = textSize;
            return this;
        }

        public Builder withButtonTextSize(int buttonTextSize) {
            this.buttonTextSize = buttonTextSize;
            return this;
        }

        public Builder withTextColor(int textColor) {
            this.textColor = textColor;
            return this;
        }

        public Builder withHeaderTextColor(int headerTextColor) {
            this.headerTextColor = headerTextColor;
            return this;
        }

        public Builder withHeaderTextFontFaceName(String headerTextFontFaceName) {
            this.headerTextFontFaceName = headerTextFontFaceName;
            return this;
        }

        public Builder withTextFontFaceName(String textFontFaceName) {
            this.textFontFaceName = textFontFaceName;
            return this;
        }

        public Builder withPermissionDescriptiveSubTextSize(int permissionDescriptiveSubTextSize) {
            this.permissionDescriptiveSubTextSize = permissionDescriptiveSubTextSize;
            return this;
        }

        public Builder withPermissionDescriptiveBackgroundColor(int permissionDescriptiveBackgroundColor) {
            this.permissionDescriptiveBackgroundColor = permissionDescriptiveBackgroundColor;
            return this;
        }

        public Builder withBackgroundColor(int backgroundColor) {
            this.backgroundColor = backgroundColor;
            return this;
        }

        public Builder withNoteTextSize(int noteTextSize) {
            this.noteTextSize = noteTextSize;
            return this;
        }

        public Builder withButtonTextColor(int buttonTextColor) {
            this.buttonTextColor = buttonTextColor;
            return this;
        }

        public Builder withPadding_left(int padding_left) {
            this.padding_left = padding_left;
            return this;
        }

        public Builder withPadding_top(int padding_top) {
            this.padding_top = padding_top;
            return this;
        }

        public Builder withPadding_right(int padding_right) {
            this.padding_right = padding_right;
            return this;
        }

        public Builder withPadding_bottom(int padding_bottom) {
            this.padding_bottom = padding_bottom;
            return this;
        }

        public Builder withButtonBackgroundColor(int color){
            this.buttonBackgroundColor = color;
            return this;
        }
        public Builder withPadding(int padding_left, int padding_top, int padding_right, int padding_bottom){
            this.padding_left = padding_left;
            this.padding_top = padding_top;
            this.padding_right = padding_right;
            this.padding_bottom = padding_bottom;
            return this;
        }

        public PermissionPresenterImpl build(){
            return new PermissionPresenterImpl(this);
        }
    }

    public static Builder newBuilder(Context context, PermissionListener permissionListener){
        return new Builder(context, permissionListener);
    }

//    implement methods of PermissionPresenterInterface

    @Override
    public void onCreateView(PermissionViewDataModel permissionViewDataModel) {
        permissionViewInterface.setHeaderText(permissionViewDataModel.getHeaderText());
        permissionViewInterface.setSubHeaderText(permissionViewDataModel.getSubHeaderText());
        permissionViewInterface.setNoteText(permissionViewDataModel.getNoteText());
        permissionViewInterface.setRightBtnText(permissionViewDataModel.getRightBtnText());
        permissionViewInterface.setLeftBtnText(permissionViewDataModel.getLeftBtnText());

        if(permissionViewInterface.getViewCountOfDescriptiveLayout() > 0){
            permissionViewInterface.removeAllViewOfDescriptiveLayout();
        }

        if(permissionViewDataModel.getPermissionTypeDataArrayList() != null && permissionViewDataModel.getPermissionTypeDataArrayList().size() > 0 ){
            for(PermissionDescriptiveDataModel permissionDescriptiveDataModel : permissionViewDataModel.getPermissionTypeDataArrayList()){
                PermissionDescriptivePresenterInterface permissionDescriptivePresenterInterface = PermissionDescriptivePresenterImpl.newBuilder(contextWeakReference.get())
                        .withPermissionTextFontFaceName(textFontFaceName)
                        .withPermissionDescriptionFontFaceName(textFontFaceName)
                        .withPermissionTextColor(textColor)
                        .withPermissionDescriptionTextColor(textColor)
                        .withPermissionDescriptionTextSize(permissionDescriptiveSubTextSize)
                        .withPermissionTextSize(textSize)
                        .withBackgroundColor(permissionDescriptiveBackgroundColor)
                        .build();

                permissionDescriptivePresenterInterface.createView(permissionDescriptiveDataModel);
                permissionViewInterface.addPermissionDescriptiveLayout(permissionDescriptivePresenterInterface.getView());
            }
        }

    }

    @Override
    public View getPermissionView() {
        return (View) permissionViewInterface;
    }

    @Override
    public void showDialog() {
        if(dialog != null){
            dialog.show();
        }
    }

    @Override
    public void dismissDialog() {
        if(dialog != null){
            dialog.dismiss();
        }
    }

    @Override
    public void onDestroy() {
        permissionViewInterface = null;
        dialog = null;
    }

    @Override
    public void onLeftBtnVisibility(int visibility) {
        if(permissionListenerWeakReference.get() != null){
            permissionViewInterface.setLeftBtnVisibility(visibility);
        }
    }

    @Override
    public void onRightBtnClicked() {
        if (permissionListenerWeakReference.get() != null){
            permissionListenerWeakReference.get().onRightBtnClicked();
        }
    }

    @Override
    public void onLeftBtnClicked() {
        if (permissionListenerWeakReference.get() != null){
            permissionListenerWeakReference.get().onLeftBtnClicked();
        }
    }
}

package com.msl.permission_dialog.permissiondiscriptiv;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.view.View;

import java.lang.ref.WeakReference;

public class PermissionDescriptivePresenterImpl implements PermissionDescriptivePresenterInterface {

    WeakReference<Context> contextWeakReference;
    PermissionDescriptiveViewInterface permissionDescriptiveViewInterface;

    public PermissionDescriptivePresenterImpl(Builder builder) {
        if(builder.context == null){
            throw new RuntimeException("Context Cannot be Null !!");
        }

        contextWeakReference = new WeakReference<>(builder.context);
        permissionDescriptiveViewInterface = new PermissionDescriptiveViewImpl(contextWeakReference.get());

        permissionDescriptiveViewInterface.setBackgroundColor(builder.backgroundColor);
        permissionDescriptiveViewInterface.setPermissionNameTextColor(builder.permissionTextColor);
        permissionDescriptiveViewInterface.setPermissionNameTextSize(builder.permissionTextSize);
        permissionDescriptiveViewInterface.setPermissionDescriptionTextColor(builder.permissionDescriptionTextColor);
        permissionDescriptiveViewInterface.setPermissionDescriptionTextSize(builder.permissionDescriptionTextSize);

        if(builder.permissionDescriptionFontFaceName != null && !builder.permissionDescriptionFontFaceName.equals("")){
            Typeface typeface = Typeface.createFromAsset(contextWeakReference.get().getResources().getAssets(), builder.permissionDescriptionFontFaceName);
            permissionDescriptiveViewInterface.setPermissionDescriptionTypeFace(typeface);

        }
        if(builder.permissionTextFontFaceName != null && !builder.permissionTextFontFaceName.equals("")){
            Typeface typeface = Typeface.createFromAsset(contextWeakReference.get().getResources().getAssets(), builder.permissionTextFontFaceName);
            permissionDescriptiveViewInterface.setPermissionNameTypeFace(typeface);
        }
    }

    public static Builder newBuilder(Context context){
        return new Builder(context);
    }

    public static class Builder{
        private Context context;
        private int permissionTextSize;
        private int permissionTextColor = Color.BLACK;
        private String permissionTextFontFaceName;
        private int permissionDescriptionTextSize = 10;
        private int permissionDescriptionTextColor = Color.BLACK;
        private String permissionDescriptionFontFaceName;
        private int backgroundColor = Color.TRANSPARENT;

        public Builder(Context context) {
            this.context = context;
        }

        public Builder withPermissionTextSize(int permissionTextSize) {
            this.permissionTextSize = permissionTextSize;
            return this;
        }

        public Builder withPermissionTextColor(int permissionTextColor) {
            this.permissionTextColor = permissionTextColor;
            return this;
        }

        public Builder withPermissionTextFontFaceName(String permissionTextFontFaceName) {
            this.permissionTextFontFaceName = permissionTextFontFaceName;
            return this;

        }

        public Builder withPermissionDescriptionTextSize(int permissionDescriptionTextSize) {
            this.permissionDescriptionTextSize = permissionDescriptionTextSize;
            return this;

        }

        public Builder withPermissionDescriptionTextColor(int permissionDescriptionTextColor) {
            this.permissionDescriptionTextColor = permissionDescriptionTextColor;
            return this;

        }

        public Builder withPermissionDescriptionFontFaceName(String permissionDescriptionFontFaceName) {
            this.permissionDescriptionFontFaceName = permissionDescriptionFontFaceName;
            return this;

        }

        public Builder withBackgroundColor(int backgroundColor) {
            this.backgroundColor = backgroundColor;
            return this;

        }

        public PermissionDescriptivePresenterImpl build(){
            return new PermissionDescriptivePresenterImpl(this);
        }
    }

    @Override
    public void createView(PermissionDescriptiveDataModel permissionDescriptiveDataModel) {
        permissionDescriptiveViewInterface.setPermissionName(permissionDescriptiveDataModel.getPermissionName());
        permissionDescriptiveViewInterface.setPermissionDescription(permissionDescriptiveDataModel.getPermissionDescription());

        if(permissionDescriptiveDataModel.getPermissionDrawableName() != null && !permissionDescriptiveDataModel.getPermissionDrawableName().equals("")){
            int resId = contextWeakReference.get().getResources().getIdentifier(permissionDescriptiveDataModel.getPermissionDrawableName(),"drawable", contextWeakReference.get().getPackageName());
            if(resId > 0){
                permissionDescriptiveViewInterface.setDrawableImageResId(resId);
            }
        }

    }

    @Override
    public View getView() {
        return (View) permissionDescriptiveViewInterface;
    }
}

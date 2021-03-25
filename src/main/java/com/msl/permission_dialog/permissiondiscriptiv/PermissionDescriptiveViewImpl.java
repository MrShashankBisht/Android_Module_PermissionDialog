package com.msl.permission_dialog.permissiondiscriptiv;

import android.content.Context;
import android.graphics.Typeface;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.widget.RelativeLayout;

import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;

import com.msl.permission_dialog.R;

public class PermissionDescriptiveViewImpl extends RelativeLayout implements PermissionDescriptiveViewInterface {

    public PermissionDescriptiveViewImpl(Context context) {
        super(context);
        prepareView();
    }

    @Override
    public void prepareView() {
        LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.permission_descriptive_layout, this, true);
    }

    @Override
    public void setPermissionName(String permissionName) {
        ((AppCompatTextView) findViewById(R.id.permissionDescriptive_headerTextView)).setText(permissionName);

    }

    @Override
    public void setPermissionDescription(String description) {
        ((AppCompatTextView) findViewById(R.id.permissionDescriptive_descriptiveTextView)).setText(description);
    }

    @Override
    public void setDrawableImageResId(int resId) {
        ((AppCompatImageView) findViewById(R.id.permissionDescriptive_imageView)).setImageResource(resId);
    }

    @Override
    public void setPermissionNameTextSize(int textSize) {
        ((AppCompatTextView) findViewById(R.id.permissionDescriptive_descriptiveTextView)).setTextSize(TypedValue.COMPLEX_UNIT_SP, textSize);
    }

    @Override
    public void setPermissionNameTextColor(int color) {
        ((AppCompatTextView) findViewById(R.id.permissionDescriptive_headerTextView)).setTextColor(color);
    }

    @Override
    public void setPermissionNameTypeFace(Typeface typeFace) {
        ((AppCompatTextView) findViewById(R.id.permissionDescriptive_descriptiveTextView)).setTypeface(typeFace);
    }

    @Override
    public void setPermissionDescriptionTextSize(int textSize) {
        ((AppCompatTextView) findViewById(R.id.permissionDescriptive_descriptiveTextView)).setTextSize(TypedValue.COMPLEX_UNIT_SP, textSize);
    }

    @Override
    public void setPermissionDescriptionTextColor(int color) {
        ((AppCompatTextView) findViewById(R.id.permissionDescriptive_descriptiveTextView)).setTextColor(color);
    }

    @Override
    public void setPermissionDescriptionTypeFace(Typeface typeFace) {
        ((AppCompatTextView) findViewById(R.id.permissionDescriptive_descriptiveTextView)).setTypeface(typeFace);
    }
}

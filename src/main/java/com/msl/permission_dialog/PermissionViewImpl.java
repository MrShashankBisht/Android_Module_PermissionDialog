package com.msl.permission_dialog;

import android.content.Context;
import android.graphics.Typeface;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;

import java.lang.ref.WeakReference;

public class PermissionViewImpl extends RelativeLayout implements PermissionViewInterface {

    WeakReference<PermissionPresenterInterface> permissionPresenterInterfaceWeakReference;

    public PermissionViewImpl(Context context, PermissionPresenterInterface permissionPresenterInterface) {
        super(context);
        if(permissionPresenterInterface == null){
            throw new RuntimeException("PermissionPresenterInterface cannot be null !!");
        }
        permissionPresenterInterfaceWeakReference = new WeakReference<>(permissionPresenterInterface);
        prepareView();
    }

    @Override
    public void prepareView() {
        LayoutInflater layoutInflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        layoutInflater.inflate(R.layout.permission_layout,this,true);
//        set Button OnClickListeners
        ((AppCompatTextView) findViewById(R.id.permission_layout_right_textButton)).setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                permissionPresenterInterfaceWeakReference.get().onRightBtnClicked();
            }
        });

        ((AppCompatTextView) findViewById(R.id.permission_layout_left_textButton)).setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                permissionPresenterInterfaceWeakReference.get().onLeftBtnClicked();
            }
        });
    }

    @Override
    public void setHeaderTextSize(int size) {
        ((AppCompatTextView) findViewById(R.id.permission_layout_headerTextView)).setTextSize(TypedValue.COMPLEX_UNIT_SP, size);
    }

    @Override
    public void setHeaderTextTypeFace(Typeface typeFace) {
        ((AppCompatTextView) findViewById(R.id.permission_layout_headerTextView)).setTypeface(typeFace);
    }

    @Override
    public void setHeaderTextColor(int color) {
        ((AppCompatTextView) findViewById(R.id.permission_layout_headerTextView)).setTextColor(color);
    }

    @Override
    public void setHeaderBackgroundColor(int color) {
        findViewById(R.id.permission_layout_header).setBackgroundColor(color);
    }

    @Override
    public void setViewBackgroundColor(int color) {
        this.setBackgroundColor(color);
        ((ConstraintLayout) findViewById(R.id.permission_layout)).setBackgroundColor(color);
    }

    @Override
    public void setTextSize(int size) {
        ((AppCompatTextView) findViewById(R.id.permission_layout_subHeadding_textView)).setTextSize(TypedValue.COMPLEX_UNIT_SP, size);
    }

    @Override
    public void setTextTypeFace(Typeface typeFace) {
        ((AppCompatTextView) findViewById(R.id.permission_layout_subHeadding_textView)).setTypeface(typeFace);
        ((AppCompatTextView) findViewById(R.id.permission_layout_note_textView)).setTypeface(typeFace);
    }

    @Override
    public void setTextColor(int color) {
        ((AppCompatTextView) findViewById(R.id.permission_layout_subHeadding_textView)).setTextColor(color);
        ((AppCompatTextView) findViewById(R.id.permission_layout_note_textView)).setTextColor(color);
    }

    @Override
    public void setHeaderText(String headerText) {
        ((AppCompatTextView) findViewById(R.id.permission_layout_headerTextView)).setText(headerText);
    }

    @Override
    public void setSubHeaderText(String subHeaderText) {
        ((AppCompatTextView) findViewById(R.id.permission_layout_subHeadding_textView)).setText(subHeaderText);

    }

    @Override
    public void setButtonTextSize(int size) {
        ((AppCompatTextView) findViewById(R.id.permission_layout_right_textButton)).setTextSize(TypedValue.COMPLEX_UNIT_SP, size);
        ((AppCompatTextView) findViewById(R.id.permission_layout_left_textButton)).setTextSize(TypedValue.COMPLEX_UNIT_SP, size);
    }

    @Override
    public void setButtonTextTypeFace(Typeface typeFace) {
        ((AppCompatTextView) findViewById(R.id.permission_layout_right_textButton)).setTypeface(typeFace);
        ((AppCompatTextView) findViewById(R.id.permission_layout_left_textButton)).setTypeface(typeFace);
    }

    @Override
    public void setButtonTextColor(int color) {
        ((AppCompatTextView) findViewById(R.id.permission_layout_right_textButton)).setTextColor(color);
        ((AppCompatTextView) findViewById(R.id.permission_layout_left_textButton)).setTextColor(color);
    }

    @Override
    public void setButtonBackgroundColor(int color) {
        this.setBackgroundColor(color);
        ((AppCompatTextView) findViewById(R.id.permission_layout_right_textButton)).setBackgroundColor(color);
        ((AppCompatTextView) findViewById(R.id.permission_layout_left_textButton)).setBackgroundColor(color);
    }

    @Override
    public void setLeftBtnVisibility(int visibility) {
        ((AppCompatTextView) findViewById(R.id.permission_layout_left_textButton)).setVisibility(visibility);
    }

    @Override
    public void setNoteTextSize(int textSize) {
        ((AppCompatTextView) findViewById(R.id.permission_layout_note_textView)).setTextSize(TypedValue.COMPLEX_UNIT_SP,textSize);
    }

    @Override
    public void setNoteText(String noteText) {
        ((AppCompatTextView) findViewById(R.id.permission_layout_note_textView)).setText(noteText);
    }

    @Override
    public void setNoteTextVisibility(int visibility) {
        ((AppCompatTextView) findViewById(R.id.permission_layout_note_textView)).setVisibility(visibility);
    }

    @Override
    public void setRightBtnText(String rightBtnText) {
        ((AppCompatTextView) findViewById(R.id.permission_layout_right_textButton)).setText(rightBtnText);
    }

    @Override
    public void setLeftBtnText(String leftBtnText) {
        ((AppCompatTextView) findViewById(R.id.permission_layout_left_textButton)).setText(leftBtnText);
    }

    @Override
    public void addPermissionDescriptiveLayout(View view) {
        ((LinearLayout) findViewById(R.id.permission_layout_discriptive_linearLayout)).addView(view);
    }

    @Override
    public int getViewCountOfDescriptiveLayout() {
        return ((LinearLayout) findViewById(R.id.permission_layout_discriptive_linearLayout)).getChildCount();

    }

    @Override
    public void removeAllViewOfDescriptiveLayout() {
        ((LinearLayout) findViewById(R.id.permission_layout_discriptive_linearLayout)).removeAllViews();
    }

    @Override
    public void setUnderlineViewOfHeaderBackgroundColor(int color) {
        findViewById(R.id.permissionSimpleView1).setBackgroundColor(color);
    }

    @Override
    public void setUnderlineViewOfHeaderBackgroundVisibility(int visibility) {
        findViewById(R.id.permissionSimpleView1).setVisibility(visibility);
    }
}

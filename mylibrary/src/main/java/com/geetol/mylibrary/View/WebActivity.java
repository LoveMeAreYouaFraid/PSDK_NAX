package com.geetol.mylibrary.View;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.webkit.WebView;
import android.widget.TextView;


import com.geetol.mylibrary.R;
import com.geetol.mylibrary.Utils.StatusBarCompat;
import com.geetol.mylibrary.Entity.KEY;

import static android.content.Intent.FLAG_ACTIVITY_NEW_TASK;


public class WebActivity extends AppCompatActivity {

    private TextView title;
    private WebView web;

    public static void start(Context context, String uri, String title, int color) {
        context.startActivity(new Intent(context, WebActivity.class)
                .putExtra(KEY.URI, uri)
                .setFlags(FLAG_ACTIVITY_NEW_TASK)
                .putExtra(KEY.TITLE, title)
                .putExtra(KEY.COLOR, color));
    }
    public static void start(Context context, String uri, String title) {
        context.startActivity(new Intent(context, WebActivity.class)
                .putExtra(KEY.URI, uri)
                .setFlags(FLAG_ACTIVITY_NEW_TASK)
                .putExtra(KEY.TITLE, title));
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.web_activity);
        title = findViewById(R.id.title);
        web = findViewById(R.id.web);
        if (Build.VERSION.SDK_INT >= 19) {
            StatusBarCompat.setStatusBarColor(this, Color.parseColor("#4288FB"));
        }
        if (getIntent().hasExtra(KEY.TITLE)) {
            title.setText(getIntent().getStringExtra(KEY.TITLE));
        }
        if (getIntent().hasExtra(KEY.URI)) {
            web.loadUrl(getIntent().getStringExtra(KEY.URI));
        }
        if (getIntent().hasExtra(KEY.COLOR)) {
            title.setBackgroundResource(getIntent().getIntExtra(KEY.COLOR, R.color.app_style));
        }
    }

    public void back(View view) {
        finish();
    }
}

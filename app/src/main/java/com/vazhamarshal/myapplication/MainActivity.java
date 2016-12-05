package com.vazhamarshal.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.note_item);
        final View contentView = findViewById(R.id.content_lay);

        findViewById(R.id.card_view).setOnClickListener(new View.OnClickListener() {
            boolean tickTack;
            @Override
            public void onClick(View view) {
                contentView.setVisibility((tickTack = !tickTack)?View.VISIBLE:View.GONE);
            }
        });
    }
}

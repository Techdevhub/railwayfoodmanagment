package com.techdevhub.railwayproject;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.ViewSwitcher;

public class gallaryPage extends AppCompatActivity {

    private ImageSwitcher sw;

    int incr = 1;

    private Button nx,pv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gallary_page);

        sw = (ImageSwitcher) findViewById(R.id.imgsw2);
        pv = (Button) findViewById(R.id.priv);
        nx = (Button) findViewById(R.id.next);

        sw.setFactory(new ViewSwitcher.ViewFactory() {
            @Override
            public View makeView() {
                ImageView imageView = new ImageView(getApplicationContext());
                imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
                return imageView;
            }
        });

        sw.setImageResource(R.drawable.rail3);

        pv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                imageChange();
                if(incr == 4) incr = 0;
                incr = incr + 1;
            }
        });
        nx.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                imageChange();
                if(incr == 1) incr = 5;
                incr = incr - 1;
            }
        });
    }

    void imageChange()
    {
        if (incr == 1)
        {
            sw.setImageResource(R.drawable.rail1);
        }
        else if (incr == 2)
        {
            sw.setImageResource(R.drawable.rail2);
        }
        else if (incr == 3)
        {
            sw.setImageResource(R.drawable.rail3);
        }
        else if (incr == 4)
        {
            sw.setImageResource(R.drawable.pantry_1367475f);
        }
    }
}

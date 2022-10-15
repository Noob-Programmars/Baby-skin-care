package com.example.babyapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

public class SliderAdapter extends PagerAdapter {

    Context context;
    LayoutInflater layoutInflater;

    public SliderAdapter(Context context){
        this.context=context;
    }

    public int[] slide_images = {
            R.drawable.cribbg,
            R.drawable.feeding,
            R.drawable.babybathtub,
            R.drawable.sick
    };

    public String[] slide_headings = {
            "BABY AND CRIB",
            "BABY FOOD",
            "BABY BATH",
            "RASHES"
    };

    public String[] slide_discs = {
            "Click on the baby to keep a track on the baby's health and hunger,see if the baby needs a change of diaper or a bath.Click on the crib to ensure that the crib and sheets/pillows are clean. ",
            "Feed the baby regularly with healthy nutrients to ensure that the baby is healthy and not hungry.If any symptoms of skin diseases occur the relevant medicines have to be used to treat the baby immediately.",
            "Give the baby a shower using safe bath accessories at regular intervals and attend to the baby's safety and hygiene.",
            "If you don't take regular measures to ensure the baby's safety and hygiene the baby is likely to be affected by skin rashes or other skin diseases.The alert messages gives you a hint about the underlying causes which has to be detected and treated."
    };
    @Override
    public int getCount() {
        return slide_headings.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view== (RelativeLayout) object;
    }

    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {

        layoutInflater= (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.slideview,container,false);
        ImageView slideImageView= (ImageView) view.findViewById(R.id.slide_image);
        TextView slideHeading = (TextView) view.findViewById(R.id.slide_heading);
        TextView slideDescription = (TextView) view.findViewById(R.id.slide_disc);

        slideImageView.setImageResource(slide_images[position]);
        slideHeading.setText(slide_headings[position]);
        slideDescription.setText(slide_discs[position]);

        container.addView(view);

        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {

        container.removeView((RelativeLayout)object);
    }
}

package com.taxibooking.ui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.viewpager.widget.PagerAdapter;
import com.taxibooking.R;
import java.util.ArrayList;
import de.hdodenhof.circleimageview.CircleImageView;

public class CustomViewPagerAdapter extends PagerAdapter {
    private static final String TAG = "CustomViewPagerAdapter";
    private LayoutInflater inflater;
    private Context context;
    private ArrayList<Integer> logoImg = new ArrayList<>();
    private ArrayList<Integer> centerImg = new ArrayList<>();
    private ArrayList<String> headerMess = new ArrayList<>();
    private ArrayList<String> message_1 = new ArrayList<>();
    private ArrayList<String> message_2 = new ArrayList<>();

    public CustomViewPagerAdapter(Context context, ArrayList<Integer> logoImg, ArrayList<String> headerMess, ArrayList<Integer> centerImg, ArrayList<String> message_1, ArrayList<String> message_2) {
        this.context = context;
        this.logoImg =logoImg;
        this.headerMess =headerMess;
        this.centerImg =centerImg;
        this.message_1 =message_1;
        this.message_2 =message_2;

        inflater = LayoutInflater.from(context);
        notifyDataSetChanged();
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }

    @Override
    public int getCount() {
        return logoImg.size();
    }

    @Override
    public Object instantiateItem(ViewGroup view, int position) {
        View myImageLayout = inflater.inflate( R.layout.view_pager_item, view, false);

        ImageView ivAppLogo =myImageLayout.findViewById(R.id.ivAppLogo);
        CircleImageView image_center_ = myImageLayout.findViewById(R.id.circleImg);

        TextView tvHeaderMessage = myImageLayout.findViewById(R.id.tvHeaderMessage);
        TextView tvProfessional = myImageLayout.findViewById(R.id.tvProfessional);
        TextView tvMessage = myImageLayout.findViewById(R.id.tvMessage);

        tvHeaderMessage.setText(headerMess.get(position));
        tvProfessional.setText(message_1.get(position));
        tvMessage.setText(message_2.get(position));
        ivAppLogo.setImageResource(logoImg.get(position));
        image_center_.setImageResource(centerImg.get(position));

        view.addView(myImageLayout, 0);
        return myImageLayout;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view.equals(object);
    }
}

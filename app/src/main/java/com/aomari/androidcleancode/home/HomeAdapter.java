package com.aomari.androidcleancode.home;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.gjiazhe.scrollparallaximageview.ScrollParallaxImageView;
import com.gjiazhe.scrollparallaximageview.parallaxstyle.VerticalAlphaStyle;
import com.aomari.androidcleancode.R;
import com.aomari.androidcleancode.models.PhotosListData;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class HomeAdapter extends RecyclerView.Adapter<HomeAdapter.ViewHolder> {
    private final OnItemClickListener listener;
    private List<PhotosListData> data;
    private Context context;

    HomeAdapter(Context context, List<PhotosListData> data, OnItemClickListener listener) {
        this.data = data;
        this.listener = listener;
        this.context = context;
    }


    @Override
    public HomeAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_home, null);
        view.setLayoutParams(new RecyclerView.LayoutParams(RecyclerView.LayoutParams.MATCH_PARENT, RecyclerView.LayoutParams.WRAP_CONTENT));
        return new ViewHolder(view);
    }


    @Override
    public void onBindViewHolder(HomeAdapter.ViewHolder holder, int position) {
        holder.click(data.get(position), listener);
        holder.name.setText(
                String.format(context.getString(R.string.name),
                        data.get(position).getRover().getName())
        );

        holder.landingDate.setText(
                String.format(context.getString(R.string.landing_date),
                        data.get(position).getRover().getLandingDate())
        );

        holder.LaunchDate.setText(
                String.format(context.getString(R.string.landing_date),
                        data.get(position).getRover().getLaunchDate())
        );

        String images = data.get(position).getImageSource();

        Glide.with(context)
                .load(images)
                .into(holder.background);
    }


    @Override
    public int getItemCount() {
        return data.size();
    }


    public interface OnItemClickListener {
        void onClick(PhotosListData Item);
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.textView_name)
        TextView name;
        @BindView(R.id.textView_landingDate)
        TextView landingDate;
        @BindView(R.id.textView_launchDate)
        TextView LaunchDate;
        @BindView(R.id.imageView_src)
        ScrollParallaxImageView background;

        ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);

            background.setParallaxStyles(new VerticalAlphaStyle());

        }

        void click(final PhotosListData photosListData, final OnItemClickListener listener) {
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.onClick(photosListData);
                }
            });
        }
    }


}

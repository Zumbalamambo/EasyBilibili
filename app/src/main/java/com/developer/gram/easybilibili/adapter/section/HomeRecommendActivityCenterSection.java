package com.developer.gram.easybilibili.adapter.section;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.developer.gram.easybilibili.R;
import com.developer.gram.easybilibili.adapter.ActivityCenterRecyclerAdapter;
import com.developer.gram.easybilibili.bean.recommend.RecommendInfo;
import com.developer.gram.easybilibili.widget.sectioned.StatelessSection;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by hcc on 16/8/27 19:09
 * 100332338@qq.com
 * <p/>
 * 首页推荐界面活动中心section
 */
public class HomeRecommendActivityCenterSection extends StatelessSection {
    private Context mContext;
    private List<RecommendInfo.ResultBean.BodyBean> activitys;

    public HomeRecommendActivityCenterSection(Context context, List<RecommendInfo.ResultBean.BodyBean> activitys) {
        super(R.layout.item_recommend_activitycenter, R.layout.item_section_empty);
        this.mContext = context;
        this.activitys = activitys;
    }


    @Override
    public int getContentItemsTotal() {
        return 1;
    }


    @Override
    public RecyclerView.ViewHolder getItemViewHolder(View view) {
        return new EmptyViewHolder(view);
    }


    @Override
    public void onBindItemViewHolder(RecyclerView.ViewHolder holder, int position) {
    }


    @Override
    public RecyclerView.ViewHolder getHeaderViewHolder(View view) {
        return new ActivityCenterViewHolder(view);
    }


    @Override
    public void onBindHeaderViewHolder(RecyclerView.ViewHolder holder) {
        ActivityCenterViewHolder centerViewHolder = (ActivityCenterViewHolder) holder;
        centerViewHolder.mRecyclerView.setHasFixedSize(false);
        centerViewHolder.mRecyclerView.setNestedScrollingEnabled(false);
        centerViewHolder.mRecyclerView.setLayoutManager(new LinearLayoutManager(mContext,
                LinearLayoutManager.HORIZONTAL, false));
        centerViewHolder.mRecyclerView.setAdapter(new ActivityCenterRecyclerAdapter(
                centerViewHolder.mRecyclerView, activitys));
    }


    static class ActivityCenterViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.recycler)
        RecyclerView mRecyclerView;

        ActivityCenterViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

    private static class EmptyViewHolder extends RecyclerView.ViewHolder {
        EmptyViewHolder(View itemView) {
            super(itemView);
        }
    }
}

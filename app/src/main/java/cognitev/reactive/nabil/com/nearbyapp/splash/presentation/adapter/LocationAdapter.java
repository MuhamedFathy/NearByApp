package cognitev.reactive.nabil.com.nearbyapp.splash.presentation.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.List;

import cognitev.reactive.nabil.com.nearbyapp.R;
import cognitev.reactive.nabil.com.nearbyapp.splash.presentation.SplashViewModel;

/**
 * Created by anabil on 10/21/2017.
 */

public class LocationAdapter extends RecyclerView.Adapter<LocationAdapter.LocationViewHolder> {

    public static final int ITEM_VIEW_TYPE = 0;
    public static final int PROGRESS_ITEM_VIEW_TYPE = 1;
    private boolean showLoader;

    private List<SplashViewModel> mValues;
    private Context context;


    @Override
    public LocationViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view;

        if (viewType == PROGRESS_ITEM_VIEW_TYPE) {
            view = inflater.inflate(R.layout.progress_bar_item_loading, parent, false);
            return new ProgressViewHolder(view);
        } else {
            view = inflater.inflate(R.layout.list_item, parent, false);
            return new LocationViewHolder(view);
        }

    }

    @Override
    public void onBindViewHolder(LocationViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    @Override
    public int getItemViewType(int position) {
        if (position == getItemCount() - 1)
            return PROGRESS_ITEM_VIEW_TYPE;
        else
            return ITEM_VIEW_TYPE;


    }

    public class ProgressViewHolder extends RecyclerView.ViewHolder {

        public ProgressBar mProgressBar;

        public ProgressViewHolder(View itemView) {
            super(itemView);
            mProgressBar = (ProgressBar) itemView.findViewById(R.id.progress_bar);
        }
    }

    public class LocationViewHolder extends RecyclerView.ViewHolder {
        public final View mView;
        public final TextView title;
        private final TextView address;
        private final ImageView locationImage;


        public LocationViewHolder(View view) {
            super(view);
            mView = view;
            title = (TextView) view.findViewById(R.id.tv_date);
            address = (TextView) view.findViewById(R.id.tv_offer_title);
            locationImage = (ImageView) view.findViewById(R.id.iv_company_logo);

        }

        @Override
        public String toString() {
            return super.toString();//+ " '" + mContentView.getText() + "'";
        }
    }
}
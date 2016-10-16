package pe.com.orbis.stickysectionedrcv.view.adapter;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.AppCompatTextView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import pe.com.orbis.stickysectionedrcv.R;
import pe.com.orbis.stickysectionedrcv.model.NotificationEntity;
import pe.com.orbis.stickysectionedrcv.model.NotificationSectionEntity;

/**
 * Created by carlos on 25/05/16.
 * Alias: CarlitosDroid
 */
public class NotificationSectionAdapter extends SectioningAdapter{



    private class UserViewHolder extends SectioningAdapter.UserViewHolder implements View.OnClickListener{

        UserViewHolder(View itemView) {
            super(itemView);

        }

        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.lnlNotification:

                    break;
            }
        }
    }



    private class ItemViewHolder extends SectioningAdapter.ItemViewHolder implements View.OnClickListener{

        LinearLayout lnlNotification;
        AppCompatTextView lblTitle;
        AppCompatTextView lblDescription;
        AppCompatTextView lblHour;
        ImageView imgState;

        ItemViewHolder(View itemView) {
            super(itemView);
            lnlNotification = (LinearLayout) itemView.findViewById(R.id.lnlNotification);
            lblTitle = (AppCompatTextView) itemView.findViewById(R.id.lblTitle);
            lblDescription = (AppCompatTextView) itemView.findViewById(R.id.lblDescription);
            lblHour = (AppCompatTextView) itemView.findViewById(R.id.lblHour);
            imgState = (ImageView) itemView.findViewById(R.id.imgState);
            lnlNotification.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.lnlNotification:
                    Toast.makeText(context, "Item: "+lblTitle.getText(), Toast.LENGTH_SHORT).show();
                    break;
            }
        }
    }

    private class HeaderViewHolder extends SectioningAdapter.HeaderViewHolder implements View.OnClickListener{
        AppCompatTextView lblDate;
        HeaderViewHolder(View itemView) {
            super(itemView);
            lblDate = (AppCompatTextView) itemView.findViewById(R.id.lblDate);
            lblDate.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.lblDate:
                    Toast.makeText(context, "Header: "+lblDate.getText(), Toast.LENGTH_SHORT).show();
                    break;
            }
        }
    }

    private Context context;
    private List<NotificationSectionEntity> listSection = new ArrayList<>();

    public NotificationSectionAdapter(Context context){
        this.context = context;
    }

    public void setNotificationSection(List<NotificationSectionEntity> listNotificationSection){
        listSection.clear();
        this.listSection = listNotificationSection;
        notifyAllSectionsDataSetChanged();
    }


    @Override
    public boolean doesSectionHaveHeader(int sectionIndex) {
        return sectionIndex != 0;
    }

    @Override
    public boolean doesSectionHaveFooter(int sectionIndex) {
        return false;
    }

    @Override
    public HeaderViewHolder onCreateHeaderViewHolder(ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View v = inflater.inflate(R.layout.item_notification_header, parent, false);
        return new HeaderViewHolder(v);
    }


    @Override
    public UserViewHolder onCreateUserViewHolder(ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View v = inflater.inflate(R.layout.item_user, parent, false);
        return new UserViewHolder(v);
    }

    @Override
    public ItemViewHolder onCreateItemViewHolder(ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View v = inflater.inflate(R.layout.item_notification, parent, false);
        return new ItemViewHolder(v);
    }

    @Override
    public void onBindHeaderViewHolder(SectioningAdapter.HeaderViewHolder viewHolder, int sectionIndex) {
        HeaderViewHolder headerViewHolder = (HeaderViewHolder) viewHolder;
        headerViewHolder.lblDate.setText(listSection.get(sectionIndex).getDate());
    }

    @Override
    public void onBindItemViewHolder(SectioningAdapter.ItemViewHolder viewHolder, int sectionIndex, int itemIndex) {
        NotificationEntity sectionEntity = listSection.get(sectionIndex).getNotificationEntity().get(itemIndex);
        ItemViewHolder itemViewHolder = (ItemViewHolder) viewHolder;
        itemViewHolder.lblTitle.setText(sectionEntity.getTitle());
        itemViewHolder.lblDescription.setText(sectionEntity.getDescription());
        itemViewHolder.lblHour.setText(sectionEntity.getHour());
        if(sectionEntity.getState().equals("1")){
            itemViewHolder.imgState.setImageResource(R.drawable.ic_circle_green);
            itemViewHolder.lnlNotification.setBackgroundColor(ContextCompat.getColor(context, R.color.md_white_1000));
        }else{
            itemViewHolder.imgState.setImageResource(R.drawable.ic_circle_plumb);
            itemViewHolder.lnlNotification.setBackgroundColor(ContextCompat.getColor(context, R.color.notification_viewed));
        }

    }

    @Override
    public int getNumberOfSections() {
        return listSection.size();
    }

    @Override
    public int getNumberOfItemsInSection(int sectionIndex) {
        return listSection.get(sectionIndex).getNotificationEntity().size();
    }
}

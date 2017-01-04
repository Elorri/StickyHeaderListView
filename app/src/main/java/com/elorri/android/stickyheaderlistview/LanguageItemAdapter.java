package com.elorri.android.stickyheaderlistview;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

import se.emilsjolander.stickylistheaders.StickyListHeadersAdapter;

/**
 * Created by Elorri on 04/01/2017.
 */
public class LanguageItemAdapter extends ArrayAdapter<Language> implements StickyListHeadersAdapter {

    private final List<Language> list;
    private final Resources mResources;
    private LayoutInflater inflater;
    private long HEADER_AVAILABLE_ID = 0;
    private long HEADER_UNAVAILABLE_ID = 1;

    public LanguageItemAdapter(Context context, final List<Language> languages) {
        super(context, 0, languages);
        mResources = context.getResources();
        inflater = LayoutInflater.from(context);
        list = languages;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Language getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;

        if (convertView == null) {
            holder = new ViewHolder();
            convertView = inflater.inflate(R.layout.list_item_language, parent, false);
            holder.text = (TextView) convertView.findViewById(R.id.resourcemanager_title);
            convertView.setOnClickListener(holder);

            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        holder.bind(list.get(position).mLanguage, getItem(position).isAvailable(), isDownloading);
        return convertView;
    }

    @Override
    public View getHeaderView(int position, View convertView, ViewGroup parent) {
        HeaderViewHolder holder;
        if (convertView == null) {
            holder = new HeaderViewHolder();
            convertView = inflater.inflate(R.layout.resourcemanager_list_item_header, parent, false);
            holder.text = (TextView) convertView.findViewById(R.id.resourcemanager_title);
            convertView.setTag(holder);
        } else {
            holder = (HeaderViewHolder) convertView.getTag();
        }
        final Language item = getItem(position);
        final int res = (item.isAvailable()) ?
                R.string.resourcemanager_installed_section_title : R.string.resourcemanager_available_section_title;
        String headerText = mResources.getString(res);
        holder.text.setText(headerText);
        return convertView;
    }

    @Override
    public long getHeaderId(int position) {
        final Language item = getItem(position);
        return item.isAvailable() ? HEADER_AVAILABLE_ID : HEADER_UNAVAILABLE_ID;
    }

    class HeaderViewHolder {
        TextView text;
    }

    class ViewHolder implements View.OnClickListener {
        boolean mIsAvailableLanguageItem;
        boolean mIsDownloading;
        TextView text;

        public void bind(String language, boolean isAvailableLanguageItem, boolean isDownloading) {
            mIsAvailableLanguageItem = isAvailableLanguageItem;
            mIsDownloading = isDownloading;
            text.setText(language);

            if (mIsAvailableLanguageItem && languageKey) {
                Log.e("App", Thread.currentThread().getStackTrace()[2] + "");
                view.setBackgroundColor(null);
            } else {
                Log.e("App", Thread.currentThread().getStackTrace()[2] + "");
                view.setBackgroundColor(Color.GRAY);
            }
        }

        @Override
        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.resourcemanager_primary_action: {
                    if (mIsAvailableLanguageItem) {
                        fragment.onUpdateRequest();
                        Log.e("App", Thread.currentThread().getStackTrace()[2] + "");
                    } else {
                        Log.e("App", Thread.currentThread().getStackTrace()[2] + "");
                        downloadOrCancelRequest();
                    }
                    return;
                }
                case R.id.resourcemanager_secondary_action: {
                    fragment.onRemoveRequest();
                    return;
                }
                default: {
                    Log.e("App", Thread.currentThread().getStackTrace()[2] + "");
                    if (mIsAvailableLanguageItem) {
                        //Select it as default language request
                        setDefaultLanguageKey;
                        notifyDataSetChanged(); //This will redraw background of now unselected languages.
                        fragment.defaultLanguageChanged();
                        Log.e("App", Thread.currentThread().getStackTrace()[2] + "");
                    } else {
                        downloadOrCancelRequest();
                    }
                }
            }
        }

        private void downloadOrCancelRequest() {
            //Download or cancel request
            Log.e("App", Thread.currentThread().getStackTrace()[2] + "");
            if(mIsDownloading){
                fragment.onCancelRequest();
            }else{
                fragment.onDownloadRequest();
            }
        }

    }

}

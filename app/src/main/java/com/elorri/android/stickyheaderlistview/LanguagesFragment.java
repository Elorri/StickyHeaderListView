package com.elorri.android.stickyheaderlistview;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import se.emilsjolander.stickylistheaders.StickyListHeadersListView;

/**
 * Created by Elorri on 04/01/2017.
 */
public class LanguagesFragment extends DialogFragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_layout, container);

        StickyListHeadersListView stickyList = (StickyListHeadersListView) view.findViewById(R.id.list);
        LanguageItemAdapter adapter = new LanguageItemAdapter(this.getContext());
        stickyList.setAdapter(adapter);

        return view;
    }
}

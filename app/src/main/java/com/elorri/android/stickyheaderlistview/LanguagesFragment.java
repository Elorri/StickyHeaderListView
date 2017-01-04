package com.elorri.android.stickyheaderlistview;


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import se.emilsjolander.stickylistheaders.StickyListHeadersListView;

/**
 * Created by Elorri on 04/01/2017.
 */
public class LanguagesFragment extends DialogFragment {

    private List<Language> mLanguages;
    private Context mContext;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContext = getContext();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_layout, container);

        StickyListHeadersListView stickyList = (StickyListHeadersListView) view.findViewById(R.id.list);

        mLanguages = getLanguagesList();

        LanguageItemAdapter adapter = new LanguageItemAdapter(this.getContext(), mLanguages);
        stickyList.setAdapter(adapter);

        return view;
    }

    //This list must be tidied
    private List<Language> getLanguagesList() {
        String[] languages = mContext.getResources().getStringArray(R.array.languages);
        List<String> languageListString = (Arrays.asList(languages));
        Collections.sort(languageListString);

        String[] availableLanguages = mContext.getResources().getStringArray(R.array.available_languages);
        List<String> availableLanguageListString = (Arrays.asList(availableLanguages));
        Collections.sort(availableLanguageListString);

        List<String> finalLanguageList=new ArrayList<>(availableLanguageListString);
        finalLanguageList.addAll(languageListString);

        return getLanguagesList(finalLanguageList);
    }

    private List<Language> getLanguagesList(List<String> languageListString) {
        List<Language> list = new ArrayList<>();
        for (String language : languageListString) {
            list.add(new Language(mContext, language));
        }
        return list;
    }
}

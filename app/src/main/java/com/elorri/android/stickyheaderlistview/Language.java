package com.elorri.android.stickyheaderlistview;

import android.content.Context;

/**
 * Created by Elorri on 04/01/2017.
 */
public class Language {

    private final Context mContext;
    String mLanguage;

    public Language(Context context, String language) {
        mContext=context;
        mLanguage=language;
    }

    public boolean isAvailable() {
        String[] languages = mContext.getResources().getStringArray(R.array.available_languages);
        for(String language : languages){
            if(language.equals(mLanguage)){
                return true;
            }
        }
        return false;
    }
}

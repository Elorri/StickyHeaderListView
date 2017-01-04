package com.elorri.android.stickyheaderlistview.copy;

/**
 * Created by Elorri on 04/01/2017.
 */
public class LanguagesFragmentCopy
        //extends ResourceManagerLanguagesFragment
{
//    private Callback mCallback;
//    private ResourceManagerClientCopy mResourceManagerClient;
//    private String mSelectedLanguageKey;
//
//
//    public interface Callback
//    {
//        void setSelectedLanguageKey(String selectedLang);
//        void moveToNotebookFragment();
//    }
//
//    public void setCallback(Callback callback)
//    {
//        mCallback = callback;
//    }
//
//    @Override
//    public void onCreate(@Nullable Bundle savedInstanceState)
//    {
//        Application application = getActivity().getApplication();
//        if (application instanceof IResourceManagerProvider)
//        {
//            IResourceManagerProvider resourceManagerProvider = ((IResourceManagerProvider) application);
//            mResourceManagerClient = resourceManagerProvider.getResourceManager();
//        }
//        mSelectedLanguageKey = getArguments().getString(NotebookDialog.SELECTED_LANGUAGE_KEY);
//        super.onCreate(savedInstanceState); //We choose to call parent onCreate after having set up mSelectedLanguageKey, because it's needed in the parent
//    }
//
//    @Override
//    protected ResourceManagerClientCopy getResourceManagerClient()
//    {
//        return mResourceManagerClient;
//    }
//
//    @Override
//    protected String getSelectedLanguageKey()
//    {
//        return mSelectedLanguageKey;
//    }
//
//    @Override
//    protected void onLanguageSelected(Language language)
//    {
//        mSelectedLanguageKey = language.getLanguageKey();
//        mCallback.setSelectedLanguageKey(mSelectedLanguageKey);
//    }
//
//    @Nullable
//    @Override
//    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState)
//    {
//        getContext().getTheme().applyStyle(R.style.Theme_ResourceManager, true);
//        View languageView = super.onCreateView(inflater, container, savedInstanceState);
//        View view = inflater.inflate(R.layout.fragment_edit_language, null, false);
//        ((ViewGroup) view.findViewById(R.id.languages_list_container)).addView(languageView);
//        Button positiveButton = (Button) view.findViewById(R.id.positive_button);
//        int activeColor = getArguments().getInt(NotebookDialog.NOTEBOOK_COLOR);
//        positiveButton.setTextColor(DrawableUtils.getButtonTextColorSelector(activeColor));
//        positiveButton.setOnClickListener(new View.OnClickListener()
//        {
//            @Override
//            public void onClick(View v)
//            {
//                mCallback.moveToNotebookFragment();
//            }
//        });
//        return view;
//    }
}
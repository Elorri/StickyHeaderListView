package com.elorri.android.stickyheaderlistview.copy;

public abstract class ResourceManagerLanguagesFragmentCopy
        //extends Fragment implements        OnItemClickListener
{
//
//    private static final String TAG = LogUtil.makeLogTag(ResourceManagerLanguagesFragment.class);
//    private static final boolean DBG = false;
//
//    private ResourceManagerClientCopy mClient;
//    private LanguageItemAdapter mAdapter;
//    private LanguageAvailabilityComparator mLanguageComparator;
//    private List<Language> mLanguages;
//    private final GlobalDownloadsCallback mLanguagesDownloadCallbacks = new GlobalDownloadsCallback()
//    {
//        @Override
//        public void onLanguageDownloadStart(final Language language)
//        {
//            if (DBG)
//                Log.d(getDebugTag(), "onLanguageDownloadStart " + language.getLanguageKey());
//
//            final int position = mLanguages.indexOf(language);
//            if (position > -1)
//            {
//                mLanguages.set(position, language);
//                Collections.sort(mLanguages, mLanguageComparator);
//
//                mAdapter.notifyDataSetChanged();
//            }
//            else
//            {
//                Log.w(TAG, "Language not found : " + language + " (" + Integer.toHexString(language.hashCode()) + ")");
//            }
//        }
//
//        @Override
//        public void onLanguageDownloadProgress(final Language language, final int max, final int progress)
//        {
//            if (DBG)
//                Log.d(getDebugTag(), "onLanguageDownloadProgress " + language.getLanguageKey() + " " + progress + "/" + max);
//            mAdapter.setDownloadProgress(language, max, progress);
//            mAdapter.notifyDataSetChanged();
//        }
//
//        @Override
//        public void onLanguageDownloadCanceled(final Language language)
//        {
//            if (DBG)
//                Log.d(getDebugTag(), "onLanguageDownloadCanceled " + language.getLanguageKey());
//            final int position = mLanguages.indexOf(language);
//            if (position > -1)
//            {
//                mLanguages.set(position, language);
//                Collections.sort(mLanguages, mLanguageComparator);
//
//                mAdapter.setDownloadEnded(language);
//                mAdapter.notifyDataSetChanged();
//            }
//            else
//            {
//                Log.w(TAG, "Language not found : " + language + " (" + Integer.toHexString(language.hashCode()) + ")");
//            }
//        }
//
//        @Override
//        public void onLanguageDownloadSuccess(final Language language)
//        {
//            if (DBG)
//                Log.d(getDebugTag(), "onLanguageDownloadSuccess " + language.getLanguageKey());
//
//            final int position = mLanguages.indexOf(language);
//            if (position > -1)
//            {
//                mLanguages.set(position, language);
//                Collections.sort(mLanguages, mLanguageComparator);
//
//                mAdapter.setDownloadEnded(language);
//                mAdapter.notifyDataSetChanged();
//            }
//            else
//            {
//                Log.w(TAG, "Language not found : " + language + " (" + Integer.toHexString(language.hashCode()) + ")");
//            }
//        }
//
//        @Override
//        public void onLanguageDownloadError(final Language language, final Throwable exception)
//        {
//            if (DBG)
//                Log.e(getDebugTag(), "onLanguageDownloadError " + language.getLanguageKey() + " " + exception.getMessage(), exception);
//
//            SnackBar.makeSnack(getActivity()).withTitle(language.getDisplayName() + " : " + exception.getLocalizedMessage()).show(ResourceManagerLanguagesFragment.this);
//
//            final int position = mLanguages.indexOf(language);
//            if (position > -1)
//            {
//                mLanguages.set(position, language);
//                Collections.sort(mLanguages, mLanguageComparator);
//
//                mAdapter.setDownloadEnded(language);
//                mAdapter.notifyDataSetChanged();
//            }
//            else
//            {
//                Log.w(TAG, "Language not found : " + language + " (" + Integer.toHexString(language.hashCode()) + ")");
//            }
//        }
//    };
//    private String mDefaultLanguageKey;
//    private StickyListHeadersListView mListView;
//    private final OnLanguageDownloadCancelListener mOnLanguageDownloadCancelListener = new OnLanguageDownloadCancelListener()
//    {
//        @Override
//        public void onLanguageDownloadCancel(final View view)
//        {
//            final int position = mListView.getPositionForView(view);
//            final Language language = (Language) mListView.getItemAtPosition(position);
//            mClient.cancelDownload(language);
//        }
//    };
//    private final LanguageItemAdapter.OnLanguageUpdateListener mOnLanguageUpdateListener = new LanguageItemAdapter.OnLanguageUpdateListener()
//    {
//        @Override
//        public void onLanguageUpdate(final View view)
//        {
//            final int position = mListView.getPositionForView(view);
//            final Language language = (Language) mListView.getItemAtPosition(position);
//            triggerDownloadLanguage(language);
//        }
//    };
//    private View mProgressBar;
//    private LanguageListUtilCopy mLanguageListUtil = null;
//    private String mLatestFilePath = null;
//    private final BroadcastReceiver.PendingResult.Callback<String> mUpdateLanguageListPendingResult = new Callback<String>()
//    {
//        @Override
//        public void onResult(final String result)
//        {
//            mLatestFilePath = result;
//            final List<String> confPaths = mClient.getConfPaths();
//            if (mLanguageListUtil == null)
//                mLanguageListUtil = new LanguageListUtilCopy(mLatestFilePath, confPaths);
//            else
//                mLanguageListUtil.reConfigure(mLatestFilePath, confPaths);
//            new Thread(new Runnable()
//            {
//                @Override
//                public void run()
//                {
//                    mLanguageListUtil.buildList();
//                    final List<Language> languageList = mLanguageListUtil.getLanguages();
//                    if (languageList != null)
//                    {
//                        getActivity().runOnUiThread(new Runnable()
//                        {
//                            @Override
//                            public void run()
//                            {
//                                onLanguagesLoaded(languageList);
//                            }
//                        });
//                    }
//                }
//            }).start();
//        }
//
//        @Override
//        public void onFailure(final Throwable e)
//        {
//            onLanguagesError(e);
//        }
//    };
//
//    @Override
//    public void onCreate(final android.os.Bundle savedInstanceState)
//    {
//        if (DBG)
//            Log.d(TAG + Integer.toHexString(hashCode()), "onCreate");
//
//        super.onCreate(savedInstanceState);
//
//        mLanguageComparator = new LanguageAvailabilityComparator();
//        mLanguages = new ArrayList<Language>();
//        mAdapter = new LanguageItemAdapter(getActivity(), mLanguages);
//        mAdapter.setOnLanguageDownloadCancelListener(mOnLanguageDownloadCancelListener);
//        mAdapter.setOnLanguageUpdateListener(mOnLanguageUpdateListener);
//
//        final String selectedLanguageKey = getSelectedLanguageKey();
//        if (selectedLanguageKey != null)
//        {
//            mDefaultLanguageKey = selectedLanguageKey;
//            mAdapter.setDefaultLanguageKey(mDefaultLanguageKey);
//        }
//    }
//
//    @Override
//    public View onCreateView(final LayoutInflater inflater, final ViewGroup container, final Bundle savedInstanceState)
//    {
//        return inflater.inflate(R.layout.fragment_language, container, false);
//    }
//
//    @Override
//    public void onViewCreated(final View view, final Bundle savedInstanceState)
//    {
//        if (DBG)
//            Log.d(getDebugTag(), "onViewCreated");
//
//        super.onViewCreated(view, savedInstanceState);
//
//        mListView = (StickyListHeadersListView) view.findViewById(android.R.id.list);
//        mProgressBar = view.findViewById(android.R.id.progress);
//
//        mListView.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE_MODAL);
//        mListView.setDrawingListUnderStickyHeader(false);
//        mListView.setOnItemClickListener(this);
//        mListView.setAdapter(mAdapter);
//        if (!mAdapter.isEmpty())
//            setListShown(true);
//    }
//
//    private void setListShown(final boolean shown)
//    {
//        mListView.setVisibility(shown ? View.VISIBLE : View.INVISIBLE);
//        mProgressBar.setVisibility(shown ? View.INVISIBLE : View.VISIBLE);
//    }
//
//    @Override
//    public void onStart()
//    {
//        if (DBG)
//            Log.d(getDebugTag(), "onStart");
//
//        super.onStart();
//
//        mClient = getResourceManagerClient();
//
//        mClient.addGlobalDownloadCallback(mLanguagesDownloadCallbacks);
//        mClient.connect(new ConnectionCallbacks()
//        {
//            @Override
//            public void onConnected()
//            {
//                mClient.updateLanguageList().setCallback(mUpdateLanguageListPendingResult); // Refresh with remote content
//                mAdapter.clearDownloadProgresses();
//                mAdapter.notifyDataSetChanged();
//            }
//
//            @Override
//            public void onConnectionFailed(final Throwable e)
//            {
//                Log.e(TAG, "Connection failed", e);
//            }
//        });
//    }
//
//    @Override
//    public void onStop()
//    {
//        if (DBG)
//            Log.d(getDebugTag(), "onStop");
//
//        super.onStop();
//    }
//
//    @Override
//    public void onDestroy()
//    {
//        if (DBG)
//            Log.d(getDebugTag(), "onDestroy");
//        super.onDestroy();
//    }
//
//    @Override
//    public void onItemClick(final AdapterView<?> parent, final View view, final int position, final long id)
//    {
//        Log.e("Nebo", Thread.currentThread().getStackTrace()[2] + "view " + view);
//        String tag = (String) view.getTag(R.id.resourcemanager_local_language_viewtag);
//        if (tag != null && tag.equals("local"))
//        {
//            if(view.getId()==R.id.resourcemanager_download){
//                Log.e("Nebo", Thread.currentThread().getStackTrace()[2] + "before delete view " + view);
//                deleteSelectedLanguages();
//                mClient.deleteLanguage(language);
//                loadLanguages();
//                Log.e("Nebo", Thread.currentThread().getStackTrace()[2] + "after delete view " + view);
//            }
//        }
//        else
//        {
//            final Language language = (Language) parent.getItemAtPosition(position);
//            if (!language.isAvailable())
//            {
//                triggerDownloadLanguage(language);
//            }
//            else
//            {
//                mDefaultLanguageKey = language.getLanguageKey();
//                mAdapter.setDefaultLanguageKey(mDefaultLanguageKey);
//                onLanguageSelected(language);
//            }
//        }
//    }
//
//    private void triggerDownloadLanguage(Language language)
//    {
//        if (DBG)
//            Log.d(getDebugTag(), "triggerDownloadLanguage " + language);
//
//        if (isNetworkOff())
//        {
//            final AlertDialogFragment dialog = AlertDialogFragment.create(R.string.resourcemanager_alertnodata_title, R.string.resourcemanager_alertnodata_msg);
//            dialog.show(getFragmentManager(), "AlertDialogFragmentConnection");
//        }
//        else
//        {
//
//            mClient.downloadLanguage(language).execute();
//            mAdapter.addPendingLanguage(language);
//            mAdapter.notifyDataSetChanged();
//        }
//    }
//
//    private void fetchLanguages()
//    {
//        setListShown(false);
//        mClient.updateLanguageList().setCallback(mUpdateLanguageListPendingResult);
//    }
//
//    private void onLanguagesLoaded(final List<Language> languages)
//    {
//        Collections.sort(languages, mLanguageComparator);
//        mLanguages.clear();
//        mLanguages.addAll(languages);
//        mAdapter.notifyDataSetChanged();
//
//        setListShown(true);
//    }
//
//    private void onLanguagesError(final Throwable e)
//    {
//        setListShown(true);
//
//        Log.e(getDebugTag(), String.format("Error when fetching languages (%s)", e.getMessage()), e);
//        SnackBar.makeSnack(getActivity()).withTitle(e.getMessage())//
//                .withAction(R.string.resourcemanager_retry, new Runnable()
//                {
//                    @Override
//                    public void run()
//                    {
//                        fetchLanguages();
//                    }
//                }).show(ResourceManagerLanguagesFragment.this);
//    }
//
//    private void loadLanguages()
//    {
//        final List<String> confPaths = mClient.getConfPaths();
//        if (mLanguageListUtil == null)
//            mLanguageListUtil = new LanguageListUtilCopy(mLatestFilePath, confPaths);
//        else
//            mLanguageListUtil.reConfigure(mLatestFilePath, confPaths);
//        new Thread(new Runnable()
//        {
//            @Override
//            public void run()
//            {
//                mLanguageListUtil.buildList();
//                final List<Language> languageList = mLanguageListUtil.getLanguages();
//                if (languageList != null)
//                {
//                    getActivity().runOnUiThread(new Runnable()
//                    {
//                        @Override
//                        public void run()
//                        {
//                            onLanguagesLoaded(languageList);
//                        }
//                    });
//                }
//            }
//        }).start();
//    }
//
//    private void selectedAll()
//    {
//        for (int i = 0; i < mAdapter.getCount(); i++)
//        {
//            final Language language = mAdapter.getItem(i);
//            if (language.isAvailable() && !language.getLanguageKey().equals(mDefaultLanguageKey))
//            {
//                mListView.setItemChecked(i, true);
//            }
//        }
//    }
//
//    private void deleteSelectedLanguages()
//    {
//        final SparseBooleanArray checked = mListView.getCheckedItemPositions();
//        final List<Language> deletedLanguages = new ArrayList<Language>();
//        for (int i = 0; i < checked.size(); i++)
//        {
//            if (checked.valueAt(i))
//                deletedLanguages.add(mAdapter.getItem(checked.keyAt(i)));
//        }
//
//        for (final Language language : deletedLanguages)
//        { mClient.deleteLanguage(language); }
//
//        loadLanguages();
//    }
//
//    private boolean isNetworkOff()
//    {
//        final ConnectivityManager connManager = (ConnectivityManager) getActivity().getSystemService(Application.CONNECTIVITY_SERVICE);
//        final boolean isNetworkNotAvailable = connManager.getActiveNetworkInfo() == null;
//        return isNetworkNotAvailable || !connManager.getActiveNetworkInfo().isAvailable() || !connManager.getActiveNetworkInfo().isConnected();
//    }
//
//    private String getDebugTag()
//    {
//        return TAG + Integer.toHexString(hashCode());
//    }
//
//    protected abstract ResourceManagerClientCopy getResourceManagerClient();
//
//    protected abstract String getSelectedLanguageKey();
//
//    protected abstract void onLanguageSelected(Language language);

}

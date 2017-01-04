package com.elorri.android.stickyheaderlistview.copy;

/**
 * A utility class for simplifying integration of ResourceManager.
 * Integrator can get Language instance list easily with given result of updateLanguageList() and getConfPaths() of ResourceManagerClientCopy.
 * This is useful especially when integrator wants to build own download UI of language resources.
 */
public final class LanguageListUtilCopy
{
//    private static final String TAG = LogUtil.makeLogTag(LanguageListUtilCopy.class);
//    private final Object mLanguagesLock = new Object();
//    private Map<String, Language> mLanguages;
//    private String mLatestFilePath = null;
//    private List<String> mConfFolderPaths = null;
//    private boolean mIsLanguageListBuildSuccess;
//    private Latest mLocalLatest;
//    private String mPreloadFolderPath;
//    private String mDownloadFolderPath;
//    private Version mPreloadVersion;
//
//    /**
//     * Creates a com.elorri.android.stickyheaderlistview.copy.LanguageListUtilCopy instance with inputted latest.json file path and conf folder path lists.
//     * This two value is essential for building Language instance list.
//     *
//     * @param latestFilePath A string which holds file path of latest.json. This value can be gotten from calling updateLanguageList() of ResourceManagerClientCopy
//     * @param confFolderPaths A string list which holds all conf folder list where language resource information exists. This value can be gotten from calling getConfPaths() of ResourceManagerClientCopy
//     */
//    public LanguageListUtilCopy(final String latestFilePath, final List<String> confFolderPaths)
//    {
//        mLatestFilePath = latestFilePath;
//        mConfFolderPaths = confFolderPaths;
//        mIsLanguageListBuildSuccess = false;
//        mPreloadFolderPath = null;
//        mDownloadFolderPath = null;
//        mLanguages = new HashMap<String, Language>();
//    }
//
//    /**
//     * Does not create a new com.elorri.android.stickyheaderlistview.copy.LanguageListUtilCopy instance but re-initialize with inputted latest.json file path and conf folder path lists.
//     * This two value is essential for building Language instance list.
//     *
//     * @param latestFilePath A string which holds file path of latest.json. This value can be gotten from calling updateLanguageList() of ResourceManagerClientCopy
//     * @param confFolderPaths A string list which holds all conf folder list where language resource information exists. This value can be gotten from calling getConfPaths() of ResourceManagerClientCopy
//     */
//    public void reConfigure(final String latestFilePath, final List<String> confFolderPaths)
//    {
//        mLatestFilePath = latestFilePath;
//        mConfFolderPaths = confFolderPaths;
//        mIsLanguageListBuildSuccess = false;
//        mPreloadFolderPath = null;
//        mDownloadFolderPath = null;
//        mLanguages = new HashMap<String, Language>();
//    }
//
//    /**
//     * Returns a built Language instance list which already built with previous buildList() call.
//     *
//     * @return A Language instance list if succeeded on previous buildList() call, null if it was failed or not executed.
//     */
//    public final List<Language> getLanguages()
//    {
//        if (!mIsLanguageListBuildSuccess)
//        {
//            Log.w(TAG, "Language List was not build or not succeeded yet. Call buildList() first!");
//            return null;
//        }
//        synchronized (mLanguagesLock)
//        {
//            return new ArrayList<Language>(mLanguages.values());
//        }
//    }
//
//    /**
//     * Builds Language instance list with given latest.json file path and conf folder path lists.
//     * Build could be failed if those two values were not valid or pasring of latest.json failed.
//     * This methold call should not be run in UI/main thread as this is a time-consuming and lots of file-access work.
//     *
//     * @return A integer which is the number of Language instances in the built list. Could be minus values if there was an error on build
//     */
//    public final int buildList()
//    {
//        Log.d(TAG, "buildList...");
//
//        if (mLatestFilePath == null)
//        {
//            Log.e(TAG, "Latest.json file path was not set correctly... Abandoned building language list");
//            mIsLanguageListBuildSuccess = false;
//            return -1;
//        }
//
//        File latestTxt = new File(mLatestFilePath);
//        boolean parseFailed = false;
//        InputStream stream = null;
//
//        try
//        {
//            stream = new FileInputStream(latestTxt);
//            final String content = IOUtils.streamToString(stream);
//            final LatestParser parser = new LatestParser();
//            mLocalLatest = parser.parse(content);
//        }
//        catch (Exception e)
//        {
//            Log.e(TAG, "Parsing latest.json file failed... Abandoned building language list", e);
//            parseFailed = true;
//        }
//        finally
//        {
//            IOUtils.closeQuietly(stream);
//        }
//
//        if (parseFailed)
//        {
//            // already logged
//            mIsLanguageListBuildSuccess = false;
//            return -2;
//        }
//
//        final Set<String> languageKeys = mLocalLatest.getLanguages();
//        if (languageKeys.isEmpty())
//        {
//            Log.e(TAG, "Latest.json does not have language list... Abandoned building language list");
//            mIsLanguageListBuildSuccess = false;
//            return -3;
//        }
//
//        final LanguageNameHelper languageNameHelper = new LanguageNameHelper(languageKeys);
//        ArrayList<Version> versions = buildVersionsInfo();
//        if (versions == null)
//        {
//            Log.e(TAG, "conext or conf folder paths are not set correctly... Abandoned building language list");
//            mIsLanguageListBuildSuccess = false;
//            return -4;
//        }
//
//        synchronized (mLanguagesLock)
//        {
//            mLanguages.clear();
//
//            for (final String languageKey : languageKeys)
//            {
//                if (!Language.isSpecialResources(languageKey))
//                {
//                    final Language language = new Language();
//                    language.setLanguageKey(languageKey);
//                    setLanguageInfo(language, languageNameHelper.getDisplayLanguage(languageKey), null, false, false);
//                    mLanguages.put(languageKey, language);
//                }
//            }
//
//            File confFolder = null;
//            final boolean isPreloaded = (mPreloadFolderPath != null) && (mPreloadVersion != null);
//            if (isPreloaded)
//            {
//                confFolder = new File(mPreloadFolderPath, ResourceManagerConf.CONF_DIRNAME);
//                final String[] items = confFolder.list();
//                if (items != null)
//                {
//                    for (int i = 0; i < items.length; i++)
//                    {
//                        String languageKey = null;
//                        final File file = new File(confFolder, items[i]);
//                        if (file.isFile())
//                        {
//                            languageKey = getLangKeyFromConfFileName(file.getName());
//                            Language languageInTheList = null;
//                            if (languageKey != null)
//                                languageInTheList = mLanguages.get(languageKey);
//                            if ((languageInTheList != null) && (!Language.isSpecialResources(languageKey)))
//                            {
//                                final Language language = new Language();
//                                language.setLanguageKey(languageKey);
//                                setLanguageInfo(language, languageNameHelper.getDisplayLanguage(languageKey), mPreloadVersion, true, true);
//                                mLanguages.put(languageKey, language);
//                            }
//                        }
//                    }
//                }
//            }
//
//            for (final Version version : versions)
//            {
//                confFolder = new File(mDownloadFolderPath + File.separator + version.toString() + File.separator + ResourceManagerConf.CONF_DIRNAME);
//
//                boolean isOlderThanPreload = false;
//                if (mPreloadVersion != null)
//                    isOlderThanPreload = (version.compareTo(mPreloadVersion) < 0);
//
//                final String[] items = confFolder.list();
//                if (items != null)
//                {
//                    for (int i = 0; i < items.length; i++)
//                    {
//                        String languageKey = null;
//                        final File file = new File(confFolder, items[i]);
//                        if (file.isFile())
//                        {
//                            languageKey = getLangKeyFromConfFileName(file.getName());
//                            if ((languageKey != null) && (!Language.isSpecialResources(languageKey)))
//                            {
//                                final Language languageToCompare = mLanguages.get(languageKey);
//                                if ((languageToCompare != null) && languageToCompare.isPreloaded() && isOlderThanPreload)
//                                    continue;
//                                else if (languageToCompare != null)
//                                {
//                                    final Language language = new Language();
//                                    language.setLanguageKey(languageKey);
//                                    setLanguageInfo(language, languageNameHelper.getDisplayLanguage(languageKey), version, false, true);
//                                    mLanguages.put(languageKey, language);
//                                }
//                            }
//                        }
//                    }
//                }
//            }
//        }
//        mIsLanguageListBuildSuccess = true;
//        return mLanguages.size();
//    }
//
//    private ArrayList<Version> buildVersionsInfo()
//    {
//        boolean foundDownloadFolder = false;
//        ArrayList<Version> versions = new ArrayList<Version>();
//
//        if (mLatestFilePath == null || mConfFolderPaths == null)
//            return null;
//
//        File latest = new File(mLatestFilePath);
//        if (!latest.isFile())
//            return null;
//
//        String appFilesDirPath = latest.getParent();
//
//        for (int i = 0; i < mConfFolderPaths.size(); i++)
//        {
//            String versionFolderPath = (new File(mConfFolderPaths.get(i))).getParent();
//            if (versionFolderPath.startsWith(appFilesDirPath))
//            {
//                String versionString = (new File(versionFolderPath)).getName();
//                try
//                {
//                    Version toAdd = new Version(versionString);
//                    versions.add(toAdd);
//                    if ((!foundDownloadFolder) || (mDownloadFolderPath == null))
//                    {
//                        mDownloadFolderPath = (new File(versionFolderPath)).getParent();
//                        foundDownloadFolder = true;
//                    }
//
//                }
//                catch (IllegalArgumentException e)
//                {
//                    Log.e(TAG, "Wrong version folder path in building version list : " + versionFolderPath, e);
//                }
//            }
//            else
//            {
//                mPreloadFolderPath = versionFolderPath;
//            }
//        }
//        // Sort versions in ascending order
//        Collections.sort(versions);
//
//        if (mPreloadFolderPath != null)
//        {
//            String versionString = (new File(mPreloadFolderPath)).getName();
//            try
//            {
//                mPreloadVersion = new Version(versionString);
//            }
//            catch (IllegalArgumentException e)
//            {
//                Log.e(TAG, "Wrong preload version folder path in building version list : " + mPreloadFolderPath, e);
//                mPreloadFolderPath = null;
//                mPreloadVersion = null;
//            }
//        }
//        else
//            mPreloadVersion = null;
//
//        return versions;
//    }
//
//    private void setLanguageInfo(final Language language, final String displayName, Version version, boolean isPreload, boolean isAvailable)
//    {
//        final Boolean isUpToDate = version == null ? null : version.compareTo(mLocalLatest.getVersion()) >= 0;
//
//        language.setDisplayName(displayName);
//        language.setIsAvailable(isAvailable);
//        language.setIsUpToDate(isUpToDate);
//        language.setIsPreloaded(isPreload);
//    }
//
//    private String getLangKeyFromConfFileName(String fileName)
//    {
//        if ((fileName != null) && (fileName.endsWith(ResourceManagerConf.CONF_FILENAME_EXT)))
//        {
//            try
//            {
//                final String[] parts = fileName.split("\\.");
//                if (parts.length == 2)
//                {
//                    return parts[0];
//                }
//                else
//                {
//                    return null;
//                }
//            }
//            catch (final Exception e)
//            {
//                Log.e(TAG, "Filename parsing error " + fileName, e);
//            }
//        }
//        return null;
//    }

}



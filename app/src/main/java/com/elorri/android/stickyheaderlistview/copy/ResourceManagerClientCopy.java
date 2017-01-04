package com.elorri.android.stickyheaderlistview.copy;

/**
 * Created by Elorri on 04/01/2017.
 */

/**
 * The client class for using ResourceManager service for downloading, deleting and getting information of languages.
 */
public class ResourceManagerClientCopy
{
//
//    /**
//     * A static class which is holding context of client process package and package name of service process package.
//     */
//    public static class Builder
//    {
//        private final Context mContext;
//        private final String mServiceName;
//
//        /**
//         * Creates a builder for creating ResourceManagerClinets.
//         *
//         * @param context Context of client application
//         * @param servicePackageName Pacakge name of service process package
//         */
//        public Builder(final Context context, final String servicePackageName)
//        {
//            mContext = context;
//            mServiceName = servicePackageName;
//        }
//
//        /**
//         * Creates a ResourceManagerClientCopy instance for with the information of this builder.
//         *
//         * @return a ResourceManagerClinet created with the information of this builder
//         */
//        public ResourceManagerClientCopy build()
//        {
//            return new ResourceManagerClientCopy(this);
//        }
//    }
//
//    private static final String TAG = "Nebo";
//    private static final boolean DBG = false || DebugMode.RM_ACTIVATION_ALL_DBG;
//
//    private static final String EXTRA_REPOSITORY = "repository";
//    private final List<PendingResult<?>> mPendingResults;
//    private final String mServiceName;
//
//    private final GlobalDownloadCallbackProxy mGlobalDownloadCallbacksProxy;
//
//    private final PendingResultHandler mPendingResultHandler = new PendingResultHandler()
//    {
//        @Override
//        public void registerPendingResult(final PendingResult<?> pendingResult)
//        {
//            mPendingResults.add(pendingResult);
//        }
//
//        @Override
//        public void unregisterPendingResult(final PendingResult<?> pendingResult)
//        {
//
//        }
//
//        @Override
//        public void onOrfanException(final Throwable e)
//        {
//            Log.e(TAG + Integer.toHexString(ResourceManagerClientCopy.this.hashCode()), e.getMessage(), e);
//        }
//    };
//
//    private Context mContext;
//    private ResourceManagerConnection mResourceManagerConnection;
//
//    /**
//     * Creates a client of ResourceManager service. Calling connect() is needed to use client APIs provided after creation.
//     *
//     * @param builder Builder which holds context of client process package and package name of service process package
//     */
//    private ResourceManagerClientCopy(final Builder builder)
//    {
//        mContext = builder.mContext;
//
//        mServiceName = builder.mServiceName;
//
//        mGlobalDownloadCallbacksProxy = new GlobalDownloadCallbackProxy();
//        mPendingResults = new ArrayList<PendingResult<?>>();
//    }
//
//    /**
//     * Add a callback to get notification from service about the progression of resource downloads.
//     *
//     * @param callback GlobalDownloadsCallback to which progression of resource downloads will be notified
//     */
//    public void addGlobalDownloadCallback(GlobalDownloadsCallback callback)
//    {
//        mGlobalDownloadCallbacksProxy.addGlobalDownloadCallback(callback);
//    }
//
//    /**
//     * Remove the callback of getting notification from service about the progression of resource downloads.
//     *
//     * @param callback GlobalDownloadsCallback to which progression of resource downloads is notified
//     */
//    public void removeGlobalDownloadCallback(GlobalDownloadsCallback callback)
//    {
//        mGlobalDownloadCallbacksProxy.removeGlobalDownloadCallback(callback);
//    }
//
//    /**
//     * Connect to the service.
//     *
//     * @param callbacks ConnectionCallbacks which connection result will be notified
//     */
//    public void connect(final ConnectionCallbacks callbacks)
//    {
//        if (DBG)
//            Log.i(TAG + Integer.toHexString(hashCode()), "connect");
//
//        final PendingResult<ResourceManagerConnection> result = new PendingResultBase<ResourceManagerConnection>(mPendingResultHandler)
//        {
//            @Override
//            protected ResourceManagerConnection get() throws Exception
//            {
//
//                final Intent intent = new Intent();
//                intent.setClassName(mServiceName, ResourceManager.class.getName());
//                mContext.startService(intent);
//
//                final BlockingServiceConnection serviceConnection = new BlockingServiceConnection();
//
//                final Intent bindIntent = new Intent();
//                bindIntent.setClassName(mServiceName, ResourceManager.class.getName());
//
//                final boolean connected = mContext.bindService(bindIntent, serviceConnection, Context.BIND_AUTO_CREATE);
//                if (!connected)
//                {
//                    mContext.unbindService(serviceConnection);
//                    throw new BindException("Can't bind to the service.");
//                }
//
//                return new ResourceManagerConnection(serviceConnection, mGlobalDownloadCallbacksProxy);
//            }
//        };
//
//        result.setCallback(new PendingResult.Callback<ResourceManagerConnection>()
//        {
//            @Override
//            public void onResult(final ResourceManagerConnection result)
//            {
//                if (DBG)
//                    Log.i(TAG + Integer.toHexString(ResourceManagerClientCopy.this.hashCode()), Integer.toHexString(hashCode()) + " connected " + result + " for callback " + Integer.toHexString(callbacks.hashCode()));
//
//                mResourceManagerConnection = result;
//                callbacks.onConnected();
//            }
//
//            @Override
//            public void onFailure(final Throwable e)
//            {
//                mResourceManagerConnection = null;
//                callbacks.onConnectionFailed(e);
//            }
//        });
//    }
//
//    /**
//     * Disconnect from the service.
//     */
//    public void disconnect()
//    {
//        if (DBG)
//            Log.i(TAG + Integer.toHexString(hashCode()), "disconnect");
//
//        cancelPendingResults();
//
//        if (mResourceManagerConnection != null)
//        {
//            mResourceManagerConnection.disconnect(mContext);
//            mResourceManagerConnection = null;
//        }
//
//        mGlobalDownloadCallbacksProxy.clear();
//    }
//
//    private void cancelPendingResults()
//    {
//        for (final PendingResult<?> pendingResult : mPendingResults)
//        {
//            Log.d(TAG + Integer.toHexString(ResourceManagerClientCopy.this.hashCode()), "cancelPendingResults " + pendingResult);
//            pendingResult.cancel();
//        }
//        mPendingResults.clear();
//    }
//
//    /**
//     * Remove a language from repository.
//     *
//     * @param language the language
//     */
//    public void deleteLanguage(final Language language)
//    {
//        if (DBG)
//            Log.i(TAG + Integer.toHexString(hashCode()), "removeLanguage " + language.getLanguageKey());
//
//        checkResourceManagerConnection();
//
//        new PendingResultBase<Void>(mPendingResultHandler)
//        {
//            @Override
//            protected Void get() throws Exception
//            {
//                mResourceManagerConnection.deleteLanguage(language);
//
//                return null;
//            }
//        }.execute();
//    }
//
//    /**
//     * Get conf folder paths of a language.
//     *
//     * @return a list of conf folder paths
//     */
//    public List<String> getConfPaths()
//    {
//        if (DBG)
//            Log.i(TAG + Integer.toHexString(hashCode()), "getConfPaths");
//
//        checkResourceManagerConnection();
//        List<String> res = mResourceManagerConnection.getConfPaths();
//        return res;
//    }
//
//    /**
//     * Get latest.json file path of the repository.
//     *
//     * @return file path of the most recent latest.json
//     */
//    public PendingResult<String> updateLanguageList()
//    {
//        if (DBG)
//            Log.i(TAG + Integer.toHexString(hashCode()), "updateLanguageList");
//
//        checkResourceManagerConnection();
//
//        final PendingResult<String> result = new PendingResultBase<String>(mPendingResultHandler)
//        {
//            @Override
//            protected String get()
//            {
//                return mResourceManagerConnection.updateLanguageList();
//            }
//        };
//        return result;
//    }
//
//    /**
//     * Download a language or update it.
//     *
//     * @param language the language
//     * @return PendingProgressResult to execute and to get callbacks from the service via registered GlobalDownloadsCallback
//     */
//    public PendingProgressResult<Language> downloadLanguage(final Language language)
//    {
//        if (DBG)
//            Log.i(TAG + Integer.toHexString(hashCode()), "downloadLanguage " + language.getLanguageKey());
//
//        checkResourceManagerConnection();
//        return mResourceManagerConnection.downloadLanguage(language);
//    }
//
//    /**
//     * Cancel the download of a language.
//     *
//     * @param language the language
//     */
//    public void cancelDownload(final Language language)
//    {
//        if (DBG)
//            Log.i(TAG + Integer.toHexString(hashCode()), "cancelDownload " + language.getLanguageKey());
//
//        checkResourceManagerConnection();
//
//        new PendingResultBase<Void>(mPendingResultHandler)
//        {
//            @Override
//            protected Void get() throws Exception
//            {
//                mResourceManagerConnection.cancelDownload(language);
//
//                return null;
//            }
//        }.execute();
//    }
//
//    /**
//     * Returns whether ResourceManager service is binded or not.
//     *
//     * @return whether ResourceManager service is binded or not
//     */
//    public boolean isConnected()
//    {
//        return (mResourceManagerConnection != null);
//    }
//
//    private void checkResourceManagerConnection()
//    {
//        if (!isConnected())
//            throw new IllegalStateException("Not connected.");
//    }
}

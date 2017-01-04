package com.elorri.android.stickyheaderlistview.copy;

/**
 * Created by Elorri on 04/01/2017.
 */
public class LanguageItemAdapterCopy
        //extends ArrayAdapter<Language>
        //implements        StickyListHeadersAdapter
{
//    private static final String TAG = LogUtil.makeLogTag(LanguageItemAdapter.class);
//    private static final boolean DBG = false;
//    private final static int VIEW_TYPE_LANGUAGE = 0;
//    private final static int VIEW_TYPE_LANGUAGE_TIPS = 1;
//    private final LayoutInflater mLayoutInflater;
//    private final Map<Language, DownloadProgress> mDownloadProgresses;
//    private final Set<Language> mPendingLanguages;
//    private Context mContext;
//    private final Resources mResources;
//    private boolean mIsInSelectionMode;
//    private String mDefaultLanguageKey;
//    private OnLanguageDownloadCancelListener mOnLanguageDownloadListener;
//    private OnLanguageUpdateListener mOnLanguageUpdateListener;
//    private OnTipDismissListener mOnTipDismissListener;
//
//    public LanguageItemAdapterCopy(final Context context, final List<Language> objects)
//    {
//        super(context, 0, objects);
//        mLayoutInflater = LayoutInflater.from(context);
//        mDownloadProgresses = new ConcurrentHashMap<Language, DownloadProgress>(0, 0.9f, 1);
//        mPendingLanguages = new HashSet<Language>();
//        mContext = context;
//        mResources = context.getResources();
//    }
//
//    @Override
//    public boolean areAllItemsEnabled()
//    {
//        return false;
//    }
//
//    @Override
//    public int getViewTypeCount()
//    {
//        return 2;
//    }
//
//    @Override
//    public int getItemViewType(final int position)
//    {
//        final Language item = getItem(position);
//        return (item instanceof LanguageTips) ? VIEW_TYPE_LANGUAGE_TIPS : VIEW_TYPE_LANGUAGE;
//    }
//
//    @Override
//    public boolean isEnabled(final int position)
//    {
//        final Language item = getItem(position);
//        return mIsInSelectionMode == false || isFocusable(item);
//    }
//
//    public void addPendingLanguage(Language language)
//    {
//        mPendingLanguages.add(language);
//    }
//
//    public void setPendingLanguages(Collection<Language> languages)
//    {
//        mPendingLanguages.clear();
//        mPendingLanguages.addAll(languages);
//    }
//
//    public void clearDownloadProgresses()
//    {
//        mDownloadProgresses.clear();
//    }
//
//    private boolean isFocusable(final Language language)
//    {
//        return language.isAvailable() /*&& !language.isPreloaded()*/;
//    }
//
//    public void setDownloadProgress(final Language language, final int max, final int progress)
//    {
//        DownloadProgress item = mDownloadProgresses.get(language);
//        if (item == null)
//        {
//            item = new DownloadProgress();
//            mDownloadProgresses.put(language, item);
//        }
//        item.setMax(max);
//        item.setProgress(progress);
//
//        mPendingLanguages.remove(language);
//    }
//
//    public void setDownloadEnded(final Language language)
//    {
//        mDownloadProgresses.remove(language);
//        mPendingLanguages.remove(language);
//    }
//
//    public void setIsInSelectionMode(final boolean isInSelectionMode)
//    {
//        mIsInSelectionMode = isInSelectionMode;
//    }
//
//    public void setDefaultLanguageKey(final String defaultLanguageKey)
//    {
//        mDefaultLanguageKey = defaultLanguageKey;
//        notifyDataSetChanged();
//    }
//
//    public void setOnLanguageDownloadCancelListener(final OnLanguageDownloadCancelListener onLanguageDownloadListener)
//    {
//        mOnLanguageDownloadListener = onLanguageDownloadListener;
//    }
//
//    public void setOnLanguageUpdateListener(final OnLanguageUpdateListener onLanguageUpdateListener)
//    {
//        mOnLanguageUpdateListener = onLanguageUpdateListener;
//    }
//
//    public void setOnTipDismissListener(final OnTipDismissListener onTipDismissListener)
//    {
//        mOnTipDismissListener = onTipDismissListener;
//    }
//
//    @Override
//    public View getView(final int position, final View convertView, final ViewGroup parent)
//    {
//        View view;
//        final int viewType = getItemViewType(position);
//        if (viewType == VIEW_TYPE_LANGUAGE)
//        {
//            view = createLanguageView(position, convertView, parent);
//        }
//        else
//        {
//            view = createLanguageTipsView(position, convertView, parent);
//        }
//        return view;
//    }
//
//    private View createLanguageTipsView(final int position, final View convertView, final ViewGroup parent)
//    {
//        View view = convertView;
//        if (convertView == null)
//        {
//            view = mLayoutInflater.inflate(R.layout.list_item_language_tips, parent, false);
//            final ImageButton close = (ImageButton) view.findViewById(R.id.resourcemanager_cancel);
//            close.setOnClickListener(new OnClickListener()
//            {
//                @Override
//                public void onClick(final View v)
//                {
//                    remove(getItem(position));
//
//                    if (mOnTipDismissListener != null)
//                        mOnTipDismissListener.onTipDismiss();
//                }
//            });
//        }
//
//        return view;
//    }
//
//    private View createLanguageView(final int position, final View convertView, final ViewGroup parent)
//    {
//        final Language item = getItem(position);
//
//        View view = convertView;
//        final LanguageViewHolder holder;
//        if (convertView == null)
//        {
//            view = mLayoutInflater.inflate(R.layout.list_item_language, parent, false);
//
//            holder = new LanguageViewHolder();
//            holder.title = (TextView) view.findViewById(R.id.resourcemanager_title);
//            holder.summary = (TextView) view.findViewById(R.id.resourcemanager_summary);
//            holder.progress = (ProgressBar) view.findViewById(R.id.resourcemanager_progress);
//            holder.radio = (RadioStateImageView) view.findViewById(R.id.resourcemanager_radio);
//            holder.buttonUpdate = view.findViewById(R.id.resourcemanager_update);
//            holder.buttonUpdate.setOnClickListener(new OnClickListener()
//            {
//                @Override
//                public void onClick(final View v)
//                {
//                    Log.e("Nebo", Thread.currentThread().getStackTrace()[2] + "");
//                    if (mOnLanguageUpdateListener != null)
//                    {
//                        Log.e("Nebo", Thread.currentThread().getStackTrace()[2] + "");
//                        mOnLanguageUpdateListener.onLanguageUpdate(v);
//                    }
//                }
//            });
//            holder.buttonRemove = view.findViewById(R.id.resourcemanager_remove);
//            holder.buttonDownload = view.findViewById(R.id.resourcemanager_download);
//            holder.buttonDownload.setOnClickListener(new OnClickListener()
//            {
//                @Override
//                public void onClick(final View view)
//                {
//                    if (view.getTag().equals("action_CANCEL"))
//                    {
//                        if (mOnLanguageDownloadListener != null)
//                        {
//                            mOnLanguageDownloadListener.onLanguageDownloadCancel(view);
//                        }
//                    }
//                }
//            });
//            view.setTag(R.id.resourcemanager_holder_viewtag, holder);
//        }
//        else
//        {
//            holder = (LanguageViewHolder) convertView.getTag(R.id.resourcemanager_holder_viewtag);
//        }
//        bindView(view, item, holder);
//
//        final boolean isEnabled = isEnabled(position);
//        view.setEnabled(isEnabled);
//        holder.buttonCancel.setEnabled(isEnabled); // Because duplicateParentState is false
//        return view;
//    }
//
//    private void bindView(View view, final Language item, final LanguageViewHolder holder)
//    {
//        holder.title.setText(item.getDisplayName());
//        if (item.isAvailable())
//        {
//            bindLocalLanguageView(item, holder);
//            view.setTag(R.id.resourcemanager_local_language_viewtag, "local");
//            Log.e("Nebo", Thread.currentThread().getStackTrace()[2] + "convertView " + view);
//        }
//        else
//        {
//            bindRemoteLanguageView(item, holder);
//            view.setTag(R.id.resourcemanager_remote_language_viewtag, "remote");
//            Log.e("Nebo", Thread.currentThread().getStackTrace()[2] + "convertView " + view);
//        }
//    }
//
//    private void bindLocalLanguageView(final Language item, final LanguageViewHolder holder)
//    {
//        holder.buttonCancel.setVisibility(View.GONE);
//        holder.radio.setVisibility(View.GONE);
//        bindCommonStates(item, holder);
//        holder.buttonDownload.setVisibility(View.VISIBLE);
//        holder.bu
//
//        holder.radio.setChecked(item.getLanguageKey().equals(mDefaultLanguageKey));
//        holder.buttonDownload.setBackgroundDrawable(getThemeDrawable(R.attr.resourcemanager_icon_delete));
//        holder.buttonDownload.setOnClickListener(new OnClickListener()
//        {
//            @Override
//            public void onClick(View v)
//            {
//                Log.e("Nebo", Thread.currentThread().getStackTrace()[2] + "");
//            }
//        });
//    }
//
//    private void bindRemoteLanguageView(final Language item, final LanguageViewHolder holder)
//    {
//        holder.radio.setVisibility(View.GONE);
//        holder.buttonDownload.setBackgroundDrawable(getThemeDrawable(R.attr.resourcemanager_icon_download));
//
////    if (item.isPreloaded())
////    {
////      holder.buttonDownload.setVisibility(View.GONE);
////      holder.buttonCancel.setVisibility(View.GONE);
////      holder.progress.setVisibility(View.GONE);
////      holder.summary.setVisibility(View.GONE);
////    }
////    else
////    {
//        bindCommonStates(item, holder);
////    }
//    }
//
//
//    private Drawable getThemeDrawable(int ressourceId)
//    {
//        TypedValue typedValue = new TypedValue();
//        TypedArray a = mContext.getTheme().obtainStyledAttributes(typedValue.data, new int[]{ressourceId});
//        Drawable drawable = a.getDrawable(0);
//        a.recycle();
//        drawable = DrawableUtils.setSize(drawable, (int) mResources.getDimension(R.dimen.resourcemanager_icon_size));
//        drawable = DrawableUtils.addPaddingArround((int) mResources.getDimension(R.dimen.resourcemanager_icon_padding), drawable);
//        return drawable;
//    }
//
//    private void bindCommonStates(final Language item, final LanguageViewHolder holder)
//    {
//        final DownloadProgress progress = mDownloadProgresses.get(item);
//        final boolean isPending = mPendingLanguages.contains(item);
//
//        if (progress == null && !isPending)
//        {
//            holder.buttonUpdate.setVisibility(Boolean.FALSE.equals(item.isUpToDate()) ? View.VISIBLE : View.GONE);
//            holder.buttonDownload.setVisibility(Boolean.FALSE.equals(item.isAvailable()) ? View.VISIBLE : View.INVISIBLE);
//            holder.buttonCancel.setVisibility(View.GONE);
//            holder.progress.setVisibility(View.GONE);
//            holder.summary.setVisibility(View.GONE);
//        }
//        else
//        {
//            holder.buttonUpdate.setVisibility(View.GONE);
//            holder.buttonDownload.setVisibility(View.INVISIBLE);
//            holder.buttonCancel.setVisibility(View.VISIBLE);
//            holder.progress.setVisibility(View.VISIBLE);
//            holder.summary.setVisibility(View.VISIBLE);
//
//            if (progress != null)
//            {
//                final String summary = FormatUtils.getDownloadProgressSummary(getContext(), item, progress.getMax(), progress.getProgress());
//                holder.summary.setText(summary);
//                holder.progress.setIndeterminate(false);
//                holder.progress.setMax(progress.getMax());
//                holder.progress.setProgress(progress.getProgress());
//            }
//            else
//            {
//                holder.progress.setIndeterminate(true);
//                holder.summary.setText(R.string.resourcemanager_download_enqueued);
//            }
//
//        }
//    }
//
//    @Override
//    public View getHeaderView(final int position, final View convertView, final ViewGroup parent)
//    {
//        View view = convertView;
//        HeaderViewHolder holder;
//        if (convertView == null)
//        {
//            holder = new HeaderViewHolder();
//            view = mLayoutInflater.inflate(R.layout.resourcemanager_list_item_header, parent, false);
//            holder.title = (TextView) view.findViewById(R.id.headerTitle);
//            view.setTag(R.id.resourcemanager_holder_viewtag, holder);
//        }
//        else
//        {
//            holder = (HeaderViewHolder) convertView.getTag(R.id.resourcemanager_holder_viewtag);
//        }
//
//        holder.title.setText(getSectionTitle(position));
//        return view;
//    }
//
//    private CharSequence getSectionTitle(final int position)
//    {
//        final Language item = getItem(position);
//        final int res = (item.isAvailable()) ? R.string.resourcemanager_installed_section_title : R.string.resourcemanager_available_section_title;
//        return getContext().getString(res);
//    }
//
//    @Override
//    public long getHeaderId(final int position)
//    {
//        final Language item = getItem(position);
//        return item.isAvailable() ? 0 : 1;
//    }
//
//
//    public static interface OnLanguageDownloadCancelListener
//    {
//        void onLanguageDownloadCancel(View view);
//    }
//
//    public static interface OnTipDismissListener
//    {
//        void onTipDismiss();
//    }
//
//    public static interface OnLanguageUpdateListener
//    {
//        void onLanguageUpdate(View view);
//    }
//
//    private static class LanguageViewHolder
//    {
//        TextView title;
//        ProgressBar progress;
//        TextView summary;
//        RadioStateImageView radio;
//        View buttonUpdate;
//        View buttonRemove;
//        View buttonDownload;
//    }
//
//    private static class HeaderViewHolder
//    {
//        TextView title;
//    }
}

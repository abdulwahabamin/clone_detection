    /**
     * Constructor
     *
     * @param context  {@link android.content.Context}
     * @param listener {@link com.cyanogenmod.filemanager.tasks.FetchStatsByTypeTask.Listener}
     *
     * @throws IllegalArgumentException {@link java.lang.IllegalArgumentException}
     */
    public FetchStatsByTypeTask(Context context, Listener listener)
            throws IllegalArgumentException {
        if (context == null) {
            throw new IllegalArgumentException("'context' cannot be null");
        }
        mContext = context;
        mListener = listener;
    }


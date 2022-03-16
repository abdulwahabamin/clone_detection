    /**
     * Constructor
     *
     * @param context {@link android.content.Context}
     * @param fso {@link com.cyanogenmod.filemanager.model.FileSystemObject}
     *
     * @throws IllegalArgumentException {@link java.lang.IllegalArgumentException}
     */
    public SecureChoiceClickListener(Context context, FileSystemObject fso,
            ISecureChoiceCompleteListener listener) throws IllegalArgumentException {
        if (context == null) {
            throw new IllegalArgumentException("'context' cannot be null!");
        }
        if (fso == null) {
            throw new IllegalArgumentException("'fso' cannot be null!");
        }
        if (listener == null) {
            throw new IllegalArgumentException("'listener' cannot be null!");
        }
        mContext = context;
        mFso = fso;
        mListener = listener;
    }


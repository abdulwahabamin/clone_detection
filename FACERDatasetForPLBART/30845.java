    private CrashHandler(Context context) {
        if (null == context)
            throw new IllegalArgumentException("context cannot be null");

        mContext = context;
    }


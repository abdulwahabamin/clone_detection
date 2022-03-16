    public RootsLoader(Context context, RootsCache roots, State state) {
        super(context);
        mRoots = roots;
        mState = state;

        getContext().getContentResolver()
                .registerContentObserver(RootsCache.sNotificationUri, false, mObserver);
    }


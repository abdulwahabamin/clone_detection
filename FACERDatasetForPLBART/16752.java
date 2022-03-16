    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        FireLog.d(TAG, "(++) onCreate");
        setHasOptionsMenu(true);
        title = getArguments().getString(TITLE);
        mediaId = getArguments().getString(MEDIA_ID);
        super.onCreate(savedInstanceState);
    }


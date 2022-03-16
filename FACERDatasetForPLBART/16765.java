    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        setHasOptionsMenu(true);
        title = getArguments().getString(TITLE);
        mediaId = getArguments().getString(EXTRA_MEDIA_ID);
        super.onCreate(savedInstanceState);
    }


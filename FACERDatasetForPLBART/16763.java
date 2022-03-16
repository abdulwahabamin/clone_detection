    public static MediaListFragment newInstance(String title, String mediaId) {
        MediaListFragment fragment = new MediaListFragment();
        Bundle args = new Bundle();
        args.putString(TITLE, title);
        args.putString(EXTRA_MEDIA_ID, mediaId);
        fragment.setArguments(args);
        return fragment;
    }


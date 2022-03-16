    public static CategoryFragment newInstance(String title, String mediaId) {
        CategoryFragment fragment = new CategoryFragment();
        Bundle args = new Bundle();
        args.putString(TITLE, title);
        args.putString(MEDIA_ID, mediaId);
        fragment.setArguments(args);
        return fragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.listview, container, false);
        mListView = (ListView)root.findViewById(android.R.id.list);

        // Align the track list with the header, in other words,OCD.
        TextView mHeader = (TextView)root.findViewById(R.id.title);
        int eight = (int)getActivity().getResources().getDimension(
                R.dimen.list_separator_padding_left_right);
        mHeader.setPadding(eight, 0, 0, 0);

        // Set the header while in @TracksBrowser
        String header = getActivity().getResources().getString(R.string.track_header);
        int left = getActivity().getResources().getInteger(R.integer.listview_padding_left);
        int right = getActivity().getResources().getInteger(R.integer.listview_padding_right);
        ApolloUtils.listHeader(this, root, header);
        ApolloUtils.setListPadding(this, mListView, left, 0, right, 0);

        // Hide the extra spacing from the Bottom ActionBar in the queue
        // Fragment in @AudioPlayerHolder
        if (getArguments() != null) {
            mPlaylistId = getArguments().getLong(BaseColumns._ID);
            String mimeType = getArguments().getString(MIME_TYPE);
            if (Audio.Playlists.CONTENT_TYPE.equals(mimeType)) {
                switch ((int)mPlaylistId) {
                    case (int)PLAYLIST_QUEUE:
                        LinearLayout emptyness = (LinearLayout)root.findViewById(R.id.empty_view);
                        emptyness.setVisibility(View.GONE);
                }
            }
        }
        return root;
    }


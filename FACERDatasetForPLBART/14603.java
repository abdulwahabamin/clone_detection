    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.listview, container, false);
        mListView = (ListView)root.findViewById(android.R.id.list);

        // Set the header for @TrackBrowser
        String header = getActivity().getResources().getString(R.string.album_header);
        int left = getActivity().getResources().getInteger(R.integer.listview_padding_left);
        int right = getActivity().getResources().getInteger(R.integer.listview_padding_right);
        ApolloUtils.listHeader(this, root, header);
        ApolloUtils.setListPadding(this, mListView, left, 0, right, 0);
        return root;
    }


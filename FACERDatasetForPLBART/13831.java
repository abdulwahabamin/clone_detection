    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        onNavigationListener.onNavigationItemClickedListener(getString(R.string.downloaded_files));
        View view = inflater.inflate(R.layout.fragment_downloads, container, false);
        setHasOptionsMenu(true);
        dbHandler = DBHandler.getInstance(getActivity());
        mListView = view.findViewById(R.id.listView);
        AppCompatImageView emptyView = view.findViewById(R.id.empty);
        mListView.setEmptyView(emptyView);  //Set empty view when the size of listView is zero
        //fb banner ads
        adView = new AdView(getActivity(), getString(R.string.fb_banner_id), AdSize.BANNER_HEIGHT_50);

        // Find the Ad Container
        LinearLayout adContainer = view.findViewById(R.id.banner_container);

        // Add the ad view to your activity layout
        adContainer.addView(adView);

        // Request an ad
        adView.loadAd();
        onListItemClickListener();
        fetchList();
        return view;
    }


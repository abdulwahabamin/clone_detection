    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        onNavigationListener.onNavigationItemClickedListener(getString(R.string.search_music));
        View view = inflater.inflate(R.layout.fragment_search, container, false);   // Inflate the layout for this fragment
        setHasOptionsMenu(true);    //Enabling menu for this fragment
        progressBar = view.findViewById(R.id.progressBar);
        mListView = view.findViewById(R.id.listView);
        AppCompatImageView emptyView = view.findViewById(R.id.empty);
        mListView.setEmptyView(emptyView);  //Set empty view when the size of listView is zero
        // Instantiate an InterstitialAd object
        interstitialAd = new InterstitialAd(getActivity(), getString(R.string.fb_fullscreen_ad));
        setFullScreenAds();
        //fb banner ads
        adView = new AdView(getActivity(), getString(R.string.fb_banner_id), AdSize.BANNER_HEIGHT_50);
        // Find the Ad Container
        LinearLayout adContainer = view.findViewById(R.id.banner_container);
        // Add the ad view to your activity layout
        adContainer.addView(adView);
        // Request an ad
        adView.loadAd();
        onListItemClickListener();

        Intent intent = getActivity().getIntent();
        if (Intent.ACTION_SEARCH.equals(intent.getAction())) {
            String query = intent.getStringExtra(SearchManager.QUERY);
            SearchRecentSuggestions suggestions = new SearchRecentSuggestions(getActivity(),
                    SuggestionProvider.AUTHORITY, SuggestionProvider.MODE);
            suggestions.saveRecentQuery(query, null);
        }
        return view;
    }


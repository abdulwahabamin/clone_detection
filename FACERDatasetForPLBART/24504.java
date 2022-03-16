    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Log.i(TAG, "onActivityCreated");

        getLoaderManager().initLoader(0, null, this);

        setBadgeDrawable(getActivity().getResources().getDrawable(R.drawable.app_banner, null));
        setTitle(getString(R.string.applabel));
        setHeadersState(HEADERS_ENABLED);
        setHeadersTransitionOnBackEnabled(true);

        setOnItemViewClickedListener(this);
    }


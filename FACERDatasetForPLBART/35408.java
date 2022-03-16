    @Override
    public void initData() {
        ButterKnife.bind(this);

        Intent intent = getIntent();
        query = intent.getStringExtra(SearchManager.QUERY);
        fm = getSupportFragmentManager();
        SearchResultFragment fragment = (SearchResultFragment) fm.findFragmentById(R.id.fragment_container);
        if (fragment == null) {
            Bundle args = new Bundle();
            args.putString("query",query);
            fragment = SearchResultFragment.newInstance();
            fragment.setArguments(args);
            fm.beginTransaction().add(R.id.fragment_container,fragment).commit();
        }
        mPresenter = new SearchResultPresenter(fragment);
    }


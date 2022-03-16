    /**
     * Method that initializes the component of the activity.
     */
    private void initComponents() {
        //Empty list view
        this.mEmptyListMsg = findViewById(R.id.search_empty_msg);
        //The list view
        this.mSearchListView = (ListView)findViewById(R.id.search_listview);
        this.mSearchListView.setOnItemClickListener(this);
        this.mSearchListView.setOnItemLongClickListener(this);

        // If we should set the listview to response to flinger gesture detection
        boolean useFlinger =
                Preferences.getSharedPreferences().getBoolean(
                        FileManagerSettings.SETTINGS_USE_FLINGER.getId(),
                            ((Boolean)FileManagerSettings.
                                    SETTINGS_USE_FLINGER.
                                        getDefaultValue()).booleanValue());
        if (useFlinger) {
            ((FlingerListView)this.mSearchListView).
                    setOnItemFlingerListener(this.mOnItemFlingerListener);
        }

        //Other components
        this.mSearchWaiting = (ProgressBar)findViewById(R.id.search_waiting);
        mStreamingSearchProgress = (ProgressBar) findViewById(R.id.streaming_progress_bar);
        mStreamingSearchProgress.getIndeterminateDrawable()
                .setColorFilter(Color.WHITE, PorterDuff.Mode.SRC_IN);

        this.mSearchFoundItems = (TextView)findViewById(R.id.search_status_found_items);
        setFoundItems(0, ""); //$NON-NLS-1$
        this.mSearchTerms = (TextView)findViewById(R.id.search_status_query_terms);
        this.mSearchTerms.setText(
                Html.fromHtml(getString(R.string.search_terms, ""))); //$NON-NLS-1$

        // populate Mime Types spinner for search results filtering
        mMimeTypeSpinner = (Spinner) findViewById(R.id.search_status_type_spinner);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                R.layout.search_spinner_item,
                MimeTypeHelper.MimeTypeCategory.getFriendlyLocalizedNames(this));
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mMimeTypeSpinner.setAdapter(adapter);
        mMimeTypeSpinner.setOnItemSelectedListener(this);
    }


    /**
     * Method that initializes the titlebar of the activity.
     */
    private void initSearch() {
        Serializable mimeTypeExtra = getIntent().getSerializableExtra(EXTRA_SEARCH_MIMETYPE);

        if (mimeTypeExtra != null) {
            ArrayList<MimeTypeCategory> categories = (ArrayList<MimeTypeCategory>) getIntent()
                    .getSerializableExtra(EXTRA_SEARCH_MIMETYPE);
            // setting load factor to 1 to avoid the backing map's resizing
            mMimeTypeCategories = new HashSet<MimeTypeCategory>(categories.size(), 1);
            for (MimeTypeCategory category : categories) {
                mMimeTypeCategories.add(category);
            }
        }

        //If data is not present, use root directory to do the search
        this.mSearchDirectory = FileHelper.ROOT_DIRECTORY;
        String searchDirectory = getIntent()
                .getStringExtra(SearchActivity.EXTRA_SEARCH_DIRECTORY);

        if (!TextUtils.isEmpty(searchDirectory)) {
            this.mSearchDirectory = searchDirectory;
        }
        setFoundItems(0, mSearchDirectory);
        //Retrieve the query ¿from voice recognizer?
        boolean voiceQuery = true;
        List<String> userQueries =
                getIntent().getStringArrayListExtra(android.speech.RecognizerIntent.EXTRA_RESULTS);
        if (userQueries == null || userQueries.size() == 0) {
            //From input text
            userQueries = new ArrayList<String>();
            //Recovers and save the last term search in the memory
            Preferences.setLastSearch(getIntent().getStringExtra(SearchManager.QUERY));
            userQueries.add(Preferences.getLastSearch());
            voiceQuery = false;
        }

        //Filter the queries? Needed if queries come from voice recognition
        final List<String> filteredUserQueries =
                (voiceQuery) ? filterQuery(userQueries) : userQueries;

        //Create the queries
        this.mQuery = new Query().fillSlots(filteredUserQueries);
        List<String> queries = this.mQuery.getQueries();

        boolean ask = false;
        // Mime type search uses '*' which needs to bypass
        // length check
        if (mMimeTypeCategories == null) {
            //Check if some queries has lower than allowed, in this case
            //request the user for stop the search
            int cc = queries.size();
            for (int i = 0; i < cc; i++) {
                if (queries.get(i).trim().length() < MIN_CHARS_SEARCH) {
                    ask = true;
                    break;
                }
            }
            mMimeTypeSpinner.setVisibility(View.VISIBLE);
        } else {
            mMimeTypeSpinner.setVisibility(View.INVISIBLE);
        }
        if (ask) {
            askUserBeforeSearch(voiceQuery, this.mQuery, this.mSearchDirectory);
        } else {
            doSearch(voiceQuery, this.mQuery, this.mSearchDirectory);
        }

    }


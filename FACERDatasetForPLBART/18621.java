    /**
     * Initializes the drag sort list view.
     *
     * @param initViewParams Pass true if the ListView is being
     *                       initialized for the very first time
     *                       (dividers, background colors and other
     *                       layout settings will be applied). Pass
     *                       false if the list just needs to be updated
     *                       with the current song.
     */
	private void initListViewAdapter(boolean initViewParams) {

        if (initViewParams) {
            //Reset the initialization flag.
            mInitListViewParams = false;

            if (mApp.getCurrentTheme()==Common.DARK_THEME) {
                mListView.setDivider(mContext.getResources().getDrawable(R.drawable.list_divider));
            } else {
                mListView.setDivider(mContext.getResources().getDrawable(R.drawable.list_divider_light));
            }

            mListView.setDividerHeight(1);
            mListView.setFastScrollEnabled(true);

            //KitKat ListView margins.
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {

                //Calculate navigation bar height.
                int navigationBarHeight = 0;
                int resourceId = getResources().getIdentifier("navigation_bar_height", "dimen", "android");
                if (resourceId > 0) {
                    navigationBarHeight = getResources().getDimensionPixelSize(resourceId);
                }

                mListView.setClipToPadding(false);
                mListView.setPadding(0, 0, 0, navigationBarHeight);

            }

        }

        mListViewAdapter = new QueueDrawerAdapter(mContext, mApp.getService().getPlaybackIndecesList());
        mListView.setAdapter(mListViewAdapter);
        mListView.setOnItemClickListener(onClick);
        mListView.setDropListener(onDrop);
        mListView.setRemoveListener(onRemove);

        SimpleFloatViewManager simpleFloatViewManager = new SimpleFloatViewManager(mListView);
        simpleFloatViewManager.setBackgroundColor(Color.TRANSPARENT);
        mListView.setFloatViewManager(simpleFloatViewManager);

        mListView.setVisibility(View.VISIBLE);
        mEmptyInfoText.setVisibility(View.INVISIBLE);

        /*
         * If the drawer is open, the user is probably scrolling through
         * the list already, so don't move the list to the new position.
         */
        if (!isDrawerOpen())
            mListView.setSelection(mApp.getService().getCurrentSongIndex());

    }


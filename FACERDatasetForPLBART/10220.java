    /**
     * Method that initializes the view
     */
    private void init() {
        //Initialize variables
        this.mFlingRemovePercentaje = DEFAULT_FLING_REMOVE_PERCENTAJE;
        this.mFlingThresholdX = AndroidHelper.convertDpToPixel(
                getContext(), MIN_FLINGER_THRESHOLD_X);
        this.mFlingThresholdY = AndroidHelper.convertDpToPixel(
                getContext(), MIN_FLINGER_THRESHOLD_Y);
        setOnScrollListener(new OnScrollListener() {
            @Override
            public void onScrollStateChanged(AbsListView view, int scrollState) {
                mScrollInAnimation = (scrollState == SCROLL_STATE_FLING);
            }

            @Override
            public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount,
                    int totalItemCount) {
            }
        });
        mScrollInAnimation = false;
    }


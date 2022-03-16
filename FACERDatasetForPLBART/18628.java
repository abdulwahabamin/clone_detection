    /**
     * Called if the audio playback service is not running.
     */
    public void showEmptyTextView() {
        mMiniPlayerLayout.setVisibility(View.GONE);
        mListView.setVisibility(View.INVISIBLE);
        mEmptyInfoText.setVisibility(View.VISIBLE);

    }


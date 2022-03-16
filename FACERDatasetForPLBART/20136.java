    @Override
    public void onSaveInstanceState(final Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString(STATE_TITLE_TEXT, mTitleText);
        outState.putString(STATE_LICENSES_TEXT, mLicensesText);
        outState.putString(STATE_CLOSE_TEXT, mCloseButtonText);
    }


    @Override
    public void onSaveInstanceState(final Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString(STATE_TITLE_TEXT, mTitleText);
        outState.putString(STATE_LICENSE_TEXT, mLicenseText);
        outState.putString(STATE_CLOSE_TEXT, mCloseButtonText);
    }


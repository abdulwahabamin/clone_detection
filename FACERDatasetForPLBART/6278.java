    @Override
    public void onResume() {
        super.onResume();

        if (mState.action == ACTION_MANAGE) {
            mState.showSize = true;
        } else {
            mState.showSize = SettingsActivity.getDisplayFileSize(this);
            invalidateOptionsMenu();
        }
    }


    private void updateDb(final MusicDBProgressCallBack callBack) {
        boolean firstTimeLaunched = sharedPreferences.getBoolean(getString(R.string.first_time_pref_key), true);
        if (firstTimeLaunched) {
            loadingContainer.setVisibility(View.VISIBLE);
            resetFirstTimeFlag();
        } else {
            loadingContainer.setVisibility(View.GONE);
        }
        checkStoragePermission(callBack);
    }


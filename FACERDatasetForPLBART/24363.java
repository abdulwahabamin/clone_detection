    @Override
    protected void onDestroy() {
        if (token != null) MusicUtils.unbindFromService(token);
        service = null;
        PreferenceManager.getDefaultSharedPreferences(this).unregisterOnSharedPreferenceChangeListener(this);

        super.onDestroy();
    }


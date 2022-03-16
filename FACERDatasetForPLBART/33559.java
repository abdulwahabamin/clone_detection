    @Override
    protected void onPrepareDialogBuilder(AlertDialog.Builder builder) {
        int index = findIndexOfValue(getSharedPreferences().getString(getKey(),
                DEFAULT_APP_THEME_VALUE));
        ListAdapter listAdapter = new AppThemeArrayAdapter(getContext(), R.id.app_theme_name,
                getEntries(), resourceIds, index);
        builder.setAdapter(listAdapter, this);
        super.onPrepareDialogBuilder(builder);
    }


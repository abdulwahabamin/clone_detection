        @Override
        public void onReceive(Context context, Intent intent) {
            if (intent != null) {
                if (intent.getAction().compareTo(
                        FileManagerSettings.INTENT_SETTING_CHANGED) == 0) {

                    // The settings has changed
                    String key = intent.getStringExtra(
                            FileManagerSettings.EXTRA_SETTING_CHANGED_KEY);
                    if (key != null) {
                        if (SearchActivity.this.mSearchListView.getAdapter() != null &&
                           (key.compareTo(
                                   FileManagerSettings.
                                       SETTINGS_HIGHLIGHT_TERMS.getId()) == 0 ||
                            key.compareTo(
                                    FileManagerSettings.
                                        SETTINGS_SHOW_RELEVANCE_WIDGET.getId()) == 0 ||
                            key.compareTo(
                                    FileManagerSettings.
                                        SETTINGS_SORT_SEARCH_RESULTS_MODE.getId()) == 0)) {

                            // Recreate the adapter
                            int pos = SearchActivity.
                                        this.mSearchListView.getFirstVisiblePosition();
                            mAdapter.notifyDataSetChanged();
                            SearchActivity.this.mSearchListView.setSelection(pos);
                            return;
                        }
                    }
                } else if (intent.getAction().compareTo(
                        FileManagerSettings.INTENT_THEME_CHANGED) == 0) {
                    applyTheme();
                }
            }
        }


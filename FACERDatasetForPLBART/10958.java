        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.drawer_bookmarks_tab:
                    if (!mBookmarksTab.isSelected()) {
                        mBookmarksTab.setSelected(true);
                        mHistoryTab.setSelected(false);
                        mBookmarksTab.setTextAppearance(
                                NavigationActivity.this, R.style.primary_text_appearance);
                        mHistoryTab.setTextAppearance(
                                NavigationActivity.this, R.style.secondary_text_appearance);
                        mHistoryLayout.setVisibility(View.GONE);
                        mBookmarksLayout.setVisibility(View.VISIBLE);
                        applyTabTheme();

                        try {
                            Preferences.savePreference(FileManagerSettings.USER_PREF_LAST_DRAWER_TAB,
                                    Integer.valueOf(0), true);
                        } catch (Exception ex) {
                            Log.e(TAG, "Can't save last drawer tab", ex); //$NON-NLS-1$
                        }

                        mClearHistory.setVisibility(View.GONE);
                    }
                    break;
                case R.id.drawer_history_tab:
                    if (!mHistoryTab.isSelected()) {
                        mHistoryTab.setSelected(true);
                        mBookmarksTab.setSelected(false);
                        mHistoryTab.setTextAppearance(
                                NavigationActivity.this, R.style.primary_text_appearance);
                        mBookmarksTab.setTextAppearance(
                                NavigationActivity.this, R.style.secondary_text_appearance);
                        mBookmarksLayout.setVisibility(View.GONE);
                        mHistoryLayout.setVisibility(View.VISIBLE);
                        applyTabTheme();

                        try {
                            Preferences.savePreference(FileManagerSettings.USER_PREF_LAST_DRAWER_TAB,
                                    Integer.valueOf(1), true);
                        } catch (Exception ex) {
                            Log.e(TAG, "Can't save last drawer tab", ex); //$NON-NLS-1$
                        }

                        mClearHistory.setVisibility(mHistory.size() > 0 ? View.VISIBLE : View.GONE);
                    }
                    break;
                default:
                    break;
            }
        }


    /**
     * Method that navigates to the passed history reference.
     *
     * @param history The history reference
     * @param isFromSavedHistory Whether this is called by saved history item
     * @return boolean A problem occurs while navigate
     */
    public synchronized boolean navigateToHistory(
            History history, boolean isFromSavedHistory) {
        try {
            //Gets the history
            final History realHistory;
            if (isFromSavedHistory) {
                realHistory = mHistorySaved.get(history.getPosition());
            } else {
                realHistory = mHistory.get(history.getPosition());
            }

            //Navigate to item. Check what kind of history is
            if (realHistory.getItem() instanceof NavigationViewInfoParcelable) {
                //Navigation
                NavigationViewInfoParcelable info =
                        (NavigationViewInfoParcelable)realHistory.getItem();
                int viewId = info.getId();
                NavigationView view = getNavigationView(viewId);
                // Selected items must not be restored from on history navigation
                info.setSelectedFiles(view.getSelectedFiles());
                if (!view.onRestoreState(info)) {
                    return true;
                }

            } else if (realHistory.getItem() instanceof SearchInfoParcelable) {
                //Search (open search with the search results)
                SearchInfoParcelable info = (SearchInfoParcelable)realHistory.getItem();
                Intent searchIntent = new Intent(this, SearchActivity.class);
                searchIntent.setAction(SearchActivity.ACTION_RESTORE);
                searchIntent.putExtra(SearchActivity.EXTRA_SEARCH_RESTORE, (Parcelable)info);
                startActivityForResult(searchIntent, INTENT_REQUEST_SEARCH);
            } else if (realHistory.getItem() instanceof HistoryItem) {
                final String path = realHistory.getItem().getDescription();
                final FileSystemObject fso = CommandHelper.getFileInfo(
                        getApplicationContext(), path, null);
                if (fso != null) {
                    performHideEasyMode();
                    performShowBackArrow(
                            !mDrawerToggle.isDrawerIndicatorEnabled());
                    getCurrentNavigationView().open(fso);
                    mDrawerLayout.closeDrawer(Gravity.START);
                }
            } else {
                //The type is unknown
                throw new IllegalArgumentException("Unknown history type"); //$NON-NLS-1$
            }

            //Remove the old history
            int cc = realHistory.getPosition();
            for (int i = this.mHistory.size() - 1; i >= cc; i--) {
                this.mHistory.remove(i);
            }

            if (mDrawerHistory.getChildCount() == 0) {
                mDrawerHistoryEmpty.setVisibility(View.VISIBLE);
            }

            //Navigate
            final boolean clearHistory =
                    mHistoryTab.isSelected() && mHistorySaved.size() > 0;
            mClearHistory.setVisibility(clearHistory ? View.VISIBLE : View.GONE);
            return true;

        } catch (Throwable ex) {
            if (history != null) {
                Log.e(TAG,
                        String.format("Failed to navigate to history %d: %s", //$NON-NLS-1$
                                Integer.valueOf(history.getPosition()),
                                history.getItem().getTitle()), ex);
            } else {
                Log.e(TAG,
                        String.format("Failed to navigate to history: null", ex)); //$NON-NLS-1$
            }
            this.mHandler.post(new Runnable() {
                @Override
                public void run() {
                    DialogHelper.showToast(
                            NavigationActivity.this,
                            R.string.msgs_history_unknown, Toast.LENGTH_LONG);
                }
            });

            //Not change directory
            return false;
        }
    }


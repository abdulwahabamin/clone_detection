    /**
     * Method that remove the {@link FileSystemObject} from the history
     */
    private void removeFromHistory(FileSystemObject fso) {
        if (this.mHistory != null) {
            int cc = this.mHistory.size() - 1;
            for (int i = cc; i >= 0 ; i--) {
                History history = this.mHistory.get(i);
                if (history.getItem() instanceof NavigationViewInfoParcelable) {
                    String p0 = fso.getFullPath();
                    String p1 = ((NavigationViewInfoParcelable) history.getItem()).getCurrentDir();
                    if (p0.compareTo(p1) == 0) {
                        this.mHistory.remove(i);
                        mDrawerHistory.removeViewAt(mDrawerHistory.getChildCount() - i - 1);
                        mDrawerHistoryEmpty.setVisibility(
                                mDrawerHistory.getChildCount() == 0 ? View.VISIBLE : View.GONE);
                        updateHistoryPositions();
                    }
                }
            }
        }
    }


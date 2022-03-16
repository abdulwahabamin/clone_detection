    /**
     * {@inheritDoc}
     */
    @Override
    public void onNewHistory(HistoryNavigable navigable) {
        //Recollect information about current status
        History history = new History(this.mHistory.size(), navigable);
        this.mHistory.add(history);
        if (!shouldAddHistory(navigable)) {
            return;
        }
        // Show history in the navigation drawer
        addHistoryToDrawer(this.mHistory.size() - 1, navigable);
        mHistorySaved.add(history);
        // Add history to the database
        addHistory(navigable);
    }


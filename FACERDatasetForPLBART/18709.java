    /**
     * Refreshes the ListView with the current dataset.
     */
    public void refreshListView() {
        //Update the ListView.
        getDir(currentDir, listView.onSaveInstanceState());
    }


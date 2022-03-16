    /**
     * Method that opens the actions dialog
     *
     * @param item The path or the {@link FileSystemObject}
     * @param global If the menu to display is the one with global actions
     */
    private void openActionsDialog(FileSystemObject item, boolean global) {
        // We used to refresh the item reference here, but the access to the SecureConsole is synchronized,
        // which can/will cause on ANR in certain scenarios.  We don't care if it doesn't exist anymore really
        // For this to work, SecureConsole NEEDS to be refactored.

        // Show the dialog
        if (mActionsDialog != null && mActionsDialog.isShowing()) {
            return;
        }
        mActionsDialog = new ActionsDialog(this, this, item, global, false);
        mActionsDialog.setOnRequestRefreshListener(this);
        mActionsDialog.setOnSelectionListener(getCurrentNavigationView());
        mActionsDialog.show();
    }


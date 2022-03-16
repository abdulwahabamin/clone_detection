    /**
     * Method invoked when a request to show the menu associated
     * with an item is started.
     *
     * @param item The item for which the request was started
     */
    public void onRequestMenu(FileSystemObject item) {
        // Prior to show the dialog, refresh the item reference
        FileSystemObject fso = null;
        try {
            fso = CommandHelper.getFileInfo(this, item.getFullPath(), false, null);
            if (fso == null) {
                throw new NoSuchFileOrDirectory(item.getFullPath());
            }

        } catch (Exception e) {
            // Notify the user
            ExceptionUtil.translateException(this, e);

            // Remove the object
            if (e instanceof FileNotFoundException || e instanceof NoSuchFileOrDirectory) {
                removeItem(item);
            }
            return;
        }

        ActionsDialog dialog = new ActionsDialog(this, null, fso, false, true);
        dialog.setOnRequestRefreshListener(this);
        dialog.show();
    }


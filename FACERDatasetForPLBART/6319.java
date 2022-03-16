    public void onPasteRequested() {
        if (mClipboardFiles == null) {
            return;
        }

        // Run the corresponding asynctask
        new CopyOrCutFilesTask(mClipboardFiles.toArray(new DocumentInfo[0])).executeOnExecutor(getCurrentExecutor());

        // Clear the copy buffer
        mClipboardFiles = null;
    }


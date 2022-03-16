    /**
     * Method that compresses the list of files of the selection.
     *
     * @param ctx The current context
     * @param onSelectionListener The listener for obtain selection information (required)
     * @param onRequestRefreshListener The listener for request a refresh (optional)
     * @hide
     */
    public static void compress(
            final Context ctx,
            final OnSelectionListener onSelectionListener,
            final OnRequestRefreshListener onRequestRefreshListener) {

        // Retrieve the current selection
        final List<FileSystemObject> selection = onSelectionListener.onRequestSelectedFiles();
        if (selection != null && selection.size() > 0) {
            // Show a dialog to allow the user make the compression mode choice
            final String[] labels = getSupportedCompressionModesLabels(ctx, selection);
            AlertDialog dialog = DialogHelper.createSingleChoiceDialog(
                    ctx, R.string.compression_mode_title,
                    labels,
                    CompressionMode.AC_GZIP.ordinal(),
                    new DialogHelper.OnSelectChoiceListener() {
                        @Override
                        public void onSelectChoice(int choice) {
                            // Do the compression
                            compress(
                                    ctx,
                                    getCompressionModeFromUserChoice(ctx, labels, choice),
                                    selection,
                                    onSelectionListener,
                                    onRequestRefreshListener);
                        }

                        @Override
                        public void onNoSelectChoice() {/**NON BLOCK**/}
                    });
            DialogHelper.delegateDialogShow(ctx, dialog);
        }
    }


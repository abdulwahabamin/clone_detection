    /**
     * Method that compresses an uncompressed file.
     *
     * @param ctx The current context
     * @param fso The compressed file
     * @param onSelectionListener The listener for obtain selection information (required)
     * @param onRequestRefreshListener The listener for request a refresh (optional)
     * @hide
     */
    public static void compress(
            final Context ctx, final FileSystemObject fso,
            final OnSelectionListener onSelectionListener,
            final OnRequestRefreshListener onRequestRefreshListener) {

        // Create a list with the item
        final List<FileSystemObject> items = new ArrayList<FileSystemObject>();
        items.add(fso);

        // Show a dialog to allow the user make the compression mode choice
        final String[] labels = getSupportedCompressionModesLabels(ctx, items);
        AlertDialog dialog = DialogHelper.createSingleChoiceDialog(
                ctx, R.string.compression_mode_title,
                getSupportedCompressionModesLabels(ctx, items),
                CompressionMode.AC_GZIP.ordinal(),
                new DialogHelper.OnSelectChoiceListener() {
                    @Override
                    public void onSelectChoice(int choice) {
                        // Do the compression
                        compress(
                                ctx,
                                getCompressionModeFromUserChoice(ctx, labels, choice),
                                items,
                                onSelectionListener,
                                onRequestRefreshListener);
                    }

                    @Override
                    public void onNoSelectChoice() {/**NON BLOCK**/}
                });
        DialogHelper.delegateDialogShow(ctx, dialog);
    }


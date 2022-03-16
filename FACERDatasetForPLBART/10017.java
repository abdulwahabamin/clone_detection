    /**
     * Method that remove an existing file system object.
     *
     * @param ctx The current context
     * @param files The list of files to remove
     * @param onSelectionListener The listener for obtain selection information (required)
     * @param onRequestRefreshListener The listener for request a refresh (optional)
     * @param onItemFlingerResponder The flinger responder, only if the action was initialized
     * by a flinger gesture (optional)
     */
    public static void removeFileSystemObjects(
            final Context ctx, final List<FileSystemObject> files,
            final OnSelectionListener onSelectionListener,
            final OnRequestRefreshListener onRequestRefreshListener,
            final OnItemFlingerResponder onItemFlingerResponder) {

        // inform of the number of FSOs that will be deleted
        int numberOfItemsSelected = files.size();
        StringBuilder messageBuilder = new StringBuilder(
            ctx.getResources().getQuantityString(
                R.plurals.deleting_n_items,
                numberOfItemsSelected,
                numberOfItemsSelected
            )
        )
        .append('\n')
        .append(ctx.getString(R.string.actions_ask_undone_operation_msg));

        // Ask the user before remove
        AlertDialog dialog = DialogHelper.createYesNoDialog(
            ctx,
            R.string.confirm_deletion,
            messageBuilder.toString(),
            new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface alertDialog, int which) {
                    if (which == DialogInterface.BUTTON_POSITIVE) {
                        // Remove the items
                        removeFileSystemObjectsInBackground(
                                ctx,
                                files,
                                onSelectionListener,
                                onRequestRefreshListener,
                                onItemFlingerResponder);
                    } else {
                        // Flinger operation should be cancelled
                        if (onItemFlingerResponder != null) {
                            onItemFlingerResponder.cancel();
                        }
                    }
                }
           });
        DialogHelper.delegateDialogShow(ctx, dialog);
    }


    private void onDeleteDocuments(final List<DocumentInfo> docs) {
        final Context context = getActivity();
        final ContentResolver resolver = context.getContentResolver();
        final Resources resources = context.getResources();

        // Open a confirmation dialog
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        builder.setPositiveButton(R.string.ok, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                new DeleteFilesTask(docs.toArray(new DocumentInfo[0])).executeOnExecutor(getCurrentExecutor());
            }
        });
        builder.setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                // User cancelled the dialog, ignore actions
            }
        });

        builder.setTitle(R.string.dialog_delete_confirm_title)
            .setMessage(resources.getQuantityString(R.plurals.dialog_delete_confirm_message, docs.size(), docs.size()));

        AlertDialog dialog = builder.create();
        dialog.show();
    }


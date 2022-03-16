    protected void showDeleteDialog(final int position) {
        LayoutInflater layoutInflater = LayoutInflater.from(MainActivity.this);
        View promptView = layoutInflater.inflate(R.layout.delete_file_dialog, null);
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(MainActivity.this);
        alertDialogBuilder.setView(promptView);

        File selectedFile = mAdapter.getFile(position);
        String fileType = selectedFile.isDirectory() ? "folder" : "file";

        TextView confirmText = (TextView) promptView.findViewById(R.id.deleteFileConfirmTextView);
        confirmText.setText(String.format(getResources().getString(R.string.delete_confirm_prompt),
                fileType, selectedFile.getName()));

        alertDialogBuilder.setCancelable(false)
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        deleteFile(position);
                    }
                })
                .setNegativeButton("CANCEL", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                });

        alertDialogBuilder.create().show();
    }


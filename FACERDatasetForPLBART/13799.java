    private void deleteFile(final Uri uri, final String name, final int position) {
        AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(getContext())
                .setTitle(getContext().getString(R.string.delete) + " " + name)
                .setMessage(R.string.delete_message)
                .setPositiveButton(R.string.delete, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        File file = new File(uri.getPath());
                        if (file.exists()) {
                            if (file.delete()) {
                                getContext().sendBroadcast(new Intent(Intent.ACTION_MEDIA_SCANNER_SCAN_FILE, Uri.fromFile(file)));
                                musicArrayList.remove(getItem(position));
                                filteredMusicArrayList.remove(position);
                                Toast.makeText(getContext(), "Deleted " + name, Toast.LENGTH_SHORT).show();
                                notifyDataSetChanged();
                            } else {
                                Toast.makeText(getContext(), "Can't Delete " + name, Toast.LENGTH_SHORT).show();
                            }
                        }
                    }
                }).setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
        AlertDialog deleteDialog = dialogBuilder.create();
        deleteDialog.show();
    }


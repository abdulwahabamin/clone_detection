    public StorageSelectDialog(final Context context) {
        mStorages = getAvailableStorages(context);
        String[] names = new String[mStorages.length];
        for (int i = 0; i < mStorages.length; i++) {
            names[i] = mStorages[i].getName();
        }
        mDialog = new AlertDialog.Builder(context)
                .setItems(names, this)
                .setNegativeButton(android.R.string.cancel, null)
                .setNeutralButton(R.string.menu_show_as_entry_default, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        mDirSelectListener.onDirSelected(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_MUSIC));
                    }
                })
                .setCancelable(true)
                .setTitle(R.string.select_storage)
                .create();
    }


    @Override
    public void onAppBackupClicked(View view, int position) {
        AppModel appModel = adapter.getItem(position);
        File ogFile = appModel.getBackupFile();
        if (ogFile != null) {
            // Performing backup operation for
            File destDir = new File(new File(Environment.getExternalStorageDirectory(), "backups"), "apps");
            presenter.backUpApp(ogFile, destDir);
        } else {
            Snackbar.make(view, "Original apk file not found", Snackbar.LENGTH_LONG)
                    .show();
        }
    }


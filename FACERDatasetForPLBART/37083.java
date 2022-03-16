    private void onDownloadSuccess(Context context, Intent intent) {
        DownloadManager manager = (DownloadManager) context.getSystemService(Context.DOWNLOAD_SERVICE);
        long id = intent.getLongExtra(DownloadManager.EXTRA_DOWNLOAD_ID, 0);
        DownloadManager.Query query = new DownloadManager.Query();
        query.setFilterById(id);
        Cursor cursor = manager.query(query);
        if (cursor == null) {
            return;
        }

        if (cursor.moveToFirst()) {
            String fileUri = cursor.getString(cursor.getColumnIndex(DownloadManager.COLUMN_LOCAL_URI));
            if (fileUri != null) {
                File file = new File(Uri.parse(fileUri).getPath());
                if (file.exists()) {
                    install(context, file);
                }
            }
        }
        cursor.close();
    }


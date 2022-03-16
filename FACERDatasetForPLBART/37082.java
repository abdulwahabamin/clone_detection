    @Override
    public void onReceive(Context context, Intent intent) {
        String action = intent.getAction();
        if (action.equals(DownloadManager.ACTION_DOWNLOAD_COMPLETE)) {
            try {
                onDownloadSuccess(context, intent);
            } catch (Exception e) {
                e.printStackTrace();
                Toast.makeText(context, "自动安装失败，请进入/Download/目录下手动安装", Toast.LENGTH_SHORT).show();
            }
        } else if (action.equals(DownloadManager.ACTION_NOTIFICATION_CLICKED)) {
            // 点击通知�?�消下载
            DownloadManager manager = (DownloadManager) context.getSystemService(Context.DOWNLOAD_SERVICE);
            long[] ids = intent.getLongArrayExtra(DownloadManager.EXTRA_NOTIFICATION_CLICK_DOWNLOAD_IDS);
            manager.remove(ids);
            Toast.makeText(context, "已�?�消下载", Toast.LENGTH_SHORT).show();
        }
    }


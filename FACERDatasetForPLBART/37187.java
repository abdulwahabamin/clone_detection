    private static void download(Activity activity, UpdateInfo updateInfo) {
        String fileName = String.format("PonyWeather_%s.apk", updateInfo.versionShort);
        DownloadManager downloadManager = (DownloadManager) activity.getSystemService(Context.DOWNLOAD_SERVICE);
        Uri uri = Uri.parse(updateInfo.installUrl);
        DownloadManager.Request request = new DownloadManager.Request(uri);
        request.setTitle(activity.getString(R.string.app_name));
        request.setDescription("正在更新…");
        request.setDestinationInExternalPublicDir(Environment.DIRECTORY_DOWNLOADS, fileName);
        request.setMimeType(MimeTypeMap.getFileExtensionFromUrl(updateInfo.installUrl));
        request.allowScanningByMediaScanner();
        request.setAllowedNetworkTypes(DownloadManager.Request.NETWORK_MOBILE | DownloadManager.Request.NETWORK_WIFI);
        request.setAllowedOverRoaming(false);// �?�?许漫游
        downloadManager.enqueue(request);
        SnackbarUtils.show(activity, "正在�?��?�下载");
    }


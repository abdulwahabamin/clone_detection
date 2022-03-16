    public static void download(Context context, String url, String name) {

        String extension = url.substring(url.lastIndexOf("."));
        String fileName = name + extension;
        Toast.makeText(context, "Downloading " + fileName, Toast.LENGTH_SHORT).show();

        DownloadManager downloadManager = (DownloadManager) context.getSystemService(Context.DOWNLOAD_SERVICE);
        Uri uri = Uri.parse(url);
        File file = new File(SharedPrefUtils.getDownloadedFolder(context) + File.separator + fileName);

        DownloadManager.Request request = new DownloadManager.Request(uri);
        request.setAllowedNetworkTypes(DownloadManager.Request.NETWORK_WIFI | DownloadManager.Request.NETWORK_MOBILE);
        request.setAllowedOverRoaming(true);
        request.setTitle("Downloading " + fileName);
        request.setDescription("Music App");
        request.setVisibleInDownloadsUi(true);
        request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);
        request.setDestinationUri(Uri.fromFile(file));

        long refId = downloadManager.enqueue(request);
    }


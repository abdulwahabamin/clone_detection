    public void proceedAfterPermission() {
        //We've got the permission, now we can proceed further
        Toast.makeText(context, "Downloading", Toast.LENGTH_SHORT).show();
        downloadManager = (DownloadManager) context.getSystemService(Context.DOWNLOAD_SERVICE);
        Uri uri = Uri.parse(name);
        String nameoffile= URLUtil.guessFileName(name,null, MimeTypeMap.getFileExtensionFromUrl(name));
        DownloadManager.Request request = new DownloadManager.Request(uri);
        request.setTitle(song);
        request.setDescription("Thanks for Downloading");
        request.allowScanningByMediaScanner();
        request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);
        request.setDestinationInExternalPublicDir(Environment.DIRECTORY_DOWNLOADS,nameoffile);
        DownloadManager manager=(DownloadManager)context.getSystemService(Context.DOWNLOAD_SERVICE);
        manager.enqueue(request);
    }


    public static File getOutputMediaFile(Context context,String filename) {
        // To be safe, you should check that the SDCard is mounted
        // using Environment.getExternalStorageState() before doing this.
        File mediaStorageDir = new File(
                Environment
                        .getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES),
                getFolderName());
        // This location works best if you want the created images to be shared
        // between applications and persist after your app has been uninstalled.

        // Create the storage directory if it does not exist
        if (!mediaStorageDir.exists()) {
            if (!mediaStorageDir.mkdirs()) {
                Log.d("file", "failed to create directory");
                return null;
            }
        }
        // Create a media file name

        File mediaFile;


        if (filename==null || filename.isEmpty()) {
            String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss")
                    .format(new Date());
            filename = "IMG_" + timeStamp;
        }

        mediaFile = new File(mediaStorageDir.getPath() + File.separator
                +filename+".jpg");

        Intent intent = new Intent(Intent.ACTION_MEDIA_SCANNER_SCAN_FILE);
        Uri uri = Uri.fromFile(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES));
        intent.setData(uri);
        context.sendBroadcast(intent);
        return mediaFile;
    }


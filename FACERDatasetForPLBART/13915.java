    public static String getDownloadedFolder(Context context) {
        return !TextUtils.isEmpty(getSharedPref(AppConstant.DOWNLOADED_DIRECTORY, context)) ?
                getSharedPref(AppConstant.DOWNLOADED_DIRECTORY, context) :
                Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS).getPath();

    }


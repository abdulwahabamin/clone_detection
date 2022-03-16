    /**
     * 如果有外部存储，则返回外部存储路径，没有则使用内部存储的cache路径
     * @param context
     * @param uniqueName
     * @return
     */
    public File getCacheDir(Context context, String uniqueName) {
        // Check if media is mounted or storage is built-in, if so, try and use external cache dir
        // otherwise use internal cache dir
        final String cachePath =
                isExternalStorageWriteable() ||
                        !isExternalStorageRemovable() ? getExternalCacheDir().getPath() :
                        context.getCacheDir().getPath();

        return new File(cachePath + File.separator + uniqueName);
    }


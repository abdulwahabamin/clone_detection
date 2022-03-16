    public static File getSDCardDir(Context context, String dirName) {
        if (Environment.MEDIA_MOUNTED.equals(Environment.getExternalStorageState())
                || !Environment.isExternalStorageRemovable()) {
            return new File(context.getExternalCacheDir().getPath() + File.separator + dirName);
        }

        return null;
    }


    public static Drawable getApkIcon(Context context, String APKFilePath) {
        //String APKFilePath = "mnt/sdcard/myapkfile.apk"; //For example...
        PackageManager pm = context.getPackageManager();
        PackageInfo pi = pm.getPackageArchiveInfo(APKFilePath, 0);

        // the secret are these two lines....
        pi.applicationInfo.sourceDir       = APKFilePath;
        pi.applicationInfo.publicSourceDir = APKFilePath;
        //

        Drawable APKicon = pi.applicationInfo.loadIcon(pm);
        //String   AppName = (String)pi.applicationInfo.loadLabel(pm);
        return APKicon;
    }


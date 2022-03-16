    /**
     * 获�?�apk包的信�?�：版本�?�，�??称，图标等
     *
     * @param absPath apk包的�?对路径
     * @param context
     */
    public ApkDetial apkInfo(String absPath, Context context) {
        PackageManager pm = context.getPackageManager();
        PackageInfo pkgInfo = pm.getPackageArchiveInfo(absPath, PackageManager.GET_ACTIVITIES);
        ApkDetial detial = new ApkDetial();
        if (pkgInfo != null) {
            ApplicationInfo appInfo = pkgInfo.applicationInfo;
            /* 必须加这两�?�，�?然下�?�icon获�?�是default icon而�?是应用包的icon */
            appInfo.sourceDir = absPath;
            appInfo.publicSourceDir = absPath;
            detial.setName(pm.getApplicationLabel(appInfo).toString());// 得到应用�?? 
            detial.setVersion(pkgInfo.versionName); // 得到版本信�?�
            detial.setIcon(pm.getApplicationIcon(appInfo));// 得到图标信�?�

        }
        return detial;
    }


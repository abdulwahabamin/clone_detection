    /**
     * Fetches all Installed apps from device
     *
     * @return list of installed app containing PackageName, Icon, AppName, LaunchingIntent & apkFileLocation
     */
    public Single<List<AppModel>> getAllInstalledApps() {
        return Single.fromCallable(new Callable<List<AppModel>>() {
            @Override
            public List<AppModel> call() throws Exception {
                List<AppModel> appModelList = new ArrayList<>();
                List<PackageInfo> packages = packageManager.getInstalledPackages(0);

                for (PackageInfo info : packages) {
                    if (!isSystemPackage(info)) {
                        // Get icon for app
                        Drawable icon = null;
                        try {
                            icon = packageManager.getApplicationIcon(info.packageName);
                            icon = scaleImage(icon, APP_ICON_SIZE_FACTOR);
                        } catch (PackageManager.NameNotFoundException e) {
                            e.printStackTrace();
                        }
                        // Get app name
                        String appName = null;
                        try {
                            appName = packageManager.getApplicationLabel(info.applicationInfo).toString();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        // Get launch intent for package
                        Intent intent = packageManager.getLaunchIntentForPackage(info.packageName);
                        // Get file for backup
                        File file = new File(info.applicationInfo.publicSourceDir);
                        if (!file.exists())
                            file = null;

                        AppModel appModel = new AppModel();
                        appModel.setPackageName(info.packageName);
                        appModel.setAppIcon(icon);
                        appModel.setAppName(appName);
                        appModel.setLaunchIntent(intent);
                        appModel.setBackupFile(file);

                        appModelList.add(appModel);
                    }
                }

                Collections.sort(appModelList, new AppComparator());

                return appModelList;
            }
        });
    }


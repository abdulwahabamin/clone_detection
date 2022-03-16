    /**
     * @param mContext
     * @param view
     * @param resourceName
     * @param themeType
     */
    public static void initThemeChooser(Context mContext, View view, String resourceName,
            int themeType) {
        String themePackage = getThemePackageName(mContext, APOLLO);
        PackageManager pm = mContext.getPackageManager();
        Resources themeResources = null;
        if (!themePackage.equals(APOLLO)) {
            try {
                themeResources = pm.getResourcesForApplication(themePackage);
            } catch (NameNotFoundException e) {
                setThemePackageName(mContext, APOLLO);
            }
        }

        if (themeResources != null)
            loadThemeResource(themeResources, themePackage, resourceName, view, themeType);
    }


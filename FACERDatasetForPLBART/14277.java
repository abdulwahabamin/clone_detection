    /**
     * @param mContext
     * @param view
     * @param resourceName
     */
    public static void setProgessDrawable(Context mContext, SeekBar view, String resourceName) {
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
        if (themeResources != null) {
            int resourceID = themeResources.getIdentifier(resourceName, "drawable", themePackage);
            if (resourceID != 0) {
                view.setProgressDrawable(themeResources.getDrawable(resourceID));
            }
        }
    }


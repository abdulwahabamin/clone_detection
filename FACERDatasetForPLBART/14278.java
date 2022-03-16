    /**
     * @param mContext
     * @return which overflow icon to use
     */
    public static boolean overflowLight(Context mContext) {
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
            int resourceID = themeResources.getIdentifier("overflow.light", "bool", themePackage);
            if (resourceID != 0) {
                Boolean overflow = themeResources.getBoolean(resourceID);
                if (overflow)
                    return true;
            }
        }
        return false;
    }


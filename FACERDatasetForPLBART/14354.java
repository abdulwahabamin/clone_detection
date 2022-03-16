    /**
     * @param packageName
     */
    public void setTheme(CharSequence packageName) {
        themePackageName = packageName;
        themeName = null;
        themeDescription = null;
        if (themePreview != null)
            themePreview.setCallback(null);
        themePreview = null;
        if (!packageName.equals(APOLLO)) {
            Resources themeResources = null;
            try {
                themeResources = getContext().getPackageManager().getResourcesForApplication(
                        packageName.toString());
            } catch (NameNotFoundException e) {
                e.printStackTrace();
            }
            if (themeResources != null) {
                int themeNameId = themeResources.getIdentifier(THEME_TITLE, "string",
                        packageName.toString());
                if (themeNameId != 0) {
                    themeName = themeResources.getString(themeNameId);
                }
                int themeDescriptionId = themeResources.getIdentifier(THEME_DESCRIPTION, "string",
                        packageName.toString());
                if (themeDescriptionId != 0) {
                    themeDescription = themeResources.getString(themeDescriptionId);
                }
                int themePreviewId = themeResources.getIdentifier(THEME_PREVIEW, "drawable",
                        packageName.toString());
                if (themePreviewId != 0) {
                    themePreview = themeResources.getDrawable(themePreviewId);
                }
            }
        }
        if (themeName == null)
            themeName = getContext().getResources().getString(R.string.apollo_themes);
        if (themeDescription == null)
            themeDescription = getContext().getResources().getString(R.string.themes);
        notifyChanged();
    }


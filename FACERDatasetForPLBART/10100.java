    /**
     * Method that returns the list of available themes for the file manager app.
     *
     * @param ctx The current context
     * @return List<Theme> List of themes
     */
    public static List<Theme> getAvailableThemes(Context ctx) {
        Intent intent = new Intent(ACTION_MAIN_THEME);
        intent.addCategory(CATEGORY_THEME);
        if (DEBUG) {
            intent.addFlags(Intent.FLAG_DEBUG_LOG_RESOLUTION);
        }

        // Obtain the list of packages that matches with theme requirements for register as
        // a file manager theme
        PackageManager pm = ctx.getPackageManager();
        List<ResolveInfo> result =
                pm.queryIntentActivities(intent, 0);

        // Read now the information about the themes
        List<Theme> themes = new ArrayList<Theme>();
        int cc = result.size();
        for (int i = 0; i < cc; i++) {
            try {
                ResolveInfo info = result.get(i);
                String appPackage = info.activityInfo.packageName;

                // Check permission for read theme
                String appPermission = info.activityInfo.permission;
                if (appPermission == null || appPermission.compareTo(PERMISSION_READ_THEME) != 0) {
                    Log.w(TAG, String.format(
                            "\"%s\" hasn't READ_THEME permission. Ignored.", //$NON-NLS-1$
                            appPackage));
                    continue;
                }

                Resources appResources = pm.getResourcesForApplication(appPackage);
                if (appResources != null) {
                    // We need the ids, names, descriptions and author of every
                    // theme in the application

                    //- Identifiers
                    int identifiers =
                            appResources.getIdentifier(
                                    RESOURCE_THEMES_IDS,
                                    "array", //$NON-NLS-1$
                                    appPackage);
                    if (identifiers == 0) continue;
                    String[] ids = appResources.getStringArray(identifiers);

                    //- Name
                    int namesId =
                            appResources.getIdentifier(
                                    RESOURCE_THEMES_NAMES,
                                    "array", //$NON-NLS-1$
                                    appPackage);
                    if (namesId == 0) continue;
                    String[] names = appResources.getStringArray(namesId);

                    //- Descriptions
                    int descriptionsId =
                            appResources.getIdentifier(
                                    RESOURCE_THEMES_DESCRIPTIONS,
                                    "array", //$NON-NLS-1$
                                    appPackage);
                    if (descriptionsId == 0) continue;
                    String[] descriptions = appResources.getStringArray(descriptionsId);

                    //- Author
                    int authorId =
                            appResources.getIdentifier(
                                    RESOURCE_THEMES_AUTHOR,
                                    "string", //$NON-NLS-1$
                                    appPackage);
                    if (authorId == 0) continue;
                    String author = appResources.getString(authorId);

                    // Get the resources and the context
                    Context context = ctx.createPackageContext(
                            appPackage, Context.CONTEXT_RESTRICTED);
                    Resources resources = pm.getResourcesForApplication(appPackage);

                    // Add every theme found
                    for (int j = 0; j < names.length; j++) {
                        Theme theme = new Theme();
                        theme.mPackage = appPackage;
                        theme.mId = ids[j];
                        theme.mName = names[j];
                        theme.mDescription = descriptions[j];
                        theme.mAuthor = author;
                        theme.mContext = context;
                        theme.mResources = resources;
                        themes.add(theme);

                        if (DEBUG) {
                            Log.v(TAG, String.format("Found theme: %s", theme)); //$NON-NLS-1$
                        }
                    }
                }

            } catch (Exception e) {/**NON BLOCK**/}
        }

        // Return the themes found
        themes.add(0, getDefaultTheme(ctx));
        return themes;
    }


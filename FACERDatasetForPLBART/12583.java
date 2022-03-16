    /**
     * Method that register the {@link FileSystemObject} that allow external apps to access
     * private files. An authorization MUST be explicit done by this app. Third party apps
     * can register
     *
     * @param uri The authorized uri
     * @param pkg The package to authorize
     */
    public static void grantAuthorizationUri(Uri uri, String pkg) {
        // Check that exists that authorization
        AuthorizationResource authResource = getAuthorizacionResourceForUri(uri);
        if (authResource == null) {
            throw new SecurityException("Authorization not exists");
        }

        // Check that the authorization doesn't was granted before
        if (authResource.mPackage != null) {
            throw new SecurityException("The authorization was granted before");
        }

        // And now grant the access
        Log.i(TAG, "grant authorization of uri " + uri.toString() + " to package " + pkg);
        authResource.mPackage = pkg;
    }


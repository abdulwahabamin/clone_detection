    /**
     * Method that unregister un-granted authorizations.
     *
     * @param uri The authorized uri
     */
    public static AuthorizationResource revertAuthorization(Uri uri) {
        // Check that exists that authorization
        AuthorizationResource authResource = getAuthorizacionResourceForUri(uri);
        if (authResource == null) {
            throw new SecurityException("Authorization not exists");
        }

        // Check that the authorization was granted before
        if (authResource.mPackage != null) {
            throw new SecurityException("The authorization was granted before");
        }

        // And now remove the un-granted authorization
        UUID uuid = UUID.fromString(uri.getLastPathSegment());
        return AUTHORIZATIONS.remove(uuid);
    }


    /**
     * Method that returns an authorization for the passed Uri.
     *
     * @param uri The uri to check
     * @param revoke Whether revoke the grant
     * @return AuthorizationResource The authorization resource or null if not there is not
     * authorization
     */
    private static AuthorizationResource getAuthorizacionResourceForUri(Uri uri) {
        UUID uuid = UUID.fromString(uri.getLastPathSegment());
        if (uuid == null || !AUTHORIZATIONS.containsKey(uuid)) {
            return null;
        }
        return AUTHORIZATIONS.get(uuid);
    }


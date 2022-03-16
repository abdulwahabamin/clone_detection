    /**
     * Method that returns an authorization URI from the authorization UUID
     *
     * @param uuid The UUID of the authorization
     * @return Uri The authorization Uri
     */
    private static Uri createAuthorizationUri(UUID uuid) {
        return Uri.withAppendedPath(Uri.parse(CONTENT_AUTHORITY),
                uuid.toString());
    }


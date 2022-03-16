    /**
     * This method creates an authorization uri for a file, but this not grants
     * access to this file. Callers must explicitly call to grantAuthorization in
     * order to set the package associated with this grant
     *
     * @param fso The file to authorize
     * @return Uri The uri of this authorized resource
     */
    public static Uri createAuthorizationUri(RegularFile file) {
        // Generate a new authorization for the filesystem
        UUID uuid = null;
        do {
            uuid = UUID.randomUUID();
            if (!AUTHORIZATIONS.containsKey(uuid)) {
                AuthorizationResource resource = new AuthorizationResource(file);
                AUTHORIZATIONS.put(uuid, resource);
                break;
            }
        } while(true);

        // Post a message to clear authorization after an interval of time
        Message msg = Message.obtain(CLEAR_AUTH_HANDLER, MSG_CLEAR_AUTHORIZATIONS);
        Bundle bundle = new Bundle();
        bundle.putString(EXTRA_AUTH_ID, uuid.toString());
        msg.setData(bundle);
        CLEAR_AUTH_HANDLER.sendMessageDelayed(msg, MAX_AUTH_LIVE_TIME);
        return createAuthorizationUri(uuid);
    }


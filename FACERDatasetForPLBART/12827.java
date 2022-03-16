    /**
     * Method that add grant access to secure resources if needed
     *
     * @param intent The intent to grant access
     * @param ri The resolved info associated with the intent
     */
    public static final void grantSecureAccessIfNeeded(Intent intent, ResolveInfo ri) {
        // If this intent will be serve by the SecureResourceProvider then this uri must
        // be granted before we start it, only for external apps. The internal editor
        // must receive an file scheme uri
        Uri uri = intent.getData();
        String authority = null;
        if (uri != null) {
            authority = uri.getAuthority();
            grantSecureAccess(intent, authority, ri, uri);
        } else if (intent.getExtras() != null) {
            Object obj = intent.getExtras().get(Intent.EXTRA_STREAM);
            if (obj instanceof Uri) {
                uri = (Uri) intent.getExtras().get(Intent.EXTRA_STREAM);
                authority = uri.getAuthority();
                grantSecureAccess(intent, authority, ri, uri);
            } else if (obj instanceof ArrayList) {
                ArrayList<Uri> uris = (ArrayList<Uri>) intent.getExtras().get(Intent.EXTRA_STREAM);
                for (Uri u : uris) {
                    authority = u.getAuthority();
                    grantSecureAccess(intent, authority, ri, u);
                }
            }
        }
    }


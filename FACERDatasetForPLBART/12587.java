    @Override
    public String getType(Uri uri) {
        // Retrieve the authorization
        AuthorizationResource authResource = getAuthorizacionResourceForUri(uri);
        if (authResource == null) {
            throw new SecurityException("Authorization not exists");
        }

        return MimeTypeHelper.getMimeType(getContext(), authResource.mFile);
    }


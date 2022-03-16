    private static final void grantSecureAccess(Intent intent, String authority, ResolveInfo ri,
            Uri uri) {
        if (authority != null && authority.equals(SecureResourceProvider.AUTHORITY)) {
            boolean isInternalEditor = isInternalEditor(ri);
            if (isInternalEditor) {
                // remove the authorization and change request to file scheme
                AuthorizationResource auth = SecureResourceProvider.revertAuthorization(uri);
                intent.setData(Uri.fromFile(new File(auth.mFile.getFullPath())));

            } else {
                // Grant access to the package
                SecureResourceProvider.grantAuthorizationUri(uri,
                        ri.activityInfo.applicationInfo.packageName);
            }
        }
    }


    @Override
    public BrowserRoot onGetRoot(@NonNull String clientPackageName, int clientUid,
                                 Bundle rootHints) {
        FireLog.d(TAG, "(++) onGetRoot: clientPackageName=" + clientPackageName +
                "; clientUid=" + clientUid + " ; rootHints=" + rootHints);
        // Returning null = no one can connect

        PackageValidator packageValidator = new PackageValidator(this);
        if (!packageValidator.isCallerAllowed(this, clientPackageName, clientUid)) {
            return new MediaBrowserServiceCompat.BrowserRoot(MEDIA_ID_EMPTY_ROOT, null);
        }

        return new BrowserRoot(MEDIA_ID_ROOT, null); // Name visible in Android Auto
    }


    @Override
    public ParcelFileDescriptor openFile(Uri uri, String mode, final CancellationSignal signal)
            throws FileNotFoundException {
        // Retrieve the authorization
        final AuthorizationResource authResource = getAuthorizacionResourceForUri(uri);
        if (authResource == null) {
            throw new SecurityException("Authorization not exists");
        }

        // Check that the request comes from the authorized package
        String[] pkgs = getContext().getPackageManager().getPackagesForUid(Binder.getCallingUid());
        if (pkgs == null) {
            throw new SecurityException("Authorization denied. No packages");
        }
        boolean isPackageAuthorized = false;
        for (String pkg : pkgs) {
            if (pkg.equals(authResource.mPackage)) {
                isPackageAuthorized = true;
                break;
            }
        }
        if (!isPackageAuthorized) {
            throw new SecurityException("Authorization denied. Package mismatch");
        }

        // Open a pipe between the package and this provider
        try {
            final ParcelFileDescriptor[] fds = ParcelFileDescriptor.createReliablePipe();
            mExecutorService.execute(new Runnable() {
                @Override
                public void run() {
                    try {
                        AsyncReader reader = new AsyncReader(fds[0], fds[1], signal);
                        CommandHelper.read(getContext(), authResource.mFile.getFullPath(),
                                reader, null);
                    } catch (Exception e) {
                        Log.w(TAG, "Failure writing pipe. ", e);
                    }
                }
            });
            return fds[0];

        } catch (IOException ex) {
            Log.w(TAG, "Failed to create pipe descriptors. ", ex);
        }
        return null;
    }


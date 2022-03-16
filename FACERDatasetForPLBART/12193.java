    /**
     * {@inheritDoc}
     */
    @Override
    public void onCreate() {
        if (DEBUG) {
            Log.d(TAG, "FileManagerApplication.onCreate"); //$NON-NLS-1$
        }
        init();
        register();

        // Kick off usage by mime type indexing for external storage; most likely use case for
        // file manager
        File externalStorage = Environment.getExternalStorageDirectory();
        MimeTypeIndexService.indexFileRoot(this, externalStorage.getAbsolutePath());
        MimeTypeIndexService.indexFileRoot(this, Environment.getRootDirectory().getAbsolutePath());
        StorageVolume[] storageVolumes = StorageHelper.getStorageVolumes(this, true);
        for (StorageVolume storageVolume : storageVolumes) {
            MimeTypeIndexService.indexFileRoot(this, storageVolume.getPath());
        }


        // Schedule in case not scheduled (i.e. never booted with this app on device
        SecureCacheCleanupService.scheduleCleanup(getApplicationContext());

    }


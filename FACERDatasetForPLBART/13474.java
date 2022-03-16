    /**
     * Method that returns the storage volumes defined in the system.  This method uses
     * reflection to retrieve the method because CM10 has a {@link Context}
     * as first parameter, that AOSP hasn't.
     *
     * @param ctx The current context
     * @param reload If true, re-query the volumes and do not return the already cached list.
     * @return StorageVolume[] The storage volumes defined in the system
     */
    @SuppressWarnings("boxing")
    public static synchronized StorageVolume[] getStorageVolumes(Context ctx, boolean reload) {
        if (sStorageVolumes == null || reload) {
            //IMP!! Android SDK doesn't have a "getVolumeList" but is supported by CM10.
            //Use reflect to get this value (if possible)
            try {
                StorageManager sm = (StorageManager) ctx.getSystemService(Context.STORAGE_SERVICE);
                Method method = sm.getClass().getMethod("getVolumeList"); //$NON-NLS-1$
                sStorageVolumes = (StorageVolume[])method.invoke(sm);

            } catch (Exception ex) {
                //Ignore. Android SDK StorageManager class doesn't have this method
                //Use default android information from environment
                try {
                    File externalStorage = Environment.getExternalStorageDirectory();
                    String path = externalStorage.getCanonicalPath();
                    String description = null;
                    if (path.toLowerCase(Locale.ROOT).indexOf("usb") != -1) { //$NON-NLS-1$
                        description = ctx.getString(R.string.usb_storage);
                    } else {
                        description = ctx.getString(R.string.external_storage);
                    }
                    // Android SDK has a different constructor for StorageVolume. In CM10 the
                    // description is a resource id. Create the object by reflection
                    Constructor<StorageVolume> constructor =
                            StorageVolume.class.
                                getConstructor(
                                        String.class,
                                        String.class,
                                        boolean.class,
                                        boolean.class,
                                        int.class,
                                        boolean.class,
                                        long.class);
                    StorageVolume sv =
                            constructor.newInstance(path, description, false, false, 0, false, 0);
                    sStorageVolumes = new StorageVolume[]{sv};
                } catch (Exception ex2) {
                    /**NON BLOCK**/
                }
            }
            if (sStorageVolumes == null) {
                sStorageVolumes = new StorageVolume[]{};
            }
        }
        return sStorageVolumes;
    }


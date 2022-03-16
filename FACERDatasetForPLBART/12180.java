    /**
     * Method that returns the virtual storage directory
     * @return
     */
    private static File getVirtualStorageDir() {
        final Context context = FileManagerApplication.getInstance().getApplicationContext();
        File dir = new File(context.getString(R.string.virtual_storage_dir));
        AccessMode mode = FileManagerApplication.getAccessMode();
        if (mode.equals(AccessMode.SAFE) || !dir.isDirectory()) {
            // Chroot environment (create a folder inside the external storage)
            return getChrootedVirtualStorageDir();
        }
        return dir;
    }


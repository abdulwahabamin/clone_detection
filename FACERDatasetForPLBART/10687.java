    /**
     * Method that return the chrooted path of an absolute path. xe: /storage/sdcard0 --> sdcard0.
     *
     * @param path The path
     * @return String The chrooted path
     */
    public static String getChrootedPath(String path) {
        StorageVolume[] volumes =
                getStorageVolumes(FileManagerApplication.getInstance().getApplicationContext(),
                                  false);
        int cc = volumes.length;
        for (int i = 0; i < cc; i++) {
            StorageVolume vol = volumes[i];
            File p = new File(path);
            File v = new File(vol.getPath());
            if (p.getAbsolutePath().startsWith(v.getAbsolutePath())) {
                return v.getName() + path.substring(v.getAbsolutePath().length());
            }
        }
        return null;
    }


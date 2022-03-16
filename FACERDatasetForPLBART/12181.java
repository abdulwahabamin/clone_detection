    /**
     * Method that returns the chrooted virtual storage directory
     *
     * @return File The Virtual storage directory
     */
    private static File getChrootedVirtualStorageDir() {
        File root = new File(Environment.getExternalStorageDirectory(), DEFAULT_STORAGE_NAME);
        root.mkdir();
        return root;
    }


    /**
     * Method that creates the a new file reference for a partial
     * breadcrumb item.
     *
     * @param dirs The split strings directory
     * @param pos The position up to which to create
     * @return File The file reference
     */
    @SuppressWarnings("static-method")
    private File createFile(String[] dirs, int pos) {
        File parent = new File(FileHelper.ROOT_DIRECTORY);
        for (int i = 1; i < pos; i++) {
            parent = new File(parent, dirs[i]);
        }
        return new File(parent, dirs[pos]);
    }


    /**
     * Method that delete a file or a folder
     *
     * @param src The file or folder to delete
     * @return boolean If the operation was successfully
     */
    public static boolean deleteFileOrFolder(File src) {
        if (src.isDirectory()) {
            return FileHelper.deleteFolder(src);
        }
        return src.delete();
    }


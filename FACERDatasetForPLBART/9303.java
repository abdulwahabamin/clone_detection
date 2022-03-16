    /**
     * Method that returns if the path is the real secure storage file
     *
     * @param path The path to check
     * @return boolean If the path is the secure storage
     */
    public static boolean isSecureStorageDir(String path) {
        Console vc = getVirtualConsoleForPath(path);
        if (vc != null && vc instanceof SecureConsole) {
            return isSecureStorageDir(((SecureConsole) vc).buildRealFile(path));
        }
        return false;
    }


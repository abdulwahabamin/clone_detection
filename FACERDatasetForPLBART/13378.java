    /**
     * Method that returns the .nomedia file
     *
     * @param fso The folder that contains the .nomedia file
     * @return File The .nomedia file
     */
    public static File getNoMediaFile(FileSystemObject fso) {
        File file = null;
        try {
            file = new File(fso.getFullPath()).getCanonicalFile();
        } catch (Exception e) {
            file = new File(fso.getFullPath()).getAbsoluteFile();
        }
        return new File(file, ".nomedia").getAbsoluteFile(); //$NON-NLS-1$
    }


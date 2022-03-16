    /**
     * @param f  - file which need be checked
     * @return if is archive - returns true othewise
     */
    public static boolean checkIfZipArchive(File f){
        try {
            new ZipFile(f);
            return true;
        } catch (Exception e){
            return false;
        }
    }


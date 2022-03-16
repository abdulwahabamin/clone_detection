    public static void extract(String zipFile, String outputFolder, HashMap<String,Boolean> unzippedfiles){
        try {
            extract(new FileInputStream(zipFile), outputFolder, unzippedfiles);
        } catch(Exception e) {
            BLog.e(e.getMessage());
        }
    }


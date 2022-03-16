    public static String createFilePathFromUrl(String url) {
        StringBuilder dir = new StringBuilder(Files.HOME_PATH_FILES);
        dir.append(File.separator);
        dir.append(Files.FOLDER_IMAGES);
        String path=dir.toString();
        String filename = Files.createFileNameFromUrl(url);


        dir.append(File.separator);
        dir.append(filename);
        return dir.toString();
    }


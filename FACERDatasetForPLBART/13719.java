    /**
     * Get the File Size in human readable format
     *
     * @param myFile
     * @return String containing file size
     */
    private String getFileSize(File myFile) {
        String fileSizeString = "";
        long fileSizeBytes = getFolderSize(myFile);
        if (fileSizeBytes >= 1024) {
            long fileSizeKb = fileSizeBytes / 1024;
            if (fileSizeKb >= 1024) {
                long fileSizeMb = fileSizeKb / 1024;
                if (fileSizeMb >= 1024)
                    fileSizeString = fileSizeMb / 1024 + " Gb";
                else
                    fileSizeString = fileSizeMb + " Mb";
            } else
                fileSizeString = fileSizeKb + " Kb";
        } else
            fileSizeString = fileSizeBytes + " byte(s)";
        return fileSizeString;
    }


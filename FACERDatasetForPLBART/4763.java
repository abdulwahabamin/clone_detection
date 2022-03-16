    private static int runQuickIndex() {


        for(String t:tryfolders) {
            runFolderIndex(Files.SDCARD_PATH+File.separator+t,20);
        }
        return 0;
    }


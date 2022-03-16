    public static boolean exists() {
        frt = new FileReadTask(Files.HOME_PATH_APP, Files.FILENAME_GENERAL_SETTINGS);

        return frt.exists();

    }


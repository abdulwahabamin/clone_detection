    @Override
    public void initialSetup() {
        // Setting CURRENT DIR path
        CURRENT_DIR = System.getenv("EXTERNAL_STORAGE");
        if (CURRENT_DIR == null) {
            try {
                CURRENT_DIR = Environment.getExternalStorageDirectory().getCanonicalPath();
            } catch (IOException e) {
                e.printStackTrace();
                CURRENT_DIR = "/"; // If nothing shows up, display root directory (This should never happen)
            }
        }
        CURRENT_DIR_PATH = CURRENT_DIR;
    }


        private void createDir(File dir) {
            if (dir.exists()) {
                return;
            }
            Log.i(TAG, "Creating dir " + dir.getName());
            if (!dir.mkdirs()) {
                throw new RuntimeException("Can not create dir " + dir);
            }
        }        


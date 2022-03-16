    private boolean deleteFile(File file) {
        if (file.isDirectory()) {
            File[] contents = file.listFiles();
            if (contents != null) {
                for (File f : contents) {
                    if (!deleteFile(f)) {
                        return false;
                    }
                }
            }
        }
        return file.delete();
    }


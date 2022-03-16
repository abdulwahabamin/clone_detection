    private void clearDir(File dir) {
        for(File file : dir.listFiles()) {
            if(file.isDirectory()) {
                clearDir(file);
                file.delete();
            } else {
                file.delete();
            }
        }
    }


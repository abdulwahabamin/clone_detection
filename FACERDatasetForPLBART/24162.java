    private void processFolder(MatrixCursor cursor, int[] counter, File start, File root) {
        File[] subFolders = start.listFiles(DIRECTORY_FILTER);
        if (subFolders == null) {
            Log.w(LOGTAG, "Music folder not found: " + start.getAbsolutePath());
            return;
        }
        if (subFolders.length == 0 && !start.equals(root)) addToCursor(cursor, counter, start, root);
        for (File folder : subFolders) {
            processFolder(cursor, counter, folder, root);
        }
    }


    private Cursor fetchFolders() {
        File root = fetchRoot(getContext());
        MatrixCursor cursor = new MatrixCursor(new String[] {
                MusicContract.Folder._ID,
                MusicContract.Folder._COUNT,
                MusicContract.Folder.PATH,
                MusicContract.Folder.NAME,
        });
        int[] counter = new int[1];
        processFolder(cursor, counter, root, root);
        return cursor;
    }


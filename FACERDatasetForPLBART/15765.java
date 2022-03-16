    private void createFiles() {
        String cacheDir;
        if(getExternalCacheDir() == null) {
            Toast.makeText(this, "Failed to get Internal storage. Using app data storage.", Toast.LENGTH_LONG).show();
            cacheDir = getCacheDir().getAbsolutePath();
        } else  {
            cacheDir = getExternalCacheDir().getAbsolutePath();
        }

        Library.DATABASE_LOCATION = cacheDir + "/libraries";
        //before changing covers location, remember that the file move action in RemoteAlbumCoverLoader can only move files on the same mount point
        Library.REMOTE_COVERS_LOCATION = cacheDir + "/remote_album_covers";
        Library.FILE_SAVE_LOCATION = cacheDir + "/files";

        try {
            createDir(Library.DATABASE_LOCATION);
            createDir(Library.REMOTE_COVERS_LOCATION);
            createDir(Library.FILE_SAVE_LOCATION);
        } catch (IOException e) {
            Toast.makeText(this,"Failed to create directory", Toast.LENGTH_LONG).show();
            Log.d("splash fail", e.toString());
            finishAffinity();
        }
    }


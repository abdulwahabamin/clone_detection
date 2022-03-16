    private void checkStoragePermission(final MusicDBProgressCallBack callBack) {
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE)
                != PackageManager.PERMISSION_GRANTED) {
            // Check Permissions Now
            ActivityCompat.requestPermissions(this,
                    new String[]{Manifest.permission.READ_EXTERNAL_STORAGE},
                    REQUEST_READ_STORAGE);
        } else {
            // permission has been granted, continue as usual
            new Thread(new Runnable() {
                public void run() {
                    MusicDataUtility.updateMusicDB(getApplicationContext());
                    callBack.finishedDBUpdate();
                }
            }).start();
        }
    }


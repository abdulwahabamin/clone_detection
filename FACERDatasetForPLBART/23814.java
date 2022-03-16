    @Override
    public void onRequestPermissionsResult(int requestCode, String permissions[], int[] grantResults) {
        Log.d(TAG, "onRequestPermissionsResult() entry.");
        for (int i = 0; i < permissions.length; i++) {
            int rslt = -999;
            if (grantResults.length > i)
                rslt = grantResults[i];
            Log.d(TAG, "onRequestPermissionsResult[" + permissions[i] + "] = " + rslt);
        }
        if (grantResults.length > 0) {
            if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                switch (requestCode) {
                    case REQUEST_PERMISSION_STORAGE: {
                        Log.d(TAG, "onActivityResult() EXT_STORE_REQUEST GRANTED");
                        setupGenreList(playingInfo);
                        initializeMusicServerPlaylist(playingInfo);
                    }
                }
            } else {
                Log.d(TAG, "onActivityResult() Request denied.");
            }
        } else {
            Log.d(TAG, "onActivityResult() Request canceled.");
        }
    }


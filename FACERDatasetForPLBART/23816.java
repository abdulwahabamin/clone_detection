    private void playNext() {
        int permissionCheck = ContextCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE);
        if (permissionCheck == PackageManager.PERMISSION_GRANTED) {
            musicSrv.playNext();
            startSeekTracking();
            updateControls();
        }
    }


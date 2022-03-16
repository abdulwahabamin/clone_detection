    private void playPrev() {
        int permissionCheck = ContextCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE);
        if (permissionCheck == PackageManager.PERMISSION_GRANTED) {
            musicSrv.playPrev();
            startSeekTracking();
            updateControls();
        }
    }


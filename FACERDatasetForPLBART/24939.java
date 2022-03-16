    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if (requestCode == REQUEST_READ_STORAGE) {
            if (grantResults.length == 1
                    && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                // We can now safely use the API we requested access to
                loadingContainer.setVisibility(View.VISIBLE);
                new Thread(new Runnable() {
                    public void run() {
                        MusicDataUtility.updateMusicDB(getApplicationContext());
                        BrowseActivity.this.finishedDBUpdate();
                    }
                }).start();
            } else {
                // Permission was denied or request was cancelled
                DialogHelper.showPermissionDialog(this);
                resetFirstTimeFlag();
                loadingContainer.setVisibility(View.GONE);
            }
        }
    }


    private void requestNecessaryPermissions() {
        String[] permissions = new String[] {
            android.Manifest.permission.WRITE_EXTERNAL_STORAGE,
        };
        requestPermissions(permissions, REQUEST_CODE_STORAGE_PERMS);
    }


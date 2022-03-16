    public void checkRunTimePermissions() {
        AppPermissions appPermissions = new AppPermissions(this);
        if (appPermissions.hasPermission(Manifest.permission.WRITE_EXTERNAL_STORAGE)) {
            //Storage Permissions granted
        } else {
            appPermissions.requestPermission(Manifest.permission.WRITE_EXTERNAL_STORAGE, STORAGE_CODE);
        }
    }


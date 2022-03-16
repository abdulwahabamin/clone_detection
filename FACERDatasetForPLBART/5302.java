    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode == RESULT_OK && requestCode == EXTERNAL) {
            Uri treeUri = data.getData();
            pickedDir = DocumentFile.fromTreeUri(this, treeUri);
            sharedPreferences.edit().putString(Util.BASE_URI, treeUri.toString()).apply();
            //grantUriPermission(getPackageName(), treeUri, Intent.FLAG_GRANT_READ_URI_PERMISSION | Intent.FLAG_GRANT_WRITE_URI_PERMISSION);
            //getContentResolver().takePersistableUriPermission(treeUri, Intent.FLAG_GRANT_READ_URI_PERMISSION | Intent.FLAG_GRANT_WRITE_URI_PERMISSION);
            Log.e(TAG, "External URI: " + treeUri.toString() + " extension" + MimeTypeMap.getFileExtensionFromUrl(treeUri.toString()));
        }
    }


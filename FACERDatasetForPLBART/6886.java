    private void openFileDialog(final int position) {
        File file;
        Uri uri;
        String type;
        Intent intent = null;
        try
        {
            file = new File(current_path, files[position]);
            uri = FileProvider.getUriForFile(this, BuildConfig.APPLICATION_ID + ".fileprovider", file);
            type = getContentResolver().getType(uri);
            intent = ShareCompat.IntentBuilder.from(this)
                    .setType(type)
                    .setStream(uri)
                    .setChooserTitle("Choose application")
                    .createChooserIntent()
                    .addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
        }catch (Exception ex)
        {
            Snackbar.make(findViewById(android.R.id.content), ex.getMessage(), Snackbar.LENGTH_SHORT).show();
            finish();
        }
        this.startActivity(intent);
    }


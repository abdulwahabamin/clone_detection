    private void selectFolder() {
        FileListerDialog fileListerDialog = FileListerDialog.createFileListerDialog(this, R.style.AppTheme);
        fileListerDialog.setOnFileSelectedListener(new OnFileSelectedListener() {
            @Override
            public void onFileSelected(File file, String path) {
                SharedPrefUtils.setDownloadedFolder(path, SettingsActivity.this);
                setValues(path);
            }
        });
        fileListerDialog.setDefaultDir(SharedPrefUtils.getDownloadedFolder(this));
        fileListerDialog.setFileFilter(FileListerDialog.FILE_FILTER.DIRECTORY_ONLY);
        fileListerDialog.show();
    }


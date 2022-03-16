    @Override
    public void onAdapterItemClick(View view, int position) {
        FileModel fileModel = adapter.getItem(position);

        if (fileModel.isFolder())
            presenter.loadModelData(fileModel);
        else {
            // File Detected
            // open view intent depending on fileType
            try {
                File currentFile = new File(fileModel.getParentDirectoryPath(), fileModel.getName());
                MimeTypeMap myMime = MimeTypeMap.getSingleton();
                Intent newIntent = new Intent(Intent.ACTION_VIEW);
                String mimeType = myMime.getMimeTypeFromExtension(FileUtil.getInstance().fileExt(currentFile.getCanonicalPath()));
                newIntent.setDataAndType(Uri.fromFile(currentFile), mimeType);
                newIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                try {
                    startActivity(newIntent);
                } catch (ActivityNotFoundException e) {
                    Snackbar.make(view, "No handler for this type of file.", Snackbar.LENGTH_LONG)
                            .show();
                }
            } catch (IOException e) {
                Snackbar.make(view, "Could not fetch file", Snackbar.LENGTH_LONG)
                        .show();
            }
        }
    }


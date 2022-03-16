    /**
     * {@inheritDoc}
     */
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        // cancel search query if in progress
        // *need* to do this as the async query holds a lock on the Console and we need the Console
        // to gather additional file info in order to process the click event
        if (mSearchInProgress) mExecutable.end();

        try {
            SearchResult result = ((SearchResultAdapter)parent.getAdapter()).getItem(position)
                    .getSearchResult();
            FileSystemObject fso = result.getFso();
            if (fso instanceof Directory) {
                back(false, fso, false);
                return;
            } else if (fso instanceof Symlink) {
                Symlink symlink = (Symlink)fso;
                if (symlink.getLinkRef() != null && symlink.getLinkRef() instanceof Directory) {
                    back(false, symlink.getLinkRef(), false);
                    return;
                }
                fso = symlink.getLinkRef();
            }

            // special treatment for video files
            // all of the video files in the current search will also be sent as an extra in the
            // intent along with the item that was clicked
            MimeTypeCategory fileCategory = MimeTypeHelper.getCategoryFromExt(this,
                    FileHelper.getExtension(fso), fso.getFullPath());
            if (fileCategory == MimeTypeCategory.VIDEO) {

                ArrayList<FileSystemObject> filteredList = filterSearchResults(fileCategory);
                ArrayList<Uri> uris = new ArrayList<Uri>(filteredList.size());

                for (FileSystemObject f : filteredList) {
                    uris.add(f.getFileUri());
                }

                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_VIEW);
                intent.setDataAndType(fso.getFileUri(), MimeTypeHelper.getMimeType(this, fso));
                if (filteredList.size() > 1) {
                    intent.putParcelableArrayListExtra("EXTRA_FILE_LIST", uris);
                }

                if (DEBUG) {
                    Log.i(TAG, "video intent : " + intent);
                }

                try {
                    startActivity(intent);
                } catch(ActivityNotFoundException e) {
                    Log.e(TAG, "ActivityNotFoundException when opening a video file");
                    Toast.makeText(this, R.string.activity_not_found_exception, Toast.LENGTH_SHORT);
                }

                return;
            }

            // for other files, open them with their preferred registered app
            back(false, fso, false);

        } catch (Throwable ex) {
            ExceptionUtil.translateException(this.mSearchListView.getContext(), ex);
        }
    }


    /**
     * Method that navigate to the file system used the intent (NavigationActivity)
     *
     * @param fso The file system object to navigate to
     * @return boolean If the action implies finish this activity
     */
    boolean navigateTo(FileSystemObject fso) {
        if (fso != null) {
            if (FileHelper.isDirectory(fso)) {
                final Intent intent = new Intent();
                Bundle bundle = new Bundle();
                bundle.putSerializable(NavigationActivity.EXTRA_SEARCH_ENTRY_SELECTION, fso);
                bundle.putParcelable(NavigationActivity.EXTRA_SEARCH_LAST_SEARCH_DATA,
                        (Parcelable)createSearchInfo());
                intent.putExtras(bundle);
                setResult(RESULT_OK, intent);
                return true;
            }

            // Open the file here, so when focus back to the app, the search activity
            // its in top of the stack
            IntentsActionPolicy.openFileSystemObject(this, fso, false, null);
        } else {
            // The fso not exists, delete the fso from the search
            try {
                removeItem(fso);
            } catch (Exception ex) {/**NON BLOCK**/}
        }
        return false;
    }


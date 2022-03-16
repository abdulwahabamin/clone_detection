    /**
     * {@inheritDoc}
     */
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        try {
            FileSystemObject fso = ((FileSystemObjectAdapter)parent.getAdapter()).getItem(position);
            if (fso instanceof ParentDirectory) {
                changeCurrentDir(fso.getParent(), true, false, false, null, null);
                return;
            } else if (fso instanceof Directory) {
                changeCurrentDir(fso.getFullPath(), true, false, false, null, null);
                return;
            } else if (fso instanceof Symlink) {
                Symlink symlink = (Symlink)fso;
                if (symlink.getLinkRef() != null && symlink.getLinkRef() instanceof Directory) {
                    changeCurrentDir(
                            symlink.getLinkRef().getFullPath(), true, false, false, null, null);
                    return;
                }

                // Open the link ref
                fso = symlink.getLinkRef();
            }

            // Open the file (edit or pick)
            if (this.mNavigationMode.compareTo(NAVIGATION_MODE.BROWSABLE) == 0) {
                // Open the file with the preferred registered app
                IntentsActionPolicy.openFileSystemObject(getContext(), fso, false, null);
            } else {
                // Request a file pick selection
                if (this.mOnFilePickedListener != null) {
                    this.mOnFilePickedListener.onFilePicked(fso);
                }
            }
        } catch (Throwable ex) {
            ExceptionUtil.translateException(getContext(), ex);
        }
    }


    /**
     * Remove all unmounted files in the current selection
     */
    public void removeUnmountedSelection() {
        List<FileSystemObject> selection = mAdapter.getSelectedItems();
        int cc = selection.size() - 1;
        for (int i = cc; i >= 0; i--) {
            FileSystemObject item = selection.get(i);
            VirtualMountPointConsole vc =
                    VirtualMountPointConsole.getVirtualConsoleForPath(item.getFullPath());
            if (vc != null && !vc.isMounted()) {
                selection.remove(i);
            }
        }
        mAdapter.setSelectedItems(selection);
        mAdapter.notifyDataSetChanged();

        // Do not call the selection listener. This method is supposed to be called by the
        // listener itself
    }


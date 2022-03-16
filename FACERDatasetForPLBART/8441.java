    /**
     * Method that select/deselect all items.
     *
     * @param select Indicates if select (true) or deselect (false) all items.
     */
    private void doSelectDeselectAllVisibleItems(boolean select) {
        int cc = getCount();
        for (int i = 0; i < cc; i++) {
            FileSystemObject fso = getItem(i);
            if (fso.getName().compareTo(FileHelper.PARENT_DIRECTORY) == 0) {
                // No select the parent directory
                continue;
            }
            if (select) {
                mSelectedItems.add(fso);
            } else {
                mSelectedItems.remove(fso);
            }
        }

        //Communicate event
        if (this.mOnSelectionChangedListener != null) {
            this.mOnSelectionChangedListener.onSelectionChanged(
                    new ArrayList<FileSystemObject>(mSelectedItems));
        }

        notifyDataSetChanged();
    }


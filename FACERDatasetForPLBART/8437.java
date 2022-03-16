    /**
     * Method that selects in the {@link ArrayAdapter} the passed item.
     *
     * @param v The check view object (can be null)
     * @param fso The file system object to select
     */
    private void toggleSelection(View v, FileSystemObject fso) {
        Theme theme = ThemeManager.getCurrentTheme(getContext());

        boolean selected = !mSelectedItems.remove(fso);
        if (selected) {
            mSelectedItems.add(fso);
        }
        if (v != null) {
            ((View)v.getParent()).setSelected(selected);
        }

        //Communicate event
        if (this.mOnSelectionChangedListener != null) {
            this.mOnSelectionChangedListener.onSelectionChanged(
                    new ArrayList<FileSystemObject>(mSelectedItems));
        }

        notifyDataSetChanged();
    }


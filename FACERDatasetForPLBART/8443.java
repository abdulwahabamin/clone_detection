    /**
     * Method that sets the selected items.
     *
     * @param selectedItems The selected items
     */
    public void setSelectedItems(List<FileSystemObject> selectedItems) {
        mSelectedItems.clear();
        mSelectedItems.addAll(selectedItems);
        notifyDataSetChanged();
    }


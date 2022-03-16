    /**
     * Method that returns the selected item of the grid view
     *
     * @return ResolveInfo The selected item
     * @hide
     */
    ResolveInfo getSelected() {
        AssociationsAdapter adapter = (AssociationsAdapter)this.mGrid.getAdapter();
        return adapter.getItem(mGrid.getCheckedItemPosition());
    }


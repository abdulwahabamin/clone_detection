    /******************
     * Context Menu   *
     ******************/
    @Override
    public boolean onContextItemSelected(MenuItem item) {
        int position = mAdapter.getContextMenuPosition();

        switch(item.getItemId()) {
            case R.id.rename:
                showRenameFileDialog(position);
                break;
            case R.id.delete:
                showDeleteDialog(position);
        }

        return super.onContextItemSelected(item);
    }


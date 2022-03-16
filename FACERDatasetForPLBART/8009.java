    protected void renameFile(int position, String newName) {
        String path = mAdapter.getCurrentDirectory() + "/" + newName;

        if (!mAdapter.renameFile(position, path)) {
            Toast.makeText(this, "Unable to rename file/folder",
                    Toast.LENGTH_SHORT).show();
        }
    }


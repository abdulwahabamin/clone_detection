    protected void createFile(String name) {
        String path = mAdapter.getCurrentDirectory() + "/" + name;
        File newFile = new File(path);

        if (!mAdapter.createFile(newFile)) {
            Toast.makeText(this, "Unable to create folder", Toast.LENGTH_SHORT).show();
        }
    }


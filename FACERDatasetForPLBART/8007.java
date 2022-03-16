    protected void createDirectory(String name) {
        String path = mAdapter.getCurrentDirectory() + "/" + name;
        File newDir = new File(path);

        if (!mAdapter.createDirectory(newDir)) {
            Toast.makeText(this, "Unable to create directory", Toast.LENGTH_SHORT).show();
        }
    }


    public void goToParentDirectory(View v) {
        if (!mAdapter.getCurrentDirectory().equals(ROOT)) {
            File current = new File(mAdapter.getCurrentDirectory());
            File parent = current.getParentFile();

            if (parent.canRead()) {
                setCurrentDirectory(current.getParent());
            } else {
                setCurrentDirectory(ROOT);
            }
        }
    }


    public void listItemClicked(int position) {
        File fileClicked = fileArrayAdapter.getItem(position);
        if (fileClicked.isDirectory()) {
            fileManagerCore.setPreviousDirectory(fileManagerCore.getCurrentDirectory());
            fileManagerCore.setCurrentDirectory(fileClicked);
            fileLoader.onContentChanged();
        }
    }


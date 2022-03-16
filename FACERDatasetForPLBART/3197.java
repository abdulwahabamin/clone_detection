    @Override
    public Loader<List<File>> onCreateLoader(int id, Bundle args) {
        fileLoader = new AsyncTaskLoader<List<File>>(mainViewFragment.getActivity()) {

            @Override
            public List<File> loadInBackground() {
               return fileManagerCore.getAllFiles(fileManagerCore.getCurrentDirectory());
            }
        };
        return fileLoader;
    }


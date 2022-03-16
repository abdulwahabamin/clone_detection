    private void setAdapter(File path) {
        List<File> fileList = FileOperation.loadPath(path, view.getContext());

        ContentResolver resolver = view.getContext().getContentResolver();
        fileModels.clear();
        if (fileList != null) {
            for (File file : fileList) {
                fileModels.add(new FileModel(file));
            }
        }

        ReadDatabaseListener readDatabaseListener = cacheSizeDirectory -> {
            replaceAdapterAfterDBCalc(cacheSizeDirectory);
        };
        readDatabaseTask = new ReadDatabaseTask(resolver, readDatabaseListener).execute();
        Log.d("asasas", "run");
        HashMap<String, Long> cacheSizeDirectory = new HashMap<>();
        RecyclerView.Adapter fileExploreAdapter =
                new FileExploreAdapter(fileModels, pathListener, cacheSizeDirectory);
        fileListView.setAdapter(fileExploreAdapter);
    }


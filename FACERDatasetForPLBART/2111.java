    private void replaceAdapterAfterDBCalc(HashMap<String, Long> cacheSizeDirectory) {
        FileExploreAdapter fileExploreAdapter =
                new FileExploreAdapter(fileModels, pathListener, cacheSizeDirectory);
        fileListView.setAdapter(fileExploreAdapter);
        for (FileModel fileModel : fileModels) {
            if (!cacheSizeDirectory.containsKey(fileModel.getFile().getAbsolutePath()) &&
                    fileModel.getFile().isDirectory()) {
                calculateSizeDirectory(fileModel.getFile(), fileExploreAdapter);
            }
        }
    }


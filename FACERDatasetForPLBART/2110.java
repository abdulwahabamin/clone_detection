    private void calculateSizeDirectory(File file, FileExploreAdapter adapter) {
        ContentResolver resolver = Objects.requireNonNull(getContext()).getContentResolver();
        FileViewFragment.OnCalculateSizeCompleted listener = (FileModel fileModel) -> {
            adapter.replaceSizeOnTextView(fileModel);
        };
        CalculateSizeTask task = new CalculateSizeTask(file, resolver, listener);
        task.execute();
        calculateSize.add(task);
    }


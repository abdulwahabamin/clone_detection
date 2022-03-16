    @Override
    public void onSuccess(String currentDirectoryName) {
        CURRENT_DIR = CURRENT_DIR + File.separator + currentDirectoryName;

        recyclerView.setVisibility(View.GONE);
        noFilesFoundTextView.setVisibility(View.VISIBLE);
    }


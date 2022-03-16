    @Override
    public void onSuccess(List<FileModel> fileModelList) {
        if (!fileModelList.isEmpty()) {
            CURRENT_DIR = fileModelList.get(0).getParentDirectoryPath();

            adapter = new StorageAdapter(getActivity(), fileModelList);
            adapter.setItemClickListener(this);

            recyclerView.setLayoutManager(new GridLayoutManager(getActivity(), 3));
            recyclerView.setAdapter(adapter);

            recyclerView.setVisibility(View.VISIBLE);
            noFilesFoundTextView.setVisibility(View.GONE);
        } else {
            CURRENT_DIR = CURRENT_DIR + "/0";

            recyclerView.setVisibility(View.GONE);
            noFilesFoundTextView.setVisibility(View.VISIBLE);
        }
    }


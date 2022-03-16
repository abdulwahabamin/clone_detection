    void setStorageChooserListener() {
        if (storageChooserAdapter != null) {
            storageChooserAdapter.setOnRecyclerItemClickListener(new OnRecyclerItemClickListener() {
                @Override
                public void onLongClick(View view, int position) {

                }

                @Override
                public void onClick(View view, int position) {
                    String title = storageSelectionList.get(position).getTitle();

                    // if External storage is selected, then pas base document uri.
                    if (title.charAt(0) == 'E') {

                        TARGET_DESTINATION = FileEx.EXTERNAL;
                    }

                    // for internal just go with normal path.
                    fileEx.changeRootDirectory(storageSelectionList.get(position).getPath());
                    Toast.makeText(getApplicationContext(), "Path: " + storageSelectionList
                            .get(position).getPath(), Toast.LENGTH_SHORT).show();
                    fileEx.setCurrentDir(storageSelectionList.get(position).getPath());
                    loadDirectories();
                    breadCrumbsAdapter.setCrumbList(storageSelectionList.get(position).getPath());
                    setOrRefreshAdapter();
                    dialog.dismiss();
                }
            });
        }
    }


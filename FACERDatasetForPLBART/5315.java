    public void setOrRefreshAdapter() {
        filesAdapter = new FilesAdapter(this, fileDirectoryList, fileEx, this);
        filesAdapter.setOnAdpaterDirectoryChangeListener(new OnDirectoryChangeListener() {
            @Override
            public void onDirectoryChange(List<?> newList) {
                if (newList.size() == 0)
                    showOrHideEmptyMessage(View.VISIBLE);
                else
                    showOrHideEmptyMessage(View.GONE);
                breadCrumbsAdapter.setCrumbList(fileEx.getCurrentDir());
                crumbs.smoothScrollToPosition(breadCrumbsAdapter.getItemCount() - 1);
            }
        });
        filesAdapter.setContext(this);
        contentList.setAdapter(filesAdapter);
    }


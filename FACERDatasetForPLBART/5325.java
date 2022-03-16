    @Override
    public void onCrumbSelected(String requiredPath) {
        if (requiredPath == null) {
            Toast.makeText(getApplicationContext(), "This region is not accessible.", Toast.LENGTH_SHORT).show();
        } else {
            fileEx.setCurrentDir(requiredPath);
            breadCrumbsAdapter.setCrumbList(fileEx.getCurrentDir());

            filesAdapter.getOnDirectoryChangeListener().onDirectoryChange(loadDirectories());
            crumbs.smoothScrollToPosition(breadCrumbsAdapter.getItemCount() - 1);
            if (fileDirectoryList.size() == 0)
                showOrHideEmptyMessage(View.VISIBLE);
            else
                showOrHideEmptyMessage(View.GONE);

        }
    }


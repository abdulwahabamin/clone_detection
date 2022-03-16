    @Override
    public void onBackPressed() {

        if(scrollView.getVisibility() == View.VISIBLE && !operationFlag){
            showOrHideOptions(View.GONE);
            filesAdapter.disableSelection();
            filesAdapter.clearSelectedList();
            //Toast.makeText(getApplicationContext(),"disable selection",Toast.LENGTH_SHORT).show();
        }
        else if (scrollView.getVisibility() == View.VISIBLE) {

            showOrHideOptions(View.GONE);

        } else if (fileEx == null) {
            NavUtils.navigateUpFromSameTask(this);
        } else if (!fileEx.goUp()) {
            NavUtils.navigateUpFromSameTask(this);
        } else {
            loadDirectories();
            filesAdapter.getOnDirectoryChangeListener().onDirectoryChange(fileDirectoryList);
            if (fileDirectoryList.size() == 0)
                showOrHideEmptyMessage(View.VISIBLE);
            else
                showOrHideEmptyMessage(View.GONE);
            breadCrumbsAdapter.setCrumbList(fileEx.getCurrentDir());
            crumbs.smoothScrollToPosition(breadCrumbsAdapter.getItemCount() - 1);

        }
    }


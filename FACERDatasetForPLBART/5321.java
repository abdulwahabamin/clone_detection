    @Override
    public void onItemListChanged(List<FileDirectory> list) {
        this.selectedList = list;
        Log.d(TAG, "onItem added: " + selectedList.size());
        if (list.size() > 1) {
            cut.setVisibility(View.VISIBLE);
            cut_t.setVisibility(View.VISIBLE);
            copy.setVisibility(View.VISIBLE);
            copy_t.setVisibility(View.VISIBLE);
            delete.setVisibility(View.VISIBLE);
            delete_t.setVisibility(View.VISIBLE);
            details.setVisibility(View.GONE);
            details_t.setVisibility(View.GONE);
            rename.setVisibility(View.GONE);
            rename_t.setVisibility(View.GONE);
            create.setVisibility(View.INVISIBLE);
            create_t.setVisibility(View.INVISIBLE);
            paste.setVisibility(View.GONE);
            scrollView.setVisibility(View.VISIBLE);
        } else if (list.size() == 0) {
            showOrHideOptions(View.GONE);
        } else {
            showOrHideOptions(View.VISIBLE);
        }
    }


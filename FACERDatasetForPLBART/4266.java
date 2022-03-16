    @Override
    public void onScrollStateChanged(AbsListView view, int scrollState) {

        //if(scrollState==2) {
        //	adapterImages.isFastScroll=true;
        //} else {

        if (list != null &&  adapter!=null) {
            //adapter.promptStateChange(view.getScrollY(), list);
            adapter.promptCacheChange(view.getScrollY(), list);
            adapter.notifyDataSetChanged();
        }
        //}

    }


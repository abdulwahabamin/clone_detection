    @Override
    public void onScroll(AbsListView view, int firstVisibleItem,
                         int visibleItemCount, int totalItemCount) {
        long now= Cal.getUnixTime();

        if(now-lastscroll>100) {
            if(list!=null && adapter!=null) {
                //adapterImages.promptCacheChange(view.getScrollY(),listImages);
                //adapter.promptStateChange(view.getScrollY(), listImages);
            }

        }

        if(now-lastscroll<15) {
            adapter.isFastScroll=true;
        } else {
            adapter.isFastScroll=false;
        }
        //BLog.e("SCR SPEED: " + (now-lastscroll));
        lastscroll=now;

    }


    @Override
    public void onScroll(AbsListView view, int firstVisibleItem,
                         int visibleItemCount, int totalItemCount) {
        long now= Cal.getUnixTime();

        //lastfilesadapter.notifyDataSetChanged();

        //BLog.e("SCR SPEED: " + (now-lastscroll));
        lastscroll=now;

    }


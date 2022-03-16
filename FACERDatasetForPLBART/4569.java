	@Override
	public void onScroll(AbsListView view, int firstVisibleItem,
			int visibleItemCount, int totalItemCount) {
        long now=Cal.getUnixTime();
        if(now-lastscroll<12) {
            //BLog.e("FASAT SCROLL");
            adapterImages.isFastScroll=true;
        } else {
            adapterImages.isFastScroll=false;
        }

        lastscroll=now;

	}


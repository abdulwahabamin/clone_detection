    public static void set(Activity activity, ListView list, ScrollDirectionListener scroll, View.OnClickListener click) {

        fab = (FloatingActionButton) activity.findViewById(R.id.fab);
        fab.setVisibility(View.VISIBLE);
        fab.hide(true);
        if(list==null) {

        } else if(scroll==null) {
            fab.attachToListView(list);
        } else {
            fab.attachToListView(list, new ScrollDirectionListener() {
                @Override
                public void onScrollDown() {
                    Log.d("ListViewFragment", "onScrollDown()");
                }

                @Override
                public void onScrollUp() {
                    Log.d("ListViewFragment", "onScrollUp()");
                }
            }, new AbsListView.OnScrollListener() {
                @Override
                public void onScrollStateChanged(AbsListView view, int scrollState) {
                    Log.d("ListViewFragment", "onScrollStateChanged()");
                }

                @Override
                public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
                    Log.d("ListViewFragment", "onScroll()");
                }
            });
        }


        //fab.onsc
        fab.setOnClickListener(click);
        fab.bringToFront();
        //fab.setAnimation(new AnimatorSet());
        //fab.setVisibility(View.VISIBLE);
        //fab.show(true);
    }


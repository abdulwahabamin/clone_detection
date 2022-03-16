        @Override
        public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
            super.onScrollStateChanged(recyclerView, newState);
            if (RecyclerView.SCROLL_STATE_IDLE == newState) {
                View view = recyclerView.getChildAt(0);
//                Rect rect = new Rect();
//                Point point = new Point();
//                recyclerView.getChildVisibleRect(view, rect, point);
                if ((int)view.getTag() == CityWeatherAdapter.VIEW_MAIN) {
                    if (mScrollDown) {
                        recyclerView.smoothScrollToPosition(1);
                    } else {
                        recyclerView.smoothScrollToPosition(0);
                    }
                }
            }
        }


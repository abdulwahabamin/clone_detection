        @Override
        public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
            super.onScrolled(recyclerView, dx, dy);
            if (dy > 0) {
                mScrollDown = true;
            } else if (dy < 0) {
                mScrollDown = false;
            }
        }


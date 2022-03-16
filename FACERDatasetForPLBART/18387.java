        @Override
        public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {

            try {
                View topChild = view.getChildAt(0);
                int scrollY = -(topChild.getTop()) + view.getFirstVisiblePosition() * topChild.getHeight();
                int adjustedScrollY = (int) ((-scrollY)-mApp.convertDpToPixels(340.0f, mContext));

                RelativeLayout.LayoutParams params = (RelativeLayout.LayoutParams) mHeaderLayout.getLayoutParams();
                params.topMargin = adjustedScrollY/3;
                mHeaderLayout.setLayoutParams(params);

            } catch (Exception e) {
                e.printStackTrace();
            }

        }


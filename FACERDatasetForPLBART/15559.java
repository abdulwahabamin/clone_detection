        @Override
        public void onReceive(Context context, Intent intent) {
            if (mGridView != null) {
                mAdapter.notifyDataSetChanged();
            }
        }


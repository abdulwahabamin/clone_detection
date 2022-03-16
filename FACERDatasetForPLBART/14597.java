        @Override
        public void onReceive(Context context, Intent intent) {
            if (mGridView != null) {
                mQuickQueueAdapter.notifyDataSetChanged();
                // Scroll to the currently playing track in the queue
                mGridView.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        mGridView.setSelection(MusicUtils.getQueuePosition());
                    }
                }, 100);
            }
        }


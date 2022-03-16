        @Override
        public void onReceive(Context context, Intent intent) {
            if (mListView != null) {
                mArtistAlbumAdapter.notifyDataSetChanged();
            }
        }


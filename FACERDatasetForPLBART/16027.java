        @Override
        public Fragment getItem(int position) {
            if(position == SONGS_TAB_INDEX) {
                return songsFragment;
            } else if(position == ALBUMS_TAB_INDEX){
                return albumsFragment;
            } else {
                return null;
            }
        }


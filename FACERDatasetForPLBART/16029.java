        @Override
        public CharSequence getPageTitle(int position) {
            if(position == SONGS_TAB_INDEX) {
                return SONGS_TAB_TITLE;
            } else if(position == ALBUMS_TAB_INDEX){
                return ALBUMS_TAB_TITLE;
            } else {
                return null;
            }
        }


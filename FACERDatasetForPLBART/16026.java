        LibraryPagerAdapter(FragmentManager fm, Fragment songsFragment, Fragment albumsFragment) {
            super(fm);
            this.fm = fm;
            this.songsFragment = songsFragment;
            this.albumsFragment = albumsFragment;
        }


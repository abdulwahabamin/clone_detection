        public void changeAlbumsFragment(Fragment fragment) {
            toReplace = albumsFragment;
            fm.beginTransaction().remove(albumsFragment).commit();
            albumsFragment = fragment;
            notifyDataSetChanged();
        }


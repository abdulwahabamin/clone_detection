        @Override
        public Fragment getItem(int position) {

        	/* PlaylistPagerFragment.java will be shown on every pager screen. However, 
        	 * the fragment will check which screen (position) is being shown, and will
        	 * update its TextViews and ImageViews to match the song that's being played. */
    		Fragment fragment = new PlaylistPagerFragment();
    		
    		Bundle bundle = new Bundle();
    		bundle.putInt("POSITION", position);
    		fragment.setArguments(bundle);
    		return fragment;

        }


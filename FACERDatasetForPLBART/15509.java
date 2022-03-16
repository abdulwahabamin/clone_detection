        public void onPageScrollStateChanged(int state) {   
        	if(state == ViewPager.SCROLL_STATE_IDLE){
        		int cur = mAlbumArtPager.getCurrentItem();
	        	if(cur == 0){
	        		mPagerAdapter.addFragmentTo(new AlbumArtFragment(), 0);
	        		mPagerAdapter.removeItem(3);
	                mAlbumArtPager.setAdapter(mPagerAdapter);
	                mAlbumArtPager.setCurrentItem(1);
	                if (MusicUtils.mService == null)
	                    return;
	                try {
	                    MusicUtils.mService.prev();
	                } catch (RemoteException ex) {
	                    ex.printStackTrace();
	                }
	    		}
	        	else if ( cur == 2 ){
	        		mPagerAdapter.addFragmentTo(new AlbumArtFragment(), 3);
	        		mPagerAdapter.removeItem(0);
	                mAlbumArtPager.setAdapter(mPagerAdapter);
	                mAlbumArtPager.setCurrentItem(1);
	                if (MusicUtils.mService == null)
	                    return;
	                try {
	                    MusicUtils.mService.next();
	                } catch (RemoteException ex) {
	                    ex.printStackTrace();
	                }
	    		}
        	}
	    }


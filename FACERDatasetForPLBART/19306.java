		@Override
		public void onDrawerOpened(View drawer) {
            if (mQueueDrawerFragment!=null &&
                drawer==mCurrentQueueLayout) {
                mQueueDrawerFragment.setIsDrawerOpen(true);
            }
			
		}


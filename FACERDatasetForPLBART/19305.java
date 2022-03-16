		@Override
		public void onDrawerClosed(View drawer) {
			if (mQueueDrawerFragment!=null &&
                drawer==mCurrentQueueLayout) {
                mQueueDrawerFragment.setIsDrawerOpen(false);
            }
			
		}


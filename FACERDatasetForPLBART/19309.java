		@Override
		public void onPageScrollStateChanged(int scrollState) {
			if (scrollState==VelocityViewPager.SCROLL_STATE_DRAGGING)
				USER_SCROLL = true;
			
		}


		@Override
		public void onAnimationEnd(Animation arg0) {
			mView.setVisibility(mFinalVisibility);
			
			if (mChangeImageResource && (mView instanceof ImageView))
				((ImageView) mView).setImageResource(mNewImageResourceId);
			
		}


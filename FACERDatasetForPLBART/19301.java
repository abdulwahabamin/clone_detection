		@Override
		public void onClick(View arg0) {
			//Toggle shuffle on/off.
			boolean shuffleOn = mApp.getService().toggleShuffleMode();
			
			if (shuffleOn)
				mShuffleButton.setImageResource(R.drawable.shuffle_highlighted);
			else
				mShuffleButton.setImageResource(UIElementsHelper.getIcon(mContext, "shuffle"));
			
		}


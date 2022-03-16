		@Override
		public void onClick(View arg0) {
			
			mApp.getService().clearABRepeatRange();
			if (mApp.getService().getRepeatMode()==Common.REPEAT_OFF) {
				mRepeatButton.setImageResource(R.drawable.repeat_highlighted);
				mApp.getService().setRepeatMode(Common.REPEAT_PLAYLIST);
				
			} else if (mApp.getService().getRepeatMode()==Common.REPEAT_PLAYLIST) {
				mRepeatButton.setImageResource(R.drawable.repeat_song);
				mApp.getService().setRepeatMode(Common.REPEAT_SONG);
				
			} else {
				mRepeatButton.setImageResource(UIElementsHelper.getIcon(mContext, "repeat"));
				mApp.getService().setRepeatMode(Common.REPEAT_OFF);
				
			}
			
		}


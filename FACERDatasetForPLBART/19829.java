		@Override
		public void onCheckedChanged(RadioGroup radioGroup, int radioButtonId) {
			switch(radioButtonId) {
			case R.id.get_all_songs_radio:
				mFoldersLayout.startAnimation(mSlideOutAnimation);
				mFoldersLayout.setEnabled(false);
				break;
			case R.id.pick_folders_radio:
				mFoldersLayout.startAnimation(mSlideInAnimation);
				mFoldersLayout.setEnabled(true);
				break;
			}
			
		}


		@Override
		public void onAnimationEnd(Animation arg0) {
			indicator.setVisibility(View.INVISIBLE);

            Intent intent = new Intent(mContext, BuildMusicLibraryService.class);
            startService(intent);
			
		}


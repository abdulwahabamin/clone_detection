		@Override
		public void run() {
			if(!cancel){
				Bitmap bitmap = decodeFile(thumb.parentFile, thumb.text.getText());
				if(bitmap != null && !cancel){
					// Bitmap was successfully decoded so we place it in the hard cache.
					mHardBitmapCache.put(thumb.text.getText(), bitmap);
					Activity activity = ((Activity) mContext);
					activity.runOnUiThread(new ThumbnailUpdater(bitmap, thumb));
					thumb = null;
				}
			}
		}


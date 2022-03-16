	/**
	 * 
	 * @param parentFile The current directory.
	 * @param text The IconifiedText container.
	 * @param imageView The ImageView from the IconifiedTextView.
	 */
	public void loadImage(String parentFile, IconifiedText text, ImageView imageView) {
		if(!cancel && !mBlacklist.contains(text.getText())){
			// We reset the caches after every 30 or so seconds of inactivity for memory efficiency.
			resetPurgeTimer();
			
			Bitmap bitmap = getBitmapFromCache(text.getText());
			if(bitmap != null){
				// We're still in the UI thread so we just update the icons from here.
				imageView.setImageBitmap(bitmap);
				text.setIcon(bitmap);
			} else {
				if (!cancel) {
					// Submit the file for decoding.
					Thumbnail thumbnail = new Thumbnail(parentFile, imageView, text);
					WeakReference<ThumbnailRunner> runner = new WeakReference<ThumbnailRunner>(new ThumbnailRunner(thumbnail));
					mExecutor.submit(runner.get());
				}
			}
		}
	}


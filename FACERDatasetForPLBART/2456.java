	public void run() {
		int count = listFile.size();
		
		Log.v(TAG, "Scanning for thumbnails (files=" + count + ")");
		
		BitmapFactory.Options options = new BitmapFactory.Options();
		
		options.inSampleSize = 16;
		
		for (int x=0; x<count; x++) {
			if (cancel) {
				Log.v(TAG, "Thumbnail loader canceled");
				listFile = null;
				return;
			}
			IconifiedText text = listFile.get(x);
			
			try {
				options.inJustDecodeBounds = true;
				options.outWidth = 0;
				options.outHeight = 0;
				options.inSampleSize = 1;
				
				BitmapFactory.decodeFile(FileUtils.getFile(file, text.getText()).getPath(), options);
				
				if (options.outWidth > 0 && options.outHeight > 0) {
					// Now see how much we need to scale it down.
					int widthFactor = (options.outWidth + thumbnailWidth - 1) / thumbnailWidth;
					int heightFactor = (options.outHeight + thumbnailHeight - 1) / thumbnailHeight;
					
					widthFactor = Math.max(widthFactor, heightFactor);
					widthFactor = Math.max(widthFactor, 1);
					
					// Now turn it into a power of two.
					if (widthFactor > 1) {
						if ((widthFactor & (widthFactor-1)) != 0) {
							while ((widthFactor & (widthFactor-1)) != 0) {
								widthFactor &= widthFactor-1;
							}
							
							widthFactor <<= 1;
						}
					}
					options.inSampleSize = widthFactor;
					options.inJustDecodeBounds = false;
					
					Bitmap bitmap = BitmapFactory.decodeFile(FileUtils.getFile(file, text.getText()).getPath(), options);
				
					if (bitmap != null) {
//						Log.v(TAG, "Got thumbnail for " + text.getText());
						
						// SDK 1.6 and higher only:
						// BitmapDrawable drawable = new BitmapDrawable(context.getResources(), bitmap);

						BitmapDrawable drawable = BitmapDrawable_Compatible.getNewBitmapDrawable(context.getResources(), bitmap);

						drawable.setGravity(Gravity.CENTER);
						drawable.setBounds(0, 0, thumbnailWidth, thumbnailHeight);
						
						text.setIcon(drawable);
						
						Message msg = handler.obtainMessage(FileManagerActivity.MESSAGE_ICON_CHANGED);
						msg.obj = text;
						msg.sendToTarget();
					}
				}
			} catch (Exception e) {
				// That's okay, guess it just wasn't a bitmap.
			}
		}
		
		Log.v(TAG, "Done scanning for thumbnails");
		listFile = null;
	}


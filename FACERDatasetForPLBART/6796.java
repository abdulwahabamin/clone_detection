	/**
	 * @param parentFile The parentFile, so we can obtain the full path of the bitmap
	 * @param fileName The name of the file, also the text in the list item.
	 * @return The resized and resampled bitmap, if can not be decoded it returns null.
	 */
	private Bitmap decodeFile(String parentFile, String fileName) {
		if(!cancel){
			try {
				BitmapFactory.Options options = new BitmapFactory.Options();
				
				options.inJustDecodeBounds = true;
				options.outWidth = 0;
				options.outHeight = 0;
				options.inSampleSize = 1;
				
				String filePath = FileUtils.getFile(parentFile, fileName).getPath();
		
				BitmapFactory.decodeFile(filePath, options);
				
				if(options.outWidth > 0 && options.outHeight > 0){
					if (!cancel) {
						// Now see how much we need to scale it down.
						int widthFactor = (options.outWidth + thumbnailWidth - 1)
								/ thumbnailWidth;
						int heightFactor = (options.outHeight + thumbnailHeight - 1)
								/ thumbnailHeight;
						widthFactor = Math.max(widthFactor, heightFactor);
						widthFactor = Math.max(widthFactor, 1);
						// Now turn it into a power of two.
						if (widthFactor > 1) {
							if ((widthFactor & (widthFactor - 1)) != 0) {
								while ((widthFactor & (widthFactor - 1)) != 0) {
									widthFactor &= widthFactor - 1;
								}

								widthFactor <<= 1;
							}
						}
						options.inSampleSize = widthFactor;
						options.inJustDecodeBounds = false;
						Bitmap bitmap = ImageUtils.resizeBitmap(
								BitmapFactory.decodeFile(filePath, options),
								72, 72);
						if (bitmap != null) {
							return bitmap;
						}
					}
				} else {
					// Must not be a bitmap, so we add it to the blacklist.
					if(!mBlacklist.contains(fileName)){
						mBlacklist.add(fileName);
					}
				}
			} catch(Exception e) { }
		}
		return null;
	}


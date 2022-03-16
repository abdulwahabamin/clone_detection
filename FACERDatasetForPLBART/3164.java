     public void setText(String words) {
         mText.setText(words);

         int height = getHeight();

         if (height > 0) {
		 ThumbnailLoader.setThumbnailHeight(height);
         }
    }


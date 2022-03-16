     public Object getIconBitmap() {
		if(mIcon instanceof BitmapDrawable){
			return ((BitmapDrawable) mIcon).getBitmap();
		}
		
		return mIcon;
     }


		@Override
		public void run() {
			if(bitmap != null && mContext != null && !cancel){
				thumb.imageView.setImageBitmap(bitmap);
				thumb.text.setIcon(bitmap);
			}
		}


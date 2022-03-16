     /** @param convertView The old view to overwrite, if one is passed 
      * @returns a IconifiedTextView that holds wraps around an IconifiedText */ 
     public View getView(int position, View convertView, ViewGroup parent) { 
          IconifiedText curItem = mItems.get(position);
          IconifiedTextView btv; 
          if (convertView == null) { 
               btv = new IconifiedTextView(mContext, curItem); 
          } else { // Reuse/Overwrite the View passed 
               // We are assuming(!) that it is castable! 
               btv = (IconifiedTextView) convertView; 
          } 
          btv.setText(curItem.getText()); 
          btv.setInfo(curItem.getInfo()); 
          if(curItem.isCheckIconVisible()){
        	  btv.setCheckVisible(true);
        	  if(curItem.isSelected()){
        		  btv.setCheckDrawable(mIconChecked);
        	  } else {
        		  btv.setCheckDrawable(mIconUnchecked);
        	  }
          } else {
        	  btv.setCheckVisible(false);
          }
          
          Object icon = curItem.getIconBitmap();
          if(icon instanceof Bitmap){
        	  btv.setIcon((Bitmap) icon);
          } else {
        	  btv.setIcon((Drawable) icon);
          }
          
          if(!scrolling && FileUtils.getFile(parentFile, curItem.getText()).isFile() && !"video/mpeg".equals(mMimeTypes.getMimeType(curItem.getText()))){
        	  if(mThumbnailLoader != null) {
        		  mThumbnailLoader.loadImage(parentFile.getPath(), curItem, btv.getImageView());
        	  }
          }
          
          return btv; 
     }


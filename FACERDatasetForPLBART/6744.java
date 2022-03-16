     public IconifiedTextListAdapter(Context context) { 
          mContext = context; 
          
          mThumbnailLoader = new ThumbnailLoader(context);
          
          // Cache the checked and unchecked icons so we're not decoding them everytime getView is called.
          mIconChecked = context.getResources().getDrawable(R.drawable.ic_button_checked);
          mIconUnchecked = context.getResources().getDrawable(R.drawable.ic_button_unchecked);
     } 


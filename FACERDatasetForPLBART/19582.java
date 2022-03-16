    public StackRemoteViewsFactory(Context context, Intent intent) {
        mContext = context;
        mApp = (Common) mContext.getApplicationContext();
        
        sharedPreferences = context.getSharedPreferences("com.aniruddhc.acemusic.player", Context.MODE_PRIVATE);
        cursor = mApp.getService().getCursor();
        mWidgetColor = intent.getStringExtra("WIDGET_COLOR");

        //Create a set of options to optimize the bitmap memory usage.
        final BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        options.inJustDecodeBounds = false;
        options.inPurgeable = true;
        
        //Display Image Options.
        displayImageOptions = new DisplayImageOptions.Builder()
        						  .showImageForEmptyUri(R.drawable.default_album_art)
        						  .showImageOnFail(R.drawable.default_album_art)
        						  .cacheInMemory(true)
        						  .cacheOnDisc(true)
        						  .decodingOptions(options)
        						  .imageScaleType(ImageScaleType.EXACTLY)
        						  .bitmapConfig(Bitmap.Config.RGB_565)
        						  .displayer(new FadeInBitmapDisplayer(400))
        						  .build();
        
    }


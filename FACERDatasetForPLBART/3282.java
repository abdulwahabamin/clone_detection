    /**
     *  First time loading of the LoaderImageView
     *  Sets up the LayoutParams of the view, you can change these to
     *  get the required effects you want
     */
    //public void instantiate(final Context context, final String imageUrl) {
    public void instantiate(final Context context) {
    	thisFragment=this;
            mContext = context;

            mImage = new ImageView(mContext);
            mImage.setLayoutParams(new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT));

            mSpinner = new ProgressBar(mContext);
            mSpinner.setLayoutParams(new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT));

            mSpinner.setIndeterminate(true);

            addView(mSpinner);
            addView(mImage);
            /*
            if(imageUrl != null){
                    setImageDrawable(imageUrl);
            }
            */
    }


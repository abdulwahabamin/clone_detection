    /**
     * Set's the view's drawable, this uses the internet to retrieve the image
     * don't forget to add the correct permissions to your manifest
     * @param imageUrl the url of the image you wish to load
     */
    public void setImageDrawable(final String imageUrl) {
            mDrawable = null;
            mSpinner.setVisibility(View.VISIBLE);
            mImage.setVisibility(View.GONE);
            new Thread(){
                    public void run() {
                            try {
                                    mDrawable = getDrawableFromUrl(imageUrl);
                                    imageLoadedHandler.sendEmptyMessage(COMPLETE);
                            } catch (MalformedURLException e) {
                                    imageLoadedHandler.sendEmptyMessage(FAILED);
                            } catch (IOException e) {
                                    imageLoadedHandler.sendEmptyMessage(FAILED);
                            }
                    };
            }.start();
    }


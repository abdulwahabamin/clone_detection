    /**
     * Initializes a DisplayImageOptions object. The drawable shown
     * while an image is loading is based on the current theme.
     */
    public void initDisplayImageOptions() {

        //Create a set of options to optimize the bitmap memory usage.
        final BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        options.inJustDecodeBounds = false;
        options.inPurgeable = true;

        int emptyColorPatch = UIElementsHelper.getEmptyColorPatch(this);
        mDisplayImageOptions = null;
        mDisplayImageOptions = new DisplayImageOptions.Builder()
                                                      .showImageForEmptyUri(emptyColorPatch)
                                                      .showImageOnFail(emptyColorPatch)
                                                      .showImageOnLoading(emptyColorPatch)
                                                      .cacheInMemory(true)
                                                      .cacheOnDisc(true)
                                                      .decodingOptions(options)
                                                      .imageScaleType(ImageScaleType.IN_SAMPLE_POWER_OF_2)
                                                      .bitmapConfig(Bitmap.Config.ARGB_4444)
                                                      .delayBeforeLoading(400)
                                                      .displayer(new FadeInBitmapDisplayer(200))
                                                      .build();

    }


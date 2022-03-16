    @Override
    public void onCreate() {
        super.onCreate();

        INSTANCE=this;
        typeface=Typeface.createFromAsset(getAssets(),"fonts/RobotoSlab.ttf");
        StrictMode.VmPolicy.Builder builder = new StrictMode.VmPolicy.Builder();
        StrictMode.setVmPolicy(builder.build());
        options=new RequestOptions();
        options.placeholder(R.drawable.progress_drawable)
                .fitCenter()
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .sizeMultiplier(0.8f)
                .useAnimationPool(true);
        circleOptions=new RequestOptions();
        circleOptions.placeholder(R.drawable.progress_drawable)
                .fitCenter()
                .diskCacheStrategy(DiskCacheStrategy.AUTOMATIC)
                .sizeMultiplier(0.8f)
                .circleCrop()
                .useAnimationPool(true)
                ;

    }


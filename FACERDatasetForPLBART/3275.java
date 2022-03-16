    public static void preLoadImage(Activity activity, File f, int width, int height) {
        if(staticimage==null)
            staticimage=new bGridViewImage(activity);
        PreloadImageTask pmt = staticimage.new PreloadImageTask();
        pmt.setData(f,width ,height);
        pmt.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, true);

    }


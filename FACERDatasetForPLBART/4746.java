    @Override
    public Object instantiateItem(ViewGroup container, int position) {

        //Button btnClose;
        //if(loadFullSize!=null)
        //    loadFullSize.removeCallbacks(lfs);

        currentPosition=position;

        inflater = (LayoutInflater) _activity
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View viewLayout = inflater.inflate(R.layout.images_slider_item, container,false);



        //btnClose = (Button) viewLayout.findViewById(R.id.btnClose);


        //options.inSampleSize=6;
        //if(!firstloaded) {
        imgDisplay = (CustomZoomableImageView) viewLayout.findViewById(R.id.imgDisplay);
//BLog.e("Image file size: "+_imagePaths.get(position).length());
        if(_imagePaths.get(position).length()>1000000) {
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inPreferredConfig = Bitmap.Config.ARGB_8888;
            options.inSampleSize=4;
            bitmap = BitmapFactory.decodeFile(_imagePaths.get(position).getAbsolutePath(), options);
        } else if(_imagePaths.get(position).length()>500000) {
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inPreferredConfig = Bitmap.Config.ARGB_8888;
            options.inSampleSize=2;
            bitmap = BitmapFactory.decodeFile(_imagePaths.get(position).getAbsolutePath(), options);
        } else  {
            bitmap = BitmapFactory.decodeFile(_imagePaths.get(position).getAbsolutePath(), null);
        }

        imgDisplay.setImageBitmap(bitmap);
            //firstloaded=true;
        //}

        viewLayout.setTag(_imagePaths.get(position).getAbsolutePath());

        ((ViewPager) container).addView(viewLayout);
        //Log.e("LOAD", "SHOW IMAGE w: " + bitmap.getWidth() + " - h: " + bitmap.getHeight());
        return viewLayout;
    }


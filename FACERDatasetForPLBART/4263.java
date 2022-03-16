        @Override
        protected void onPostExecute(Boolean result) {
            if(forview!=null) {

                if(cb.bitmap==null) {

                    // LoadImageTask loadImage = new LoadImageTask();
                    // loadImage.setData(image,pos,forview);
                    // loadImage.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, true);
                } else {
                    forview.setId(R.id.file_images_image_view_id);
                    forview.setScaleType(ImageView.ScaleType.CENTER_CROP);

                    forview.setLayoutParams(new RelativeLayout.LayoutParams(380, 300));

                    forview.setPadding(0, 0, 0, 0);
                    forview.setImageBitmap(cb.bitmap);
//parent.getChildAt(pos).invalidate();
                    //notifyDataSetChanged();
//parent.refreshDrawableState();
                    /*
                    forview.setId(R.id.file_images_image_view_id);
                    forview.setScaleType(ImageView.ScaleType.CENTER_CROP);
                    forview.setImageBitmap(cb.bitmap);
                    forview.setLayoutParams(new RelativeLayout.LayoutParams(380, 300));

                    forview.setPadding(0, 0, 0, 0);
                    */

                }


            }
            //refreshIfVisible(image, pos);
        }


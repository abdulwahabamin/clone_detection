        @Override
        protected void onPostExecute(Boolean result) {
            //list
            if(result && cb.bitmap!=null) {
                mBitmap = cb.bitmap;

                mImage.setPadding(0, 0, 0, 0);
                //mImage.setLayoutParams(new GridView.LayoutParams(width, height));
                mImage.setScaleType(ImageView.ScaleType.CENTER_CROP);
                imageLoadedHandler.postDelayed(callme,10);
            }

        }


        public boolean handleMessage(Message msg) {
            if(mBitmap!=null) {
                mImage.setImageBitmap(mBitmap);
                mImage.setVisibility(View.VISIBLE);
                mImage.setAnimation(alphaAnim);
                mSpinner.setVisibility(View.GONE);

            } else if(mDrawable!=null) {

                mImage.setImageDrawable(mDrawable);
                mImage.setVisibility(View.VISIBLE);

                mImage.setAnimation(alphaAnim);
                mSpinner.setVisibility(View.GONE);
            } else {

                mImage.setVisibility(View.VISIBLE);
                mSpinner.setVisibility(View.VISIBLE);

            }


            return true;
        }


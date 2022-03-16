        @Override
        public void run() {


                mImage.setImageBitmap(null);
                mImage.setImageBitmap(mBitmap);
                mImage.setVisibility(View.VISIBLE);

                mImage.setAnimation(alphaAnim);
                mSpinner.setVisibility(View.GONE);
            if(adapter!=null) {
                adapter.notifyDataSetChanged();
            }
                //this.notify();
                //mImage.refreshDrawableState();

        }


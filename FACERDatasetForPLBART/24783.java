    private static void changebgImageAnimation(final Bitmap bitmap){
        new AsyncTask<Bitmap, Void, Bitmap>() {
            @Override
            protected Bitmap doInBackground(Bitmap... params) {
                try {
                    return GetBlur.FastBlur(params[0],1.1f,25);
                }
                catch (Exception e){
                    return null;
                }
            }

            @Override
            protected void onPostExecute(final Bitmap bitmap) {
                ViewAnimator.animate(mControl_bg1)
                        .alpha(1,0)
                        .onStart(new AnimationListener.Start() {
                            @Override
                            public void onStart() {
                                mControl_bg.setImageBitmap(bitmap);
                            }
                        })
                        .onStop(new AnimationListener.Stop() {
                            @Override
                            public void onStop() {
                                mControl_bg1.setImageBitmap(bitmap);
                            }
                        })
                        .duration(600)
                        .start();
            }
        }.execute(bitmap);
        new AsyncTask<Bitmap, Void, Bitmap>() {
            @Override
            protected Bitmap doInBackground(Bitmap... params) {
                try{
                    return GetBlur.FastBlur(params[0],1.1f,16);
                }
                catch (Exception e){
                    return null;
                }
            }

            @Override
            protected void onPostExecute(final Bitmap bitmap) {
                ViewAnimator.animate(mActivity_bg_image1)
                        .alpha(1, 0)
                        .onStart(new AnimationListener.Start() {
                            @Override
                            public void onStart() {
                                mActivity_bg_image.setImageBitmap(bitmap);
                            }
                        })
                        .onStop(new AnimationListener.Stop() {
                            @Override
                            public void onStop() {
                                mActivity_bg_image1.setImageBitmap(bitmap);
                            }
                        })
                        .duration(600)
                        .start();
            }
        }.execute(bitmap);
    }


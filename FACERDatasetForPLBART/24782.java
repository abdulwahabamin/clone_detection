    private static void changeImageAnimation(final Bitmap bitmap){
        ViewAnimator.animate(mMiniAlbumArt1, mAlbumArt1)
                .alpha(1, 0)
                .duration(600)
                .onStart(new AnimationListener.Start() {
                    @Override
                    public void onStart() {
                        mAlbumArt.setImageBitmap(bitmap);
                        mMiniAlbumArt.setImageBitmap(bitmap);
                    }
                })
                .onStop(new AnimationListener.Stop() {
                    @Override
                    public void onStop() {
                        mAlbumArt1.setImageBitmap(bitmap);
                        mMiniAlbumArt1.setImageBitmap(bitmap);
                    }
                }).start();
    }


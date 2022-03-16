    /**
     * @param mService
     * @param mImageButton
     * @param id
     */
    public static void setFavoriteImage(ImageButton mImageButton) {
        try {
            if (MusicUtils.mService.isFavorite(MusicUtils.mService.getAudioId())) {
                mImageButton.setImageResource(R.drawable.apollo_holo_light_favorite_selected);
            } else {
                mImageButton.setImageResource(R.drawable.apollo_holo_light_favorite_normal);
            }
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }


    /**
     * Set the shuffle images
     */
    private void setShuffleButtonImage() {
        if (MusicUtils.mService == null)
            return;
        try {
            switch (MusicUtils.mService.getShuffleMode()) {
                case ApolloService.SHUFFLE_NONE:
                    mShuffle.setImageResource(R.drawable.butter_holo_light_shuffle_normal);
                    // Theme chooser
                    ThemeUtils.setImageButton(getActivity(), mShuffle, "apollo_shuffle_normal");
                    break;
                case ApolloService.SHUFFLE_AUTO:
                    mShuffle.setImageResource(R.drawable.butter_holo_light_shuffle_on);
                    break;
                default:
                    mShuffle.setImageResource(R.drawable.butter_holo_light_shuffle_on);
                    break;
            }
        } catch (RemoteException ex) {
            ex.printStackTrace();
        }
    }


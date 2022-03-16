    private void updateMediaDescription(MediaDescriptionCompat description) {
        FireLog.d(TAG, "(++) updateMediaDescription");
        if (description == null) {
            return;
        }
        setMediaDescription(description);

        titleView.setText(description.getTitle());
        subTitleView.setText(description.getSubtitle());

        // prevent multiple calls
        String artUrl = null;
        if (description.getIconUri() != null) {
            artUrl = description.getIconUri().toString();
        }
        if (!TextUtils.equals(artUrl, mArtUrl)) {
            mArtUrl = artUrl;
            ImageHelper.loadArtAndBlurBg(this, albumArt, bgView, description);
        }
        ImageHelper.loadArtAndBlurBg(this, albumArt, bgView, description);
    }


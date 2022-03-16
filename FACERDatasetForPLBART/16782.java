    private void onMetadataChanged(MediaMetadataCompat metadata) {
        FireLog.d(TAG, "(++) onMetadataChanged " + metadata);
        if (getActivity() == null) {
            FireLog.w(TAG, "onMetadataChanged called when getActivity null," +
                    "this should not happen if the callback was properly unregistered. Ignoring.");
            return;
        }

        if (metadata == null) {
            return;
        }

        FireLog.i(TAG, "title=" + metadata.getDescription().getTitle().toString());

        title.setText(metadata.getDescription().getTitle());
        subtitle.setText(metadata.getDescription().getSubtitle());

        // prevent multiple calls
        String artUrl = null;
        if (metadata.getDescription().getIconUri() != null) {
            artUrl = metadata.getDescription().getIconUri().toString();
        }
        FireLog.d(TAG, "mArtUrl=" + mArtUrl + ", artUrl=" + artUrl);
        if (!TextUtils.equals(artUrl, mArtUrl)) {
            mArtUrl = artUrl;
//            ImageHelper.loadArt(getContext(), albumArt, metadata.getDescription());
//            ImageHelper.loadBlurBg(getContext(), bgView, metadata.getDescription());
            ImageHelper.loadArtAndBlurBg(getContext(), albumArt, bgView, metadata.getDescription());
        }
    }


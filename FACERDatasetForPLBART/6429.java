    private void deriveFields() {
        derivedMimeTypes = (mimeTypes != null) ? mimeTypes.split("\n") : null;

        // TODO: remove these special case icons
        if (isExternalStorage()) {
            derivedIcon = R.drawable.ic_root_sdcard;
        } else if (isDownloads()) {
            derivedIcon = R.drawable.ic_root_download;
        } else if (isImages()) {
            derivedIcon = R.drawable.ic_doc_image;
        } else if (isVideos()) {
            derivedIcon = R.drawable.ic_doc_video;
        } else if (isAudio()) {
            derivedIcon = R.drawable.ic_doc_audio;
        }
    }


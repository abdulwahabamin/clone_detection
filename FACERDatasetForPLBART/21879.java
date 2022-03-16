    @Override
    public String toString() {
        try {
            return URLEncoder.encode(mArtist, "UTF-8") + ',' + URLEncoder.encode(mTrack, "UTF-8") + ',' + Long.toHexString(mTimestamp);
        } catch (UnsupportedEncodingException ignored) {
            return "";
        }
    }


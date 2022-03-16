        @Override
        protected Integer doInBackground(Long... params) {
            long id = params[0];
            try {
                bmp = getTrackArtwork(id);
                if (bmp != null) {
                    cache.put(id, bmp);
                } else {
                    Log.d(TAG, "doInBackground(" + id + ") - Unable to get artwork.");
                    badArtwork.put(id, true);
                    return 0;
                }
            } catch (Exception e) {
                e.printStackTrace();
                badArtwork.put(id, true);
                Log.d(TAG, "doInBackground(" + id + ") - Unable to get artwork.");
                return 0;
            }
            return 1;
        }


        @Override
        public void doOnMainThread() {
            if(albumArtFile != null) {
                imageLoadTask = asyncImageLoader.loadImageAsync(
                        imageView, albumArtFile.getAbsolutePath());
            }
        }


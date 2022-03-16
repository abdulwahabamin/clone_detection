            @Override
            protected Boolean doInBackground(Boolean... params) {
                //BLog.e("POINT", "1");
                ImageCache.CacheBitmap cb = ImageCache.get(image.getPath());
                if(cb==null) {
                    cb=ImageCache.getNewCacheBitmap();
                    cb.status=ImageCache.CACHE_B_LOADING;
                    ImageCache.put(image.getPath(), cb);
                    Bitmap bitmap=getThumbnail(image.getPath());
                    if(bitmap==null) {
                        if(image.isDirectory()) {
                            // TODO
                        } else {
                            bitmap = getPreview(image);
                        }

                    }
                    cb.bitmap=bitmap;
                    cb.status=ImageCache.CACHE_B_LOADED;
                    ImageCache.putFinal(image.getPath(), cb);

                }
                return Boolean.TRUE;

            }


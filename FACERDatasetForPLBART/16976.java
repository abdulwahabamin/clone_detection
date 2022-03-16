        @Override
        protected void onPostExecute(Bitmap result) {
            if (context == null || ((Activity) context).isFinishing()
                    || ((Activity) context).isDestroyed()) {
                return;
            }
            if (result != null) {
                if (key != null)
                    blurredDrawableCache.put(key, result);
                setBackground(context, imageView, result);
            }
        }


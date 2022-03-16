        @Override
        protected void onPostExecute(Bitmap result) {
            if (mIconThumb.getTag() == this && result != null) {
                mIconThumb.setTag(null);
                mIconThumb.setImageBitmap(result);

                final float targetAlpha = mIconMime.isEnabled() ? 1f : 0.5f;
                mIconMime.setAlpha(targetAlpha);
                mIconMime.animate().alpha(0f).start();
                mIconThumb.setAlpha(0f);
                mIconThumb.animate().alpha(targetAlpha).start();
            }
        }


        @Override
        protected void onPostExecute(Drawable result) {
            super.onPostExecute(result);
            ImageView imageView = imageViewReference.get();
            if (imageView != null) {
                imageView.setImageDrawable(result);
            }
        }


        @Override
        protected void onPostExecute(Integer result) {
            if ((result == 1) && (bmp != null)) {
                mImageView.setImageBitmap(bmp);
            }
            backgroundImageExtractionFinished();
            super.onPostExecute(result);
        }


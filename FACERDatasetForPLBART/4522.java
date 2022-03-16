        @Override
        public boolean onScale(ScaleGestureDetector detector) {
            mScaleFactor *= detector.getScaleFactor();

            pivotPointX = detector.getFocusX();
            pivotPointY = detector.getFocusY();

            //Log.e(LOG_TAG, "mScaleFactor " + mScaleFactor);
            //Log.e(LOG_TAG, "pivotPointY " + pivotPointY + ", pivotPointX= " + pivotPointX);
            mScaleFactor = Math.max(minScale, mScaleFactor);
            mScaleFactor = Math.min(maxScale, mScaleFactor);

            invalidate();
            return true;
        }


        @Override
        public void onStart() {
            super.onStart();

            // Create the paint used for draw text
            Typeface courier = Typeface.createFromAsset(mCtx.getAssets(),
                    "fonts/Courier-Prime.ttf");
            mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
            mPaint.setTypeface(courier);
            mPaint.setTextSize(mCtx.getResources().getDimensionPixelSize(
                    R.dimen.print_text_size));
            mPaint.setColor(Color.BLACK);

            // Get the text width and height
            mTextBounds = new RectF();
            mTextBounds.right = mPaint.measureText(new char[]{'A'}, 0, 1);
            mTextBounds.bottom = mPaint.getFontMetrics().descent
                    - mPaint.getFontMetrics().ascent + mPaint.getFontMetrics().leading;

            mLines = new ArrayList<String>();
            mAdjustedLines = new ArrayList<String>();
            mReader.read(mLines, mAdjustedLines);
        }


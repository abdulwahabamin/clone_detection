  	public TypefaceSpan(Context context, String typefaceName) {
      	mTypeface = sTypefaceCache.get(typefaceName);

      	if (mTypeface == null) {
          	mTypeface = Typeface.createFromAsset(context.getApplicationContext().getAssets(), String.format("fonts/%s.ttf", typefaceName));

          	// Cache the loaded Typeface
          	sTypefaceCache.put(typefaceName, mTypeface);
      	}
  	}


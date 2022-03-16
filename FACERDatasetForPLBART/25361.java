    public static RalewayFont getInstance(Context context) {
        synchronized (RalewayFont.class) {
            if (instance == null) {
                instance = new RalewayFont();
                lightTypeface = Typeface.createFromAsset(context.getApplicationContext().getResources().getAssets(), "raleway-light.ttf");
                regularTypeface = Typeface.createFromAsset(context.getApplicationContext().getResources().getAssets(), "raleway-regular.ttf");
            }
            return instance;
        }
    }


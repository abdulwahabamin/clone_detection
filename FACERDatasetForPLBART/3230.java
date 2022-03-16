    public static void fixDrawableLevels(TextView textview) {
    	// Fix level of existing drawables
    	Drawable[] drawables = textview.getCompoundDrawables();
    	for (Drawable d : drawables) if (d != null && d instanceof ScaleDrawable) d.setLevel(1);
    	textview.setCompoundDrawables(drawables[0], drawables[1], drawables[2], drawables[3]);
    }


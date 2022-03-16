    private Drawable createVectorDrawable(int drawableId, int color) {

        VectorDrawableCompat vectorDrawableCompat = VectorDrawableCompat.create(getResources(), drawableId, context.getTheme());
        assert vectorDrawableCompat != null;
        DrawableCompat.setTint(vectorDrawableCompat, color);
        DrawableCompat.setTintMode(vectorDrawableCompat, PorterDuff.Mode.SRC_IN);

        return vectorDrawableCompat;
    }


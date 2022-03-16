    private Drawable createDrawable(int color) {
        OvalShape ovalShape = new OvalShape();
        ShapeDrawable shapeDrawable = new ShapeDrawable(ovalShape);
        shapeDrawable.getPaint().setColor(color);

        if (mShadow && !hasLollipopApi()) {
            Drawable shadowDrawable = getResources().getDrawable(mType == TYPE_NORMAL ? R.drawable.fab_shadow
                    : R.drawable.fab_shadow_mini);
            if(!State.getSettings().getBoolean(BriefSettings.BOOL_STYLE_DARK)) {
                int primaryColor = getResources().getColor(R.color.white);
                try {
                    shadowDrawable.setColorFilter(Color.WHITE, PorterDuff.Mode.SRC_ATOP);
                } catch(Exception e) {}
            }
            LayerDrawable layerDrawable = new LayerDrawable(new Drawable[]{shadowDrawable, shapeDrawable});
            layerDrawable.setLayerInset(1, mShadowSize, mShadowSize, mShadowSize, mShadowSize);
            return layerDrawable;
        } else {
            return shapeDrawable;
        }
    }


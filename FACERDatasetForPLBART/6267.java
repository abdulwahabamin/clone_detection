    @Override
    public void setBackground(Drawable background) {
        final Rect rect = new Rect();
        background.getPadding(rect);
        final InsetDrawable inset = new InsetDrawable(background, -rect.left, 0, -rect.right, 0);
        super.setBackground(inset);
    }


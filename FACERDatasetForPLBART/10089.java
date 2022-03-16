    /**
     * {@inheritDoc}
     */
    @Override
    protected void onBindView(View view) {
        super.onBindView(view);
        View v = view.findViewById(R.id.color_picker);
        if (v != null && v instanceof ColorPanelView) {
            this.mColorPicker = (ColorPanelView)v;
            this.mColorPicker.setColor(this.mColor);
        }
    }


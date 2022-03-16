    /**
     * {@inheritDoc}
     */
    @Override
    public void onColorChanged(int color) {
        this.mNewColorView.setColor(color);
        this.etColor.removeTextChangedListener(this);
        this.etColor.setText(toHex(this.mNewColorView.getColor()));
        this.etColor.addTextChangedListener(this);
    }


    /**
     * {@inheritDoc}
     */
    @Override
    protected void onPrepareDialogBuilder(Builder builder) {
        super.onPrepareDialogBuilder(builder);

        // Configure the dialog
        this.mColorDlg = new ColorDialogView(getContext());
        this.mColorDlg.setColor(this.mColor);
        this.mColorDlg.showAlphaSlider(true);
        this.mColorDlg.setAlphaSliderText(
                getContext().getString(R.string.color_picker_alpha_slider_text));
        this.mColorDlg.setCurrentColorText(
                getContext().getString(R.string.color_picker_current_text));
        this.mColorDlg.setNewColorText(
                getContext().getString(R.string.color_picker_new_text));
        this.mColorDlg.setColorLabelText(
                getContext().getString(R.string.color_picker_color));
        builder.setView(this.mColorDlg);

        // The color is selected by the user and confirmed by clicking ok
        builder.setPositiveButton(android.R.string.ok, new OnClickListener() {
            @Override
            @SuppressWarnings("synthetic-access")
            public void onClick(DialogInterface dialog, int which) {
                int color = ColorPickerPreference.this.mColorDlg.getColor();
                if (callChangeListener(Integer.valueOf(color))) {
                    setColor(color);
                }
                dialog.dismiss();
            }
        });
    }


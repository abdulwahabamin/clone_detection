    protected RelativeLayout createPin() {
        final RelativeLayout pinLayout = new RelativeLayout(getContext());
        pinLayout.setVisibility(View.INVISIBLE);

        final Pin pin = new Pin(getContext());
        pin.setId(ID_PIN);
        final RelativeLayout.LayoutParams pinParams = new RelativeLayout.LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
        pinParams.addRule(RelativeLayout.ALIGN_PARENT_RIGHT);
        pinParams.addRule(RelativeLayout.ALIGN_BOTTOM, ID_PIN_TEXT);
        pinParams.addRule(RelativeLayout.ALIGN_TOP, ID_PIN_TEXT);
        pin.setLayoutParams(pinParams);
        pinLayout.addView(pin);

        final TextView indicatorTextView = new TextView(getContext());
        indicatorTextView.setId(ID_PIN_TEXT);
        final RelativeLayout.LayoutParams indicatorParams = new RelativeLayout.LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
        indicatorParams.addRule(RelativeLayout.LEFT_OF, ID_PIN);
        indicatorTextView.setLayoutParams(indicatorParams);
        indicatorTextView.setTextColor(Color.WHITE);
        indicatorTextView.setGravity(Gravity.CENTER);
        indicatorTextView.setBackgroundColor(GREY_LIGHT);
        pinLayout.addView(indicatorTextView);

        return pinLayout;
    }


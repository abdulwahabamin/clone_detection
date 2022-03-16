    private void smallLarge(List<TextView> tvList) {
        for (TextView textView : tvList) {
            float textSize = textView.getTextSize();
            textView.setTextSize(TypedValue.COMPLEX_UNIT_PX, textSize * 11 / 8);
        }
    }


    /**
     * �?�父容器中填充View
     */
    private void fillViewToParent(Context context) {
        indicatorStrings = context.getResources().getStringArray(indicatorStringsResourceId);
        indicatorColorIds = context.getResources().getIntArray(indicatorColorsResourceId);
        if (indicatorStrings.length != indicatorColorIds.length) {
            throw new IllegalArgumentException("qualities和aqiColors的数组长度�?一致�?");
        }
        for (int i = 0; i < indicatorStrings.length; i++) {
            addTextView(context, indicatorStrings[i], indicatorColorIds[i]);
            if (i != (indicatorStrings.length - 1)) {
                addBlankView(context);
            }
        }
    }


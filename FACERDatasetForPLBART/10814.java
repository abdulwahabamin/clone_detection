    /**
     * Method that sets a new <code>Spannable</code>.
     *
     * @param spanable The spannable
     * @param color The color of the span
     * @param start The start of the span
     * @param end The end of the span
     */
    @SuppressWarnings("static-method")
    protected void setSpan(Spannable spanable, int color, int start, int end) {
        if (start == end) return;
        spanable.setSpan(
                new ForegroundColorSpan(color),
                start,
                end,
                Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
    }


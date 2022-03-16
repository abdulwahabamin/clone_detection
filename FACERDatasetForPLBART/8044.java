    /**
     * Method that clear all the existent spans
     *
     * @param spanable The spannable
     */
    @SuppressWarnings("static-method")
    public void clear(Spannable spanable) {
        ForegroundColorSpan[] spans =
                spanable.getSpans(0, spanable.length(), ForegroundColorSpan.class);
        int cc = spans.length;
        for (int i = 0; i < cc; i++) {
            spanable.removeSpan(spans[i]);
        }
    }


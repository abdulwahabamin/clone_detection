    /**
     * {@inheritDoc}
     */
    @Override
    public void process(final Spannable spanable) {
        this.mMultiLine = false;
        this.mSpannable = spanable;
        clear(spanable);
        NewLineScanner scanner = new NewLineScanner(spanable, new NewLineScannerListener() {
            @Override
            public boolean onNewLine(CharSequence newline, int start, int end, CharSequence sep) {
                processNewLine(newline, start, end);
                return true;
            }

        });
        scanner.scan();
        this.mSpannable = null;
    }


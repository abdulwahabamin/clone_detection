    /**
     * {@inheritDoc}
     */
    @Override
    public void scan() {
        if (this.mInput.length() == 0) return;
        Matcher m = RegExpUtil.NEWLINE_PATTERN.matcher(this.mInput);
        int next = 0;
        while(m.find(next)) {
            CharSequence line = this.mInput.subSequence(next, m.start());
            if (!this.mListener.onNewLine(line, next, m.start(), m.group())) {
                return;
            }
            next = m.end();
        }
        // The non-matched data
        CharSequence line = this.mInput.subSequence(next, this.mInput.length());
        this.mListener.onNewLine(line, next, this.mInput.length(), null);
    }


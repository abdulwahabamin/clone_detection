    /**
     * A method to process every new line
     *
     * @param newline The newline
     * @param start The start position of the line
     * @param end The end position of the line
     * @hide
     */
    void processNewLine(CharSequence newline, int start, int end) {
        // Remove all spannable of the line (this processor doesn't multiline spans and
        // only uses ForegroundColorSpan spans)
        ForegroundColorSpan[] spans =
                this.mSpannable.getSpans(start, end, ForegroundColorSpan.class);
        int cc = spans.length;
        for (int i = 0; i < cc; i++) {
            this.mSpannable.removeSpan(spans[i]);
        }

        // Find comment
        Matcher cm = COMMENT.matcher(newline);
        if (cm.matches()) {
            // All the line is a comment
            setSpan(this.mSpannable, this.mCommentColor, start, end);
            this.mMultiLine = false;
            return;
        }

        // Has multiline
        Matcher mlm = MULTILINE.matcher(newline);
        boolean ml = mlm.matches();

        //Find the assignment
        int k = this.mMultiLine ? -1 : start;
        int v = start;
        int v2 = 0;
        int a = -1;
        if (!this.mMultiLine) {
            Matcher am = ASSIGNMENT.matcher(newline);
            if (am.find()) {
                // Assignment found
                v2 = am.start() + 1;
                a = start + am.start();
                v = a + 1;
            }
        }

        // All the string is a key
        if (!this.mMultiLine && a == -1) {
            setSpan(this.mSpannable, this.mKeyColor, start, end);

        } else {
            // Key
            if (!this.mMultiLine) {
                setSpan(this.mSpannable, this.mKeyColor, k, a);
            }
            // Assignment
            if (!this.mMultiLine) {
                setSpan(this.mSpannable, this.mAssignmentColor, a, a + 1);
            }
            // Value
            setSpan(this.mSpannable, this.mValueColor, v, end);
            // Argument
            Matcher argm = ARGUMENT.matcher(newline);
            while (argm.find(v2)) {
                int s = start + argm.start();
                int e = start + argm.end();
                setSpan(this.mSpannable, this.mArgumentColor, s, e);
                v2 = argm.end();
            }
        }

        // Multiline?
        this.mMultiLine = ml;
    }


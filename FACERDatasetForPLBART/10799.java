    /**
     * {@inheritDoc}
     */
    @Override
    public void process(final Spannable spanable, final int start, final int end) {
        // We need a Retrieve the previous line
        this.mMultiLine = false;
        this.mSpannable = spanable;
        CharSequence seqs = spanable.subSequence(0, start);
        CharSequence seqe = spanable.subSequence(end, spanable.length());
        int s1 = RegExpUtil.getLastMatch(RegExpUtil.NEWLINE_PATTERN, seqs, false);
        if (s1 == RegExpUtil.NO_MATCH) {
            s1 = 0;
        }
        int e1 = RegExpUtil.getNextMatch(RegExpUtil.NEWLINE_PATTERN, seqe, false);
        if (e1 == RegExpUtil.NO_MATCH) {
            e1 = spanable.length();
        } else {
            e1 += end;
        }

        // Also, we need to know about if the previous line is multiline
        if (s1 > 0) {
            int s2 = RegExpUtil.getLastMatch(RegExpUtil.NEWLINE_PATTERN, seqs, true);
            CharSequence seqnl = spanable.subSequence(0, s2);
            int snl = RegExpUtil.getLastMatch(RegExpUtil.NEWLINE_PATTERN, seqnl, false);
            Matcher mlm = MULTILINE.matcher(
                    spanable.subSequence(snl != RegExpUtil.NO_MATCH ? snl : 0, s2));
            this.mMultiLine = mlm.matches();
        }

        // Process the new line
        if (s1 != e1) {
            processNewLine(spanable.subSequence(s1, e1), s1, e1);
        }

        // Now, multiline again (next line). We check always the next line, because we
        // don't know if user delete multiline flag in the current line
        e1 = RegExpUtil.getNextMatch(RegExpUtil.NEWLINE_PATTERN, seqe, true);
        if (e1 != RegExpUtil.NO_MATCH) {
            e1 += end;
            seqe = spanable.subSequence(e1, spanable.length());
            int e2 = RegExpUtil.getNextMatch(RegExpUtil.NEWLINE_PATTERN, seqe, false);
            if (e2 == RegExpUtil.NO_MATCH) {
                e2 = spanable.length();
            } else {
                e2 += e1;
            }
            processNewLine(spanable.subSequence(e1, e2), e1, e2);
        }

        this.mSpannable = null;
    }


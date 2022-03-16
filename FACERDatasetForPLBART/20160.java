    public String build() {
        final StringBuilder noticesHtmlBuilder = new StringBuilder(500);
        appendNoticesContainerStart(noticesHtmlBuilder);
        if (mNotice != null) {
            appendNoticeBlock(noticesHtmlBuilder, mNotice);
        } else if (mNotices != null) {
            for (final Notice notice : mNotices.getNotices()) {
                appendNoticeBlock(noticesHtmlBuilder, notice);
            }
        } else {
            throw new IllegalStateException("no notice(s) set");
        }
        appendNoticesContainerEnd(noticesHtmlBuilder);
        return noticesHtmlBuilder.toString();
    }


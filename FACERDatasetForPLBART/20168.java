    private static Notice readNotice(final XmlPullParser parser) throws IOException,
        XmlPullParserException {
        parser.require(XmlPullParser.START_TAG, null, "notice");
        String name = null;
        String url = null;
        String copyright = null;
        License license = null;
        while (parser.next() != XmlPullParser.END_TAG) {
            if (parser.getEventType() != XmlPullParser.START_TAG) {
                continue;
            }
            final String element = parser.getName();
            if ("name".equals(element)) {
                name = readName(parser);
            } else if ("url".equals(element)) {
                url = readUrl(parser);
            } else if ("copyright".equals(element)) {
                copyright = readCopyright(parser);
            } else if ("license".equals(element)) {
                license = readLicense(parser);
            } else {
                skip(parser);
            }
        }
        return new Notice(name, url, copyright, license);
    }


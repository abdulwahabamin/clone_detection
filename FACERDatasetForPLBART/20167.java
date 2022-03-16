    private static Notices parse(final XmlPullParser parser) throws IOException, XmlPullParserException {
        final Notices notices = new Notices();
        parser.require(XmlPullParser.START_TAG, null, "notices");
        while (parser.next() != XmlPullParser.END_TAG) {
            if (parser.getEventType() != XmlPullParser.START_TAG) {
                continue;
            }
            final String name = parser.getName();
            // Starts by looking for the entry tag
            if ("notice".equals(name)) {
                notices.addNotice(readNotice(parser));
            } else {
                skip(parser);
            }
        }
        return notices;
    }


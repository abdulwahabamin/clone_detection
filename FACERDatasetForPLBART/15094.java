    /**
     * Loads all generic information from an XML <code>DomElement</code> into
     * the given <code>MusicEntry</code> instance, i.e. the following tags:<br/>
     * <ul>
     * <li>playcount/plays</li>
     * <li>listeners</li>
     * <li>streamable</li>
     * <li>name</li>
     * <li>url</li>
     * <li>mbid</li>
     * <li>image</li>
     * <li>tags</li>
     * </ul>
     * 
     * @param entry An entry
     * @param element XML source element
     */
    protected static void loadStandardInfo(MusicEntry entry, DomElement element) {
        // copy
        entry.name = element.getChildText("name");
        entry.url = element.getChildText("url");
        entry.mbid = element.getChildText("mbid");
        // images
        ImageHolder.loadImages(entry, element);
    }


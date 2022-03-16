    /**
     * Returns the URL of the image in the specified size, or <code>null</code>
     * if not available.
     * 
     * @param size The preferred size
     * @return an image URL
     */
    public String getImageURL(ImageSize size) {
        return imageUrls.get(size);
    }


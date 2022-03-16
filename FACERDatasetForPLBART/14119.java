    protected static void loadImages(ImageHolder holder, DomElement element) {
        Collection<DomElement> images = element.getChildren("image");
        for (DomElement image : images) {
            String attribute = image.getAttribute("size");
            ImageSize size = null;
            if (attribute == null) {
                size = ImageSize.LARGE; 
            } else {
                try {
                    size = ImageSize.valueOf(attribute.toUpperCase(Locale.ENGLISH));
                } catch (IllegalArgumentException e) {
                    // if they suddenly again introduce a new image size
                }
            }
            if (size != null)
                holder.imageUrls.put(size, image.getText());
        }
    }


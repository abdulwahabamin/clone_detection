        @Override
        public Image createItemFromElement(DomElement element) {
            Image i = new Image();
            i.url = element.getChildText("url");
            DomElement sizes = element.getChild("sizes");
            for (DomElement image : sizes.getChildren("size")) {
                // code copied from ImageHolder.loadImages
                String attribute = image.getAttribute("name");
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
                    i.imageUrls.put(size, image.getText());
            }
            return i;
        }


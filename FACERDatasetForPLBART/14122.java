    private ItemFactoryBuilder() {
        // register default factories
        addItemFactory(Album.class, Album.FACTORY);
        addItemFactory(Artist.class, Artist.FACTORY);
        addItemFactory(Image.class, Image.FACTORY);
    }


    /**
     * Retrieves an {@link ItemFactory} for the given type, or <code>null</code>
     * if no such factory was registered.
     * 
     * @param itemClass the type's Class object
     * @return the <code>ItemFactory</code> or <code>null</code>
     */
    @SuppressWarnings("unchecked")
    public <T> ItemFactory<T> getItemFactory(Class<T> itemClass) {
        return factories.get(itemClass);
    }


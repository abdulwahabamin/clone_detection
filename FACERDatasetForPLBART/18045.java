    /**
     * checking if the category is valid ir not
     * @param category category string to be checked
     * @return boolean telling the same
     */
    private static boolean isValidCategory(String category) {
        return category == null
                ||
                (!category.contains(CATEGORY_SEPARATOR) && !category.contains(LEAF_SEPARATOR));
    }


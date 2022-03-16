    /**
     * A Category is valid only when there is no category separator and no leaf separator
     */
    private static boolean isValidCategory(String category) {
        return category == null || (category.indexOf(CATEGORY_SEPARATOR) < 0 && category.indexOf(LEAF_SEPARATOR) < 0);
    }


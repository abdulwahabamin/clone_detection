    /**
     * Method that retrieves the identifier of the resource from his string name.
     *
     * @param res The resources reference
     * @param type The type of resource (drawable, string, ...)
     * @param id The identifier of the resource
     * @return The identifier, or 0 if the resource was not located
     */
    public static int getIdentifier(Resources res, String type, String id) {
        try {
            Class<?> typeClazz =
                    Class.forName(
                            String.format("%s$%s", R.class.getCanonicalName(), type)); //$NON-NLS-1$
            Field idFld = typeClazz.getField(id);
            return idFld.getInt(null);
        } catch (Throwable ex) {
            /**NON BLOCK**/
        }
        return 0;
    }


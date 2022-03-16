    /**
     * Method that creates the {@link AID} from the parsed string.
     *
     * @param src The string to parsed into a {@link AID}
     * @param clazz The {@link User} or {@link Group} class from which create the AID object
     * @return AID The identity reference
     * @throws ParseException If can't create the {@link AID} reference from the string
     * @throws NoSuchMethodException If the constructor can not be found.
     * @exception InstantiationException If the class cannot be instantiated
     * @exception IllegalAccessException If this constructor is not accessible
     * @exception InvocationTargetException If an exception was thrown by the invoked constructor
     */
    @SuppressWarnings({ "unchecked", "static-method", "boxing" })
    private AID createAID(String src, Class<?> clazz)
            throws ParseException, NoSuchMethodException,
            InstantiationException, IllegalAccessException, InvocationTargetException {
        int id = 0;
        try {
            id = Integer.parseInt(src.substring(0, src.lastIndexOf('(')).trim());
        } catch (NumberFormatException nfEx) {
            throw new ParseException(String.format("not valid AID id: %s", src), 0); //$NON-NLS-1$
        }
        String szName = src.substring(src.lastIndexOf('(') + 1, src.lastIndexOf(')'));

        Constructor<AID> constructor =
                (Constructor<AID>)clazz.getConstructor(Integer.TYPE, String.class);
        return constructor.newInstance(id, szName);
    }


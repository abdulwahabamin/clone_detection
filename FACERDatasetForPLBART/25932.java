	/**
	 * Create the object after serialization. This implementation reinitializes
	 * the transient properties.
	 * 
	 * @param in
	 *            ObjectInputStream from which the object is being deserialized.
	 * @throws IOException
	 *             if there is an IO issue.
	 * @throws ClassNotFoundException
	 *             if a class cannot be found.
	 */
	private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
		in.defaultReadObject();
		init();
	}


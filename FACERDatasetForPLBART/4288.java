	/**
	 * Creates a new cipher instance.
	 * @param name name of the cipher to make
	 * @return new cipher instance
	 * @throws ESJException if any error occured
	 */
	public static ICipher createCipher(String name) throws ESJException
	{
		ICipherMaker maker;
		
		synchronized(_cphMks)
		{
			maker = _cphMks.get(name);
			if (null == maker)
			{
				throw new ESJException("no maker registered for cipher \"" +
						name + "\"");
			}
		}
		return maker.create();
	}


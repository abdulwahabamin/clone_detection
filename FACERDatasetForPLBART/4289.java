	/**
	 * Called by cipher implementations to register their factories, usually
	 * during startup time.
	 * @param cphMk the factory to register
	 */
	public static void registerCipher(ICipherMaker cphMk)
	{
		String name = cphMk.getName();
	
		synchronized(_cphMks)
		{
			if (_cphMks.containsKey(name))
			{
				System.err.println("cipher \"" + name +
						"\" has been registered already");
				System.exit(1);
			}
			_cphMks.put(cphMk.getName(), cphMk);
		}
	}


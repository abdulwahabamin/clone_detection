	/**
	 * Sets up a new nonce with the existing cipher instance. 
	 * @param mode see MODE_xxx
	 * @param nonce buffer with nonce material
	 * @param ofs where the nonce starts
	 * @exception ESJException if any error occurs
	 */
	public void setupNonce(byte[] nonce, int ofs) 
		throws ESJException;


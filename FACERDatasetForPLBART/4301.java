	/**
	 * Processes data.
	 * @param inbuf input buffer
	 * @param inOfs where to start reading from the input buffer
	 * @param outbuf output buffer
	 * @param outOfs where to start writing in the output buffer
	 * @param len number of bytes to process, must be aligned to the cipher's
	 * word size except on the last call where an arbitrary size can be used
	 * @throws ESJException in any error occured
	 */
	public void process(
			byte[] inbuf,
			int inOfs,
			byte[] outbuf,
			int outOfs,
			int len) throws ESJException;


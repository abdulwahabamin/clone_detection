	public OutputStream encryptStream(OutputStream out) throws Exception {
		// create a randomly generated IV (initialization vector)
		byte[] iv = new byte[cipher.getBlockSize()];
		new SecureRandom().nextBytes(iv);
		AlgorithmParameterSpec spec = new IvParameterSpec(iv);

		// write the IV to the beginning of the stream
		out.write(iv);

		// setup cipher for encryption and wrap original stream
		cipher.init(Cipher.ENCRYPT_MODE, key, spec);
		return new CipherOutputStream(out, cipher);
	}


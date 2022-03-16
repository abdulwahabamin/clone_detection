	public InputStream decryptStream(InputStream in) throws Exception {
		// read the IV at the beginning of the stream
		byte[] iv = new byte[cipher.getBlockSize()];
		in.read(iv);
		AlgorithmParameterSpec spec = new IvParameterSpec(iv);

		// setup cipher for decryption and wrap original stream
		cipher.init(Cipher.DECRYPT_MODE, key, spec);
		return new CipherInputStream(in, cipher);
	}


	public Encrypt(String keyString) throws Exception {
		// hash password with SHA-256 and crop the output to 128-bit for key
		if(keyString==null)
			throw new Exception();
		MessageDigest digest = MessageDigest.getInstance(useType);
		//MessageDigest digest = MessageDigest.getInstance("SHA-512");
		digest.update(keyString.getBytes("UTF-8"));
		byte[] keyBytes = new byte[16];
		System.arraycopy(digest.digest(), 0, keyBytes, 0, keyBytes.length);

		cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
		key = new SecretKeySpec(keyBytes, "AES");
        byte[] iv = { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
        ivspec= new IvParameterSpec(iv);
	}


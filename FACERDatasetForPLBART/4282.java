	public void setupKey(
			int mode, 
			byte[] key, 
			int ofs) throws ESJException 
	{
		System.arraycopy(key, ofs, this.key, 0, this.key.length);
	}


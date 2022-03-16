    public final static void writeInt32BE(int value, byte[] data, int ofs)
    {
    	data[ofs + 3] = (byte)(value       );
    	data[ofs + 2] = (byte)(value >>>  8);
    	data[ofs + 1] = (byte)(value >>> 16);
    	data[ofs    ] = (byte)(value >>> 24);
    }


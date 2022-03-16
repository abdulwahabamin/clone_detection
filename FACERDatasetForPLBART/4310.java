    public final static void writeInt32LE(int value, byte[] data, int ofs)
    {
    	data[ofs    ] = (byte)(value       );
    	data[ofs + 1] = (byte)(value >>>  8);
    	data[ofs + 2] = (byte)(value >>> 16);
    	data[ofs + 3] = (byte)(value >>> 24);
    }


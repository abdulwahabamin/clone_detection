    public final static int readInt32LE(byte[] data, int ofs)
    {
    	return ( data[ofs + 3]         << 24) |
    		   ((data[ofs + 2] & 0xff) << 16) |
	           ((data[ofs + 1] & 0xff) <<  8) |
	            (data[ofs    ] & 0xff);
    }


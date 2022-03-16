    public final static int readInt32BE(byte[] data, int ofs)
    {
    	return ( data[ofs    ]         << 24) |
    		   ((data[ofs + 1] & 0xff) << 16) |
	           ((data[ofs + 2] & 0xff) <<  8) |
	            (data[ofs + 3] & 0xff);
    }


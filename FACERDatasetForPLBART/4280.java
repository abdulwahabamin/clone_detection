	public void process(
			byte[] inbuf, 
			int inOfs, 
			byte[] outbuf, 
			int outOfs, 
			int len) throws ESJException 
	{
        int s11 = s[0];
        int s12 = s[1];
        int s13 = s[2];
        int s21 = s[3];
        int s22 = s[4];
        int s23 = s[5];
        int s31 = s[6];
        int s32 = s[7];
        int s33 = s[8];
        int s34 = s[9];
        
        int outEnd = outOfs + (len & ~3); 
        
        for (; outOfs < outEnd; outOfs+=4, inOfs+=4)
        {
        	int t1, t2, t3, reg;
        	
            t1 = ((s13 << 96-66) | (s12 >>> 66-64)) ^ ((s13 <<  96-93 ) | (s12 >>>  93-64)); 
            t2 = ((s23 << 96-69) | (s22 >>> 69-64)) ^ ((s23 <<  96-84 ) | (s22 >>>  84-64)); 
            t3 = ((s33 << 96-66) | (s32 >>> 66-64)) ^ ((s34 << 128-111) | (s33 >>> 111-96));
            
            reg = t1 ^ t2 ^ t3;
            outbuf[outOfs    ] = (byte)(inbuf[inOfs    ] ^ reg); 
            outbuf[outOfs + 1] = (byte)(inbuf[inOfs + 1] ^ reg >> 8); 
            outbuf[outOfs + 2] = (byte)(inbuf[inOfs + 2] ^ reg >> 16); 
            outbuf[outOfs + 3] = (byte)(inbuf[inOfs + 3] ^ reg >> 24); 

            t1 ^= (((s13 <<  96-91 ) | (s12 >>>  91-64)) & ((s13 <<  96-92 ) | (s12 >>>  92-64))) ^ ((s23 << 96-78) | (s22 >>> 78-64)); 
            t2 ^= (((s23 <<  96-82 ) | (s22 >>>  82-64)) & ((s23 <<  96-83 ) | (s22 >>>  83-64))) ^ ((s33 << 96-87) | (s32 >>> 87-64)); 
            t3 ^= (((s34 << 128-109) | (s33 >>> 109-96)) & ((s34 << 128-110) | (s33 >>> 110-96))) ^ ((s13 << 96-69) | (s12 >>> 69-64)); 
            
            s13 = s12; s12 = s11; s11 = t3;          
            s23 = s22; s22 = s21; s21 = t1;          
            s34 = s33; s33 = s32; s32 = s31; s31 = t2; 
        }
        
        // NOTE: could save some code memory by merging the two blocks, but that
        // would decrease the speed because of additional conditional jumps...
        outEnd = outOfs + (len & 3);
        //if (0 < outEnd)
        if (outOfs < outEnd) // Peli: Apr 3, 2009: BUGFIX
        {
        	int t1, t2, t3, reg;
        	
            t1 = ((s13 << 96-66) | (s12 >>> 66-64)) ^ ((s13 <<  96-93 ) | (s12 >>>  93-64)); 
            t2 = ((s23 << 96-69) | (s22 >>> 69-64)) ^ ((s23 <<  96-84 ) | (s22 >>>  84-64)); 
            t3 = ((s33 << 96-66) | (s32 >>> 66-64)) ^ ((s34 << 128-111) | (s33 >>> 111-96));
            
            reg = t1 ^ t2 ^ t3;
            for (;outOfs < outEnd; outOfs++, inOfs++)
            {
            	outbuf[outOfs] = (byte)(inbuf[inOfs] ^ reg);
            	reg >>= 8;
            }

            t1 ^= (((s13 <<  96-91 ) | (s12 >>>  91-64)) & ((s13 <<  96-92 ) | (s12 >>>  92-64))) ^ ((s23 << 96-78) | (s22 >>> 78-64)); 
            t2 ^= (((s23 <<  96-82 ) | (s22 >>>  82-64)) & ((s23 <<  96-83 ) | (s22 >>>  83-64))) ^ ((s33 << 96-87) | (s32 >>> 87-64)); 
            t3 ^= (((s34 << 128-109) | (s33 >>> 109-96)) & ((s34 << 128-110) | (s33 >>> 110-96))) ^ ((s13 << 96-69) | (s12 >>> 69-64)); 
            
            s13 = s12; s12 = s11; s11 = t3;          
            s23 = s22; s22 = s21; s21 = t1;          
            s34 = s33; s33 = s32; s32 = s31; s31 = t2; 
        }
        
        s[0] = s11;
        s[1] = s12;
        s[2] = s13;
        s[3] = s21;
        s[4] = s22;
        s[5] = s23;
        s[6] = s31;
        s[7] = s32;
        s[8] = s33;
        s[9] = s34;
	}


		private static String csRandomAlphaNumericString(int numChars) {
		    SecureRandom srand = new SecureRandom();
		    char[] buff = new char[numChars];

		    for (int i = 0; i < numChars; ++i) {
		      // reseed random once you've used up all available entropy bits
		      if ((i % 10) == 0) {
		          srand.setSeed(srand.nextLong()); // 64 bits of random!
		      }
		      buff[i] = VALID_CHARACTERS[srand.nextInt(VALID_CHARACTERS.length)];
		    }
		    return new String(buff);
		}


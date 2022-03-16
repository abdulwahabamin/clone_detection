    private final String compXmlStringAt(byte[] arr, int strOff) {
      int strLen = arr[strOff+1]<<8&0xff00 | arr[strOff]&0xff;
      byte[] chars = new byte[strLen];
      for (int ii=0; ii<strLen; ii++) {
        chars[ii] = arr[strOff+2+ii*2];
      }
      return new String(chars);  // Hack, just use 8 byte chars
    } // end of compXmlStringAt


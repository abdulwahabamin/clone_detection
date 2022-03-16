        /**
         * {@inheritDoc}
         */
        @Override
        public void run() {
            try {
                this.mAlive = true;
                while (this.mAlive) {
                   synchronized (AsyncResultProgram.this.mSync) {
                       AsyncResultProgram.this.mSync.wait();
                       while (AsyncResultProgram.this.mPartialData.size() > 0) {
                           Byte type = AsyncResultProgram.this.mPartialDataType.remove(0);
                           byte[] data = AsyncResultProgram.this.mPartialData.remove(0);
                           try {
                               if (type.compareTo(STDIN) == 0) {
                                   AsyncResultProgram.this.onParsePartialResult(data);
                               } else {
                                   AsyncResultProgram.this.onParseErrorPartialResult(data);
                               }
                           } catch (Throwable ex) {
                               /**NON BLOCK**/
                           }
                       }
                   }
                }
            } catch (Exception e) {
                /**NON BLOCK**/
            }
        }


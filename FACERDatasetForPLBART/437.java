        public void write (byte[] bytes){

            try {
                // outputStream değerini yaz
                outputStream.write(bytes);
                // hata yakalama
            } catch (IOException e) {
                // hatayı yazdır
                e.printStackTrace();
            }
        }


        public String getFormattedLength() {
            if (length % 60 < 10) {
                return length / 60 + ":0" + length % 60;
            }
            return length / 60 + ":" + length % 60;
        }


        @Override
        public int compare(City cityLeft, City cityRight) {

            char a = cityLeft.countryEn.charAt(0);
            char b = cityRight.countryEn.charAt(0);

            return a-b;
        }


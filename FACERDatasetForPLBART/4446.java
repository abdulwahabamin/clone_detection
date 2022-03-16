    public static int getAge(Cal age) {
        Cal today = new Cal();
        today.set(today.YEAR,today.get(today.YEAR) - age.get(age.YEAR));
        today.set(today.DAY_OF_YEAR,today.get(today.DAY_OF_YEAR) - age.get(age.DAY_OF_YEAR));
        return today.get(today.YEAR);
    }


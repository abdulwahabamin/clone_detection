  /**
   * JDNToJulian: Calculates Julian calendar dates from the julian day number
   * (JDN) for the period since JDN=-34839655 (i.e. the year -100100 of both
   * calendars) to some millions (10^6) years ahead of the present. The
   * algorithm is based on D.A. Hatcher, Q.Jl.R.Astron.Soc. 25(1984), 53-55
   * slightly modified by K.M. Borkowski, Post.Astron. 25(1987), 275-279).
   */
  private void JDNToJulian() {
    int j = 4 * JDN + 139361631;
    int i = ((j % 1461) / 4) * 5 + 308;
    juMonth = ((i / 153) % 12) + 1;
  }


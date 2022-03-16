  /**
   * Get query of itemHourlyDBBox according to fiveDayWeatherId value
   *
   * @param itemHourlyDBBox  instance of {@link Box<ItemHourlyDB>}
   * @param fiveDayWeatherId int key of five day weather id
   * @return instance of {@link Query<ItemHourlyDB>}
   */
  public static Query<ItemHourlyDB> getItemHourlyDBQuery(Box<ItemHourlyDB> itemHourlyDBBox, long fiveDayWeatherId) {
    return itemHourlyDBBox.query()
        .equal(ItemHourlyDB_.fiveDayWeatherId, fiveDayWeatherId)
        .build();
  }


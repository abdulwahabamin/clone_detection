    /**
     * Generates and formats for display an explanation how to search for new cities.
     *
     * @param res app resources
     * @return formatted text to be displayed in a text view
     */
    public static String getNoCitiesFoundDialogMessage(Resources res) {
        String dialogMessage = NO_CITIES_FOUND_MESSAGE_PART_PREFIX;
        dialogMessage += res.getString(R.string.message_no_cities_found_part_1);
        dialogMessage += "\n";
        dialogMessage += NO_CITIES_FOUND_MESSAGE_PART_PREFIX;
        dialogMessage += res.getString(R.string.message_no_cities_found_part_2);
        dialogMessage += "\n";
        dialogMessage += NO_CITIES_FOUND_MESSAGE_PART_PREFIX;
        dialogMessage += res.getString(R.string.message_no_cities_found_part_3);
        dialogMessage += NO_CITIES_FOUND_MESSAGE_COORDINATES;
        return dialogMessage;
    }


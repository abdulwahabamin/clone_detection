                public static <E extends Number> NumberType fromNumber(E value) throws IllegalArgumentException {
                        if (value instanceof Long) {
                                return LONG;
                        }
                        if (value instanceof Double) {
                                return DOUBLE;
                        }
                        if (value instanceof Integer) {
                                return INTEGER;
                        }
                        if (value instanceof Float) {
                                return FLOAT;
                        }
                        if (value instanceof Short) {
                                return SHORT;
                        }
                        if (value instanceof Byte) {
                                return BYTE;
                        }
                        if (value instanceof BigDecimal) {
                                return BIG_DECIMAL;
                        }
                        throw new IllegalArgumentException("Number class '" + value.getClass().getName() + "' is not supported");
                }


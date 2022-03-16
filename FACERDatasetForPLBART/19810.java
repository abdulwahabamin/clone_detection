                public Number toNumber(double value) {
                        switch (this) {
                        case LONG:
                                return new Long((long) value);
                        case DOUBLE:
                                return value;
                        case INTEGER:
                                return new Integer((int) value);
                        case FLOAT:
                                return new Float(value);
                        case SHORT:
                                return new Short((short) value);
                        case BYTE:
                                return new Byte((byte) value);
                        case BIG_DECIMAL:
                                return new BigDecimal(value);
                        }
                        throw new InstantiationError("can't convert " + this + " to a Number object");
                }


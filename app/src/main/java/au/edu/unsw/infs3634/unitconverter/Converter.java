package au.edu.unsw.infs3634.unitconverter;

import android.view.View;
import android.widget.Spinner;

public class Converter {

    public enum Unit {
        /**MEASURING**/INCH,
        /**MEASURING**/CENTIMETRE,
        /**MEASURING**/FOOT,
        /**MEASURING**/YARD,
        /**MEASURING**/METRE,
        /**MEASURING**/MILE,
        /**MEASURING**/KILOMETRE,
        /**MEASURING**/MILLIMETRE,
        /**MASS**/OUNCE,
        /**MASS**/POUND,
        /**MASS**/STONE,
        /**MASS**/GRAM,
        /**MASS**/KILOGRAM,
        /**MASS**/TONNE,
        millilitre,
        LITRE,
        PINT,
        GALLON;

        public static Unit converterString(String value) {
            if (value != null) {
                for (Unit unit : Unit.values()) {
                    if (value.equalsIgnoreCase(unit.toString())) {
                        return unit;
                    }
                }
            }

            throw new IllegalArgumentException("Cannot find a value for " + value);
        }


    }

    private final double multiplier;

    public Converter (Unit convertFrom, Unit convertTo) {
        double constantValue = 1;

        /**completed**/switch(convertFrom) {
            case INCH:
                if (convertTo == Unit.CENTIMETRE) {
                    constantValue = 2.54;
                } else if (convertTo == Unit.FOOT) {
                    constantValue = 0.08333333;
                } else if (convertTo == Unit.YARD) {
                    constantValue = 0.02777808;
                } else if (convertTo == Unit.MILE) {
                    constantValue = 1.5783e-5;
                } else if (convertTo == Unit.METRE) {
                    constantValue = 0.0254;
                } else if (convertTo == Unit.KILOMETRE) {
                    constantValue = 2.54e-5;
                } else if (convertTo == Unit.MILLIMETRE) {
                    constantValue = 25.4;
                } else System.out.println("Cannot Convert invalid Value");
                break;

            case CENTIMETRE:
                if (convertTo == Unit.INCH) {
                    constantValue = 0.393701;
                } else if (convertTo == Unit.FOOT) {
                    constantValue = 0.0328084;
                } else if (convertTo == Unit.YARD) {
                    constantValue = 0.0109361;
                } else if (convertTo == Unit.MILE) {
                    constantValue = 6.2137e-6;
                } else if (convertTo == Unit.METRE) {
                    constantValue = 0.01;
                } else if (convertTo == Unit.KILOMETRE) {
                    constantValue = 1e-5;
                } else if (convertTo == Unit.MILLIMETRE) {
                    constantValue = 10;
                } else System.out.println("Cannot Convert invalid Value");
                break;

            case FOOT:
                if (convertTo == Unit.CENTIMETRE) {
                    constantValue = 30.48;
                } else if (convertTo == Unit.INCH) {
                    constantValue = 12;
                } else if (convertTo == Unit.YARD) {
                    constantValue = 0.333333;
                } else if (convertTo == Unit.MILE) {
                    constantValue = 0.000189394;
                } else if (convertTo == Unit.METRE) {
                    constantValue = 0.3048;
                } else if (convertTo == Unit.KILOMETRE) {
                    constantValue = 0.0003048;
                } else if (convertTo == Unit.MILLIMETRE) {
                    constantValue = 304.8;
                } else System.out.println("Cannot Convert invalid Value");
                break;

            case YARD:
                if (convertTo == Unit.CENTIMETRE) {
                    constantValue = 91.44;
                } else if (convertTo == Unit.FOOT) {
                    constantValue = 3;
                } else if (convertTo == Unit.INCH) {
                    constantValue = 36;
                } else if (convertTo == Unit.MILE) {
                    constantValue = 0.000568182;
                } else if (convertTo == Unit.METRE) {
                    constantValue = 0.9144;
                } else if (convertTo == Unit.KILOMETRE) {
                    constantValue = 0.0009144;
                } else if (convertTo == Unit.MILLIMETRE) {
                    constantValue = 914.4;
                } else System.out.println("Cannot Convert invalid Value");
                break;

            case MILE:
                if (convertTo == Unit.CENTIMETRE) {
                    constantValue = 160934;
                } else if (convertTo == Unit.FOOT) {
                    constantValue = 5280;
                } else if (convertTo == Unit.YARD) {
                    constantValue = 1760;
                } else if (convertTo == Unit.INCH) {
                    constantValue = 63360;
                } else if (convertTo == Unit.METRE) {
                    constantValue = 1609.34;
                } else if (convertTo == Unit.KILOMETRE) {
                    constantValue = 1.60934;
                } else if (convertTo == Unit.MILLIMETRE) {
                    constantValue = 1.609e+6;
                } else System.out.println("Cannot Convert invalid Value");
                break;

            case METRE:
                if (convertTo == Unit.CENTIMETRE) {
                    constantValue = 100;
                } else if (convertTo == Unit.FOOT) {
                    constantValue = 3.28084;
                } else if (convertTo == Unit.YARD) {
                    constantValue = 1.09361;
                } else if (convertTo == Unit.MILE) {
                    constantValue = 0.000621371;
                } else if (convertTo == Unit.INCH) {
                    constantValue = 39.3701;
                } else if (convertTo == Unit.KILOMETRE) {
                    constantValue = 0.001;
                } else if (convertTo == Unit.MILLIMETRE) {
                    constantValue = 1000;
                } else System.out.println("Cannot Convert invalid Value");
                break;

            case KILOMETRE:
                if (convertTo == Unit.CENTIMETRE) {
                    constantValue = 100000;
                } else if (convertTo == Unit.FOOT) {
                    constantValue = 3280.84;
                } else if (convertTo == Unit.YARD) {
                    constantValue = 1093.61;
                } else if (convertTo == Unit.MILE) {
                    constantValue = 0.621371;
                } else if (convertTo == Unit.METRE) {
                    constantValue = 1000;
                } else if (convertTo == Unit.INCH) {
                    constantValue = 39370.1;
                } else if (convertTo == Unit.MILLIMETRE) {
                    constantValue = 1000000;
                } else System.out.println("Cannot Convert invalid Value");
                break;

            case MILLIMETRE:
                if (convertTo == Unit.CENTIMETRE) {
                    constantValue = 0.1;
                } else if (convertTo == Unit.FOOT) {
                    constantValue = 0.00328084;
                } else if (convertTo == Unit.YARD) {
                    constantValue = 0.00109361;
                } else if (convertTo == Unit.MILE) {
                    constantValue = 6.21371e-7;
                } else if (convertTo == Unit.METRE) {
                    constantValue = 0.001;
                } else if (convertTo == Unit.KILOMETRE) {
                    constantValue = 1e-6;
                } else if (convertTo == Unit.INCH) {
                    constantValue = 0.0393701;
                } else System.out.println("Cannot Convert invalid Value");
                break;

            case OUNCE:
                if (convertTo == Unit.POUND) {
                    constantValue = 0.0625;
                } else if (convertTo == Unit.STONE) {
                    constantValue = 0.00446429;
                } else if (convertTo == Unit.GRAM) {
                    constantValue = 28.3495;
                } else if (convertTo == Unit.KILOGRAM) {
                    constantValue = 0.0283495;
                } else if (convertTo == Unit.TONNE) {
                    constantValue = 2.835e-5;
                } else System.out.println("Cannot Convert invalid Value");
                break;

            case POUND:
                if (convertTo == Unit.OUNCE) {
                    constantValue = 16;
                } else if (convertTo == Unit.STONE) {
                    constantValue = 0.0714286;
                } else if (convertTo == Unit.GRAM) {
                    constantValue = 453.592;
                } else if (convertTo == Unit.KILOGRAM) {
                    constantValue = 0.453592;
                } else if (convertTo == Unit.TONNE) {
                    constantValue = 0.000453592;
                } else System.out.println("Cannot Convert invalid Value");
                break;

            case STONE:
                if (convertTo == Unit.POUND) {
                    constantValue = 14;
                } else if (convertTo == Unit.OUNCE) {
                    constantValue = 224;
                } else if (convertTo == Unit.GRAM) {
                    constantValue = 6350.29;
                } else if (convertTo == Unit.KILOGRAM) {
                    constantValue = 6.35029;
                } else if (convertTo == Unit.TONNE) {
                    constantValue = 0.00635029;
                } else System.out.println("Cannot Convert invalid Value");
                break;

            case GRAM:
                if (convertTo == Unit.POUND) {
                    constantValue = 0.00220462;
                } else if (convertTo == Unit.STONE) {
                    constantValue = 0.000157473;
                } else if (convertTo == Unit.OUNCE) {
                    constantValue = 0.035274;
                } else if (convertTo == Unit.KILOGRAM) {
                    constantValue = 0.001;
                } else if (convertTo == Unit.TONNE) {
                    constantValue = 1e-6;
                } else System.out.println("Cannot Convert invalid Value");
                break;

            case KILOGRAM:
                if (convertTo == Unit.POUND) {
                    constantValue = 2.20462;
                } else if (convertTo == Unit.STONE) {
                    constantValue = 0.157473;
                } else if (convertTo == Unit.GRAM) {
                    constantValue = 1000;
                } else if (convertTo == Unit.OUNCE) {
                    constantValue = 35.274;
                } else if (convertTo == Unit.TONNE) {
                    constantValue = 0.001;
                } else System.out.println("Cannot Convert invalid Value");
                break;

            case TONNE:
                if (convertTo == Unit.POUND) {
                    constantValue = 2204.62;
                } else if (convertTo == Unit.STONE) {
                    constantValue = 157.473;
                } else if (convertTo == Unit.GRAM) {
                    constantValue = 1e+6;
                } else if (convertTo == Unit.KILOGRAM) {
                    constantValue = 1000;
                } else if (convertTo == Unit.OUNCE) {
                    constantValue = 35274;
                } else System.out.println("Cannot Convert invalid Value");
                break;
        }

        multiplier = constantValue;

    }

    public double convert(double inputValue) {
        return inputValue * multiplier;
    }








}

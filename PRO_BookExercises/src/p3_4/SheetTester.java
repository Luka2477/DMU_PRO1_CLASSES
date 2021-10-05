package p3_4;

public class SheetTester {
    public static void main(String[] args) {
        Sheet sheet = new Sheet();

        System.out.println(sheet.name() + " " + sheet.width() + "x" + sheet.height() + " | Expected: A0 841x1189");

        sheet.cutInHalf();
        System.out.println(sheet.name() + " " + sheet.width() + "x" + sheet.height() + " | Expected: A1 594x841");

        sheet.cutInHalf();
        System.out.println(sheet.name() + " " + sheet.width() + "x" + sheet.height() + " | Expected: A2 420x594");

        sheet.cutInHalf();
        System.out.println(sheet.name() + " " + sheet.width() + "x" + sheet.height() + " | Expected: A3 297x420");

        sheet.cutInHalf();
        System.out.println(sheet.name() + " " + sheet.width() + "x" + sheet.height() + " | Expected: A4 210x297");
    }
}

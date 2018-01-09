package com.example.jardine.cardgame;

/**
 * Created by jardine on 09/01/2018.
 */

public enum ImageURL {
    TWOCLUBS        ("@drawable/two_of_clubs"),
    THREECLUBS      ("@drawable/three_of_clubs"),
    FOURCLUBS       ("@drawable/four_of_clubs"),
    FIVECLUBS       ("@drawable/five_of_clubs"),
    SIXCLUBS        ("@drawable/six_of_clubs"),
    SEVENCLUBS      ("@drawable/seven_of_clubs"),
    EIGHTCLUBS      ("@drawable/eight_of_clubs"),
    NINECLUBS       ("@drawable/nine_of_clubs"),
    TENCLUBS        ("@drawable/ten_of_clubs"),
    JACKCLUBS       ("@drawable/jack_of_clubs"),
    QUEENCLUBS      ("@drawable/queen_of_clubs"),
    KINGCLUBS       ("@drawable/king_of_clubs"),
    ACECLUBS        ("@drawable/ace_of_clubs"),

    TWODIAMONDS     ("@drawable/two_of_diamonds"),
    THREEDIAMONDS   ("@drawable/three_of_diamonds"),
    FOURDIAMONDS    ("@drawable/four_of_diamonds"),
    FIVEDIAMONDS    ("@drawable/five_of_diamonds"),
    SIXDIAMONDS     ("@drawable/six_of_diamonds"),
    SEVENDIAMONDS   ("@drawable/seven_of_diamonds"),
    EIGHTDIAMONDS   ("@drawable/eight_of_diamonds"),
    NINEDIAMONDS    ("@drawable/nine_of_diamonds"),
    TENDIAMONDS     ("@drawable/ten_of_diamonds"),
    JACKDIAMONDS    ("@drawable/jack_of_diamonds"),
    QUEENDIAMONDS   ("@drawable/queen_of_diamonds"),
    KINGDIAMONDS    ("@drawable/king_of_diamonds"),
    ACEDIAMONDS     ("@drawable/ace_of_diamonds"),

    TW0HEARTS       ("@drawable/two_of_hearts"),
    THREEHEARTS     ("@drawable/three_of_hearts"),
    FOURHEARTS      ("@drawable/four_of_hearts"),
    FIVEHEARTS      ("@drawable/five_of_hearts"),
    SIXHEARTS       ("@drawable/six_of_hearts"),
    SEVENHEARTS     ("@drawable/seven_of_hearts"),
    EIGHTHEARTS     ("@drawable/eight_of_hearts"),
    NINEHEARTS      ("@drawable/nine_of_hearts"),
    TENHEARTS       ("@drawable/ten_of_hearts"),
    JACKHEARTS      ("@drawable/jack_of_hearts"),
    QUEENHEARTS     ("@drawable/queen_of_hearts"),
    KINGHEARTS      ("@drawable/king_of_hearts"),
    ACEHEARTS       ("@drawable/ace_of_hearts"),

    TWOSPADES       ("@drawable/two_of_spades"),
    THREESPADES     ("@drawable/three_of_spades"),
    FOURSPADES      ("@drawable/four_of_spades"),
    FIVESPADES      ("@drawable/five_of_spades"),
    SIXSPADES       ("@drawable/six_of_spades"),
    SEVENSPADES     ("@drawable/seven_of_spades"),
    EIGHTSPADES     ("@drawable/eight_of_spades"),
    NINESPADES      ("@drawable/nine_of_spades"),
    TENSPADES       ("@drawable/ten_of_spades"),
    JACKSPADES      ("@drawable/jack_of_spades"),
    QUEENSPADES     ("@drawable/queen_of_spades"),
    KINGSPADES      ("@drawable/king_of_spades"),
    ACESPADES       ("@drawable/ace_of_spades");

    private final String image;

    ImageURL(String imageString) {
        this.image = imageString;
    }

    public String getImage() {
        return image;
    }
}

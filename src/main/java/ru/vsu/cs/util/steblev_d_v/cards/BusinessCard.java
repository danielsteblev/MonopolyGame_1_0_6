package ru.vsu.cs.util.steblev_d_v.cards;

import ru.vsu.cs.util.steblev_d_v.Player;

public class BusinessCard  {

    private final String NAME;
    private final int PRICE;
    private Player owner;
    private final int PRICE_BUILD_ONE_HOUSE;
    private final int PRICE_BUILD_TWO_HOUSE;
    private final int PRICE_BUILD_THREE_HOUSE;
    private final int PRICE_BUILD_HOTEL;
    private final int RENT_FOR_ONE_HOUSE;
    private final int RENT_FOR_TWO_HOUSES;
    private final int RENT_FOR_THREE_HOUSES;
    private final int RENT_FOR_HOTEL;
    public BusinessCard(String NAME, int PRICE, int priceBuildOneHouse, int priceBuildTwoHouse, int priceBuildThreeHouse, int priceBuildHotel, int rentForOneHouse, int rentForTwoHouses, int rentForThreeHouses, int rentForHotel) {
        this.NAME = NAME;
        this.PRICE = PRICE;
        PRICE_BUILD_ONE_HOUSE = priceBuildOneHouse;
        PRICE_BUILD_TWO_HOUSE = priceBuildTwoHouse;
        PRICE_BUILD_THREE_HOUSE = priceBuildThreeHouse;
        PRICE_BUILD_HOTEL = priceBuildHotel;
        RENT_FOR_ONE_HOUSE = rentForOneHouse;
        RENT_FOR_TWO_HOUSES = rentForTwoHouses;
        RENT_FOR_THREE_HOUSES = rentForThreeHouses;
        RENT_FOR_HOTEL = rentForHotel;
    }

    public void setOwner(Player owner) {
        this.owner = owner;
    }

    public int getPRICE() {
        return PRICE;
    }

    public int getPRICE_BUILD_ONE_HOUSE() {
        return PRICE_BUILD_ONE_HOUSE;
    }

    public int getPRICE_BUILD_TWO_HOUSE() {
        return PRICE_BUILD_TWO_HOUSE;
    }

    public int getPRICE_BUILD_THREE_HOUSE() {
        return PRICE_BUILD_THREE_HOUSE;
    }

    public int getPRICE_BUILD_HOTEL() {
        return PRICE_BUILD_HOTEL;
    }

    public int getRENT_FOR_ONE_HOUSE() {
        return RENT_FOR_ONE_HOUSE;
    }

    public int getRENT_FOR_TWO_HOUSES() {
        return RENT_FOR_TWO_HOUSES;
    }

    public int getRENT_FOR_THREE_HOUSES() {
        return RENT_FOR_THREE_HOUSES;
    }

    public int getRENT_FOR_HOTEL() {
        return RENT_FOR_HOTEL;
    }
}

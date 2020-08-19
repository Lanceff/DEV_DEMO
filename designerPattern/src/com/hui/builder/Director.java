package com.hui.builder;

/**
 * @description: Ö¸»ÓÕß
 * @author: Lance
 * @create: 2020-07-24 10:58
 **/
public class Director {

    public Builder builder = null;

    Director(Builder builder) {
        this.builder = builder;
    }

    public void setBuilder(Builder builder) {
        this.builder = builder;
    }

    public House createHouser() {
        builder.builderBaise();
        builder.builderWall();
        builder.builderRoofed();
        return builder.builder();
    }
}

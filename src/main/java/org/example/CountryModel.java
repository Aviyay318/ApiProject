package org.example;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CountryModel {
    private String name;
    private String alpha2Code;
    private String alpha3Code;
    private List<String> borders;
    private int population;

    public String getName() {
        return name;
    }

    public String getAlpha2Code() {
        return alpha2Code;
    }

    public String getAlpha3Code() {
        return alpha3Code;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAlpha2Code(String alpha2Code) {
        this.alpha2Code = alpha2Code;
    }

    public void setAlpha3Code(String alpha3Code) {
        this.alpha3Code = alpha3Code;
    }

    public List<String> getBorders() {
        return borders;
    }

    public void setBorders(List<String> borders) {
        this.borders = borders;
    }

    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    @Override
    public String toString() {
        return "CountryModel{" +
                "name='" + name + '\'' +
                ", alpha2Code='" + alpha2Code + '\'' +
                ", alpha3Code='" + alpha3Code + '\'' +
                '}';
    }
}

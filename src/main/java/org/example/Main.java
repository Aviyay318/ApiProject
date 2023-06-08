package org.example;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import com.mashape.unirest.request.GetRequest;
import javassist.bytecode.analysis.SubroutineScanner;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try {
            GetRequest getRequest = Unirest.get("https://restcountries.com/v2/name/France");
            HttpResponse<String> response = getRequest.asString();
            //200- OK
            //404 - NOT FOUND
            //500 SERVER ISSUE
            Scanner scanner = new Scanner(System.in);
            System.out.println("Code:");
            System.out.println(response.getStatus());
            System.out.println("----------");
            System.out.println("JSON: ");
            String json = response.getBody();
            ObjectMapper objectMapper= new ObjectMapper();
            List<CountryModel> countryModel= objectMapper.readValue(json, new TypeReference<List<CountryModel>>() {
            });
            for (CountryModel countryModel1: countryModel){
                System.out.println(countryModel1.getBorders());

            }
            System.out.println("Please choose the country you want to know the population!!!!!!");
            String country = scanner.nextLine();
            getRequest= Unirest.get("https://restcountries.com/v2/alpha/"+country);



        } catch (UnirestException e) {
            throw new RuntimeException(e);
        } catch (JsonMappingException e) {
            throw new RuntimeException(e);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
package test;

import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.Test;

public class P01_Practice {

/*
    Verilen bilgileri türüne göre gruplayarak yazdirma islemi yapacagiz.
    Asagidaki gibi response elde edecegiz:
    {
"firstName":"Harika",
"lastName":"Wise",
"address":{
       "streetAddress":"Susam Sokagi",
       "city":"Ankara",
       "postalCode":"06100" },
"age":23,
"phoneNumbers":[
    {
       "number":"532-555 55 55",
      "type":"cep" },
    {
      "number":"0312-123 4567",
      "type":"ev " }
          ]
}
     */
@Test
    public void test01(){

    JSONObject person=new JSONObject();

    JSONObject address=new JSONObject();

    JSONArray phoneNumbers=new JSONArray();

    JSONObject homeNumber=new JSONObject();

    JSONObject cepNumber=new JSONObject();


    homeNumber.put( "number","0312-123 4567");
    homeNumber.put("type","ev");

    cepNumber.put( "number","532-555 55 55");
    cepNumber.put( "type","cep");

    phoneNumbers.put(0,cepNumber);
    phoneNumbers.put(1,homeNumber);

    address.put( "streetAddress","Susam Sokagi");
    address.put( "city","Ankara");
    address.put( "postalCode","06100");

    person.put("firstName","Harika");
    person.put("lastName","Wise");
    person.put("address",address);
    person.put("age",23);
    person.put("phoneNumbers",phoneNumbers);

    System.out.println(person);







}
}

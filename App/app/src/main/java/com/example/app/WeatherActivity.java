package com.example.app;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.DownloadManager;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.text.DecimalFormat;

    public class WeatherActivity extends AppCompatActivity {
        EditText etCity, etCountry;
        TextView tvResult;
        private final String url= "https://api.openweatehrmap.org/data/2.5/weather"; //Error with Url
        private final String appid="94a4143658ad8966e26f35512cd0f006";
        DecimalFormat df = new DecimalFormat("#.##");


        @SuppressLint({"MissingInflatedId", "WrongViewCast"})
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);
            etCity=findViewById(R.id.etCity);
            etCountry=findViewById(R.id.etCountry);
            tvResult=findViewById(R.id.tvResult); //Bug

        }

        public void getWeatherDetails(View view) {
            String weatherTracker[];
            weatherTracker = new String[8];
            int locationTracker[];
            locationTracker = new String[3];
            String tempUrl = "";
            String city = etCity.getText().toString().trim();
            String country = etCountry.getText().toString().trim();
            if(city.equals("")){
                tvResult.setText("City field can not be empty!");
            }else{
                if(!country.equals("")){
                    tempUrl = url + "?q=" + city + "," + country + "&appid=" + appid;
                }else{
                    tempUrl = url + "?q=" + city + "&appid=" + appid;
                }
                StringRequest stringRequest = new StringRequest(Request.Method.POST, tempUrl, new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        String output = "";
                        try {
                            JSONObject jsonResponse = new JSONObject(response);
                            JSONArray jsonArray = jsonResponse.getJSONArray("weather");
                            weatherTracker[0]=jsonArray;
                            JSONObject jsonObjectWeather = jsonArray.getJSONObject(0);
                            String description = jsonObjectWeather.getString("description");
                            weatherTracker[1]= description;
                            JSONObject jsonObjectMain = jsonResponse.getJSONObject("main");
                            double temp = jsonObjectMain.getDouble("temp") - 273.15;
                            weatherTracker[2] = temp;
                            double feelsLike = jsonObjectMain.getDouble("feels_like") - 273.15;
                            weatherTracker[3] = feelsLike;
                            float pressure = jsonObjectMain.getInt("pressure");
                            weatherTracker[4] = pressure;
                            int humidity = jsonObjectMain.getInt("humidity");
                            weatherTracker[5] = humidity;
                            JSONObject jsonObjectWind = jsonResponse.getJSONObject("wind");
                            String wind = jsonObjectWind.getString("speed");
                            weatherTracker[6] = wind;
                            JSONObject jsonObjectClouds = jsonResponse.getJSONObject("clouds");
                            String clouds = jsonObjectClouds.getString("all");
                            weatherTracker[7] = clouds;
                            JSONObject jsonObjectSys = jsonResponse.getJSONObject("sys");
                            locationTracker[0] = jsonObjectSys;
                            String countryName = jsonObjectSys.getString("country");
                            locationTracker[1] = countryName;
                            String cityName = jsonResponse.getString("name");
                            locationTracker[2] = cityName;
                            tvResult.setTextColor(Color.rgb(68,134,199));
                            output += "Current weather of " + cityName + " (" + countryName + ")"
                                    + "\n Temp: " + df.format(temp) + " °C"
                                    + "\n Feels Like: " + df.format(feelsLike) + " °C"
                                    + "\n Humidity: " + humidity + "%"
                                    + "\n Description: " + description
                                    + "\n Wind Speed: " + wind + "m/s (meters per second)"
                                    + "\n Cloudiness: " + clouds + "%"
                                    + "\n Pressure: " + pressure + " hPa";
                            tvResult.setText(output);
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener(){

                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(getApplicationContext(), error.toString().trim(), Toast.LENGTH_SHORT).show();
                    }
                });
                RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());
                requestQueue.add(stringRequest);
            }
            for (int i = 0; i < 8; i++){
                if(weatherTracker[i] == null){
                    System.out.println("Error at index " + i);
                }
            
            for (int i = 0; i < 3; i++) {
                if(locationTracker[i] == null){
                    System.out.println("Error at index " + i);
                }
            }
            }
        }
    }


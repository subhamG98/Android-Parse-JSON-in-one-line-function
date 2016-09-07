# Android-Database-Connection
This repository will help Android developers to make connection with HTTP clients and put JSON data into Recycler View in just 1 simple function call. No need to establish any Async Task or set up any Adapters for Recycler View.
#### All you need to give is the url of the JSON file and your xml layout about how to parameters should appear.

======

Click on below image to see video tutorial

[![Youtube tutorial link](http://hello45.esy.es/Screenshot%202016-09-07%2016.12.48.png)](https://www.youtube.com/watch?v=UoWdr-Fgla8)

# Download:

## Maven:
        <dependency>
        <groupId>com.dbconnection.subham.dblibrary</groupId>
        <artifactId>dblibrary</artifactId>
        <version>1.0</version>
        <type>pom</type>
        </dependency>


## Gradle:

####compile 'com.dbconnection.subham.dblibrary:dblibrary:1.0'


---


Here you can see the sample java file where you can use this function.


public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        View v = new MyView(this);
        setContentView(v);

        String[] tagnames={"SNO","Paper","Country"}; //These are the keys of the JSON ARRay
        String[] tagtype={"text","text","text"}; //This is type of value, it can be text or image
        String arrayname="seating_plan";// This is the name of array of JSON File
         MyView.setinputdata("http://scrapplabs.esy.es/subham.php",arrayname,tagnames,tagtype,R.layout.list_card_view);

//As you see you need to pass only URL, Name of result array,names of key in JSON key value pairs,And a layout file to see the results.Make sure while making layout files you give id to each elements as p1,p2,p3..... as specifie in tagnames.


    }

}

=====

##BLOG
#Visit guptasubham.blogspot.in for tutorial on using this library.
====
## License:


Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

   http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.

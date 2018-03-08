# Java 8 Västtrafik Desktop App

Personal ongoing exploratory project creating a Java app for Gothenburgs public transit company Västtrafik and their API "Reseplaneraren V2".

## PLEASE  NOTE!

* This shared code is not in a functional state (read more about this bellow)
* I am by no means a professional programmer, beware of ugly/bad code ahead!
* A working runnable jar can be downloaded from here [Studio Tumult](http://studiotumult.blogspot.se/p/programingit.html)

## Why the shared code dosen't work

Västtrafiks' API uses Oauth2 authentication which requires keys given when creating a application/project on their [developer portal](https://developer.vasttrafik.se/portal/#/). I'm not a experienced coder, but what i gather is that keys for authentication should not be public. I wanted to upload to be able to share it, but until I learn more, I've removed keys from the code which makes it non functional. 

## How to get it to run
There are som small changes that will make it possible to run. First off, a Västtrafik developer account [needs to be registered](https://developer.vasttrafik.se/portal/#/) and approved. When able to log in, a new application needs to created, and finally a subscription to "Reseplaneraren v2" API needs to be set. A guide can be [found here](https://developer.vasttrafik.se/portal/#/guides/get-started).

When an application is set up it's possible to generate keys for the application. Theese keys can then be inserted as Strings in the method generateAcessToken() in the class src.auth.AccessTokenHandler where I've commented on where to insert what. More info can be found in Västtrafiks [Oauth2 guide](https://developer.vasttrafik.se/portal/#/guides/oauth2).
